package com.example.cambus;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class editdepartment extends AppCompatActivity {

    private EditText editTextTitle, editTextContent;
    private Button buttonChooseImage, buttonUpload;
    private ImageView imageView;
    private Uri imageUri;

    private NotionApiService apiService;

    private ActivityResultLauncher<Intent> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_departmentform);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonChooseImage = findViewById(R.id.buttonChooseImage);
        buttonUpload = findViewById(R.id.buttonUpload);
        imageView = findViewById(R.id.imageView);

        apiService = RetrofitClient.getInstance().create(NotionApiService.class);

        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            imageUri = data.getData();
                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                                imageView.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );

        buttonChooseImage.setOnClickListener(v -> openGallery());

        buttonUpload.setOnClickListener(v -> uploadNotice());
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryLauncher.launch(intent);
    }

    private void uploadNotice() {
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();

        if (title.isEmpty() || content.isEmpty() || imageUri == null) {
            Toast.makeText(this, "Please fill in all fields and choose an image", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert image to byte array and create a MultipartBody.Part
        Bitmap bitmap;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), byteArrayOutputStream.toByteArray());
        MultipartBody.Part imagePart = MultipartBody.Part.createFormData("image", "image.jpg", requestBody);

        // Call the uploadNotice method
        apiService.uploadNotice(title, content, imagePart).enqueue(new Callback<Notion>() {
            @Override
            public void onResponse(Call<Notion> call, Response<Notion> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(editdepartment.this, "Notice uploaded successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(editdepartment.this, "Upload failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Notion> call, Throwable t) {
                Toast.makeText(editdepartment.this, "Upload failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearFields() {
        editTextTitle.setText("");
        editTextContent.setText("");
        imageView.setImageBitmap(null);
        imageUri = null;
    }
}