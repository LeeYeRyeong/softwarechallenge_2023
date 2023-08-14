package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class writego extends AppCompatActivity {

    private Button button1; //학교 글쓰기 버튼
    private Button button2; //학과 글 작성 버튼

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writing);

        button1 = findViewById(R.id.tb_schoolWrite);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(writego.this, editschool.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.tb_departmentWrite);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(writego.this, editdepartment.class);
                startActivity(intent);
            }
        });


    }
}