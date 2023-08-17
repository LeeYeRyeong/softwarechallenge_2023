package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class departmentnotice extends AppCompatActivity {

    private LinearLayout noticeButtonContainer;
    private NotionApiService apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depart_notion);

        noticeButtonContainer = findViewById(R.id.noticeButtonContainer);
        apiService = RetrofitClient.getInstance().create(NotionApiService.class);

        // 공지사항 목록 가져오기
        fetchNotices();
    }

    private void fetchNotices() {
        Call<List<Notion>> call = apiService.getNotions();
        call.enqueue(new Callback<List<Notion>>() {
            @Override
            public void onResponse(Call<List<Notion>> call, Response<List<Notion>> response) {
                if (response.isSuccessful()) {
                    List<Notion> notices = response.body();
                    for (Notion notice : notices) {
                        // 각 공지사항 버튼 추가
                        addButton(notice.getTitle(), notice.getId(), notice.getImage());
                    }
                } else {
                    Toast.makeText(departmentnotice.this, "Failed to fetch notices", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Notion>> call, Throwable t) {
                Toast.makeText(departmentnotice.this, "Failed to fetch notices", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addButton(String title, int noticeId, String image) {
        // 버튼 생성 및 클릭 이벤트 처리
        Button button = new Button(this);
        button.setText(title);
        button.setOnClickListener(v -> openNoticeDetail(noticeId, image));
        noticeButtonContainer.addView(button);
    }

    private void openNoticeDetail(int noticeId, String image) {
        // 공지사항 상세 정보 페이지로 이동
        Call<Notion> call = apiService.getNotice(noticeId);
        call.enqueue(new Callback<Notion>() {
            @Override
            public void onResponse(Call<Notion> call, Response<Notion> response) {
                if (response.isSuccessful()) {
                    Notion notice = response.body();
                    if (notice != null) {
                        Intent intent = new Intent(departmentnotice.this, departmentnoticego.class);
                        intent.putExtra("title", notice.getTitle());
                        intent.putExtra("content", notice.getContent());
                        intent.putExtra("image", image);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(departmentnotice.this, "Failed to fetch notice details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Notion> call, Throwable t) {
                Toast.makeText(departmentnotice.this, "Failed to fetch notice details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}