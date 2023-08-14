package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class mylist extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);

        button1 = findViewById(R.id.tb_list);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mylist.this, buynotice.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.tb_check);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mylist.this,paymentcheck.class);
                startActivity(intent);
            }
        });
    }



}
