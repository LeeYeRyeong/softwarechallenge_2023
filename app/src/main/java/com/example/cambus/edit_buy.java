package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class edit_buy extends AppCompatActivity {

    private Button button1; //학교 글쓰기 버튼
    private Button button2; //학과 글 작성 버튼

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_buy);

        button1 = findViewById(R.id.tb_schoolbuy);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(edit_buy.this, buy_school.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.tb_departmentbuy);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(edit_buy.this, buy_department.class);
                startActivity(intent);
            }
        });
    }
}