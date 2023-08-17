package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cambus.R;
import com.example.cambus.department_home;
import com.example.cambus.fristbuyActivity;
import com.example.cambus.schoolnoticegoActivity;
import com.example.cambus.userhome;

public class firstpage extends AppCompatActivity {
    private Button button;
    private ImageButton button1;
    private ImageButton button2; //학교공지로 가는 버튼

    private ImageButton gouser;
    private ImageButton godepartment;
    private ImageButton goschool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_home);


        button = findViewById(R.id.choice);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this, fristbuyActivity.class);
                startActivity(intent);

            }
        });

        button1 = findViewById(R.id.ib_gobuy);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this, fristbuyActivity.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.ib_maincardnews);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this, schoolnoticegoActivity.class);
                startActivity(intent);
            }
        });


        goschool = findViewById(R.id.ib_goschool);
        goschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this,firstpage.class);
                startActivity(intent);

            }
        });

        godepartment = findViewById(R.id.ib_godepartment);
        godepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this, department_home.class);
                startActivity(intent);
            }
        });

        gouser = findViewById(R.id.ib_gouser);
        gouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this, userhome.class);
                startActivity(intent);
            }
        });

    }
}