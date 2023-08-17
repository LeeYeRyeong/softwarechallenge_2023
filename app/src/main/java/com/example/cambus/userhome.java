package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class userhome extends AppCompatActivity {

    private Button button1; //로그아웃 버튼
    private Button button2; //글 작성 버튼

    private ImageButton button3; //내 공구 현황으로
    private ImageButton gouser;
    private ImageButton godepartment;
    private ImageButton goschool;
    private ImageButton goedit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        button1 = findViewById(R.id.log_out);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.writing);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this, writego.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.ib_mylist);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this, mylist.class);
                startActivity(intent);
            }
        });
        goschool = findViewById(R.id.ib_goschool);
        goschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this,firstpage.class);
                startActivity(intent);

            }
        });

        godepartment = findViewById(R.id.ib_godepartment);
        godepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this,department_home.class);
                startActivity(intent);
            }
        });

        gouser = findViewById(R.id.ib_gouser);
        gouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this,userhome.class);
                startActivity(intent);
            }
        });

        goedit = findViewById(R.id.edit_buy);
        goedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userhome.this, edit_buy.class);
                startActivity(intent);
            }
        });





    }
}
