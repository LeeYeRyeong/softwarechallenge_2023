package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class schoolnoticegoActivity extends AppCompatActivity {
    private Button button;


    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_notice);

        button = findViewById(R.id.tb_noticelist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(schoolnoticegoActivity.this, schoolnotice.class);
                startActivity(intent);
            }
        });

    }

}
