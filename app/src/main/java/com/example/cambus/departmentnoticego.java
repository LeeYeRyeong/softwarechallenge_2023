package com.example.cambus;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class departmentnoticego extends AppCompatActivity {
    private TextView textViewTitle;
    private TextView textViewContent;
    private ImageView imageView;
    private Button tb_noticelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_notice);
        tb_noticelist = findViewById(R.id.tb_noticelist);
        tb_noticelist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(departmentnoticego.this, departmentnotice.class);
                startActivity(intent);

            }
        });



        // 레이아웃 요소 초기화
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewContent = findViewById(R.id.textViewContent);
        imageView = findViewById(R.id.imageView);

        // 인텐트에서 데이터 가져오기
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String image = intent.getStringExtra("image");

            // 데이터 표시
            if (title != null && content != null) {
                textViewTitle.setText(title);
                textViewContent.setText(content);

                // 이미지 로딩 및 표시
                if (image != null) {
                    Picasso.get().load(image).into(imageView);
                }
            }
        }
    }

}
