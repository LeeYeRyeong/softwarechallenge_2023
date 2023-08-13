package com.example.cambus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageButton button1;
    private ImageButton button2; //학교공지로 가는 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_home);


            button = findViewById(R.id.choice);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, fristbuyActivity.class);
                    startActivity(intent);

                }
            });

            button1 = findViewById(R.id.ib_gobuy);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, fristbuyActivity.class);
                    startActivity(intent);
                }
            });

            button2 = findViewById(R.id.ib_maincardnews);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, schoolnoticegoActivity.class);
                    startActivity(intent);
                }
            });
    }
}