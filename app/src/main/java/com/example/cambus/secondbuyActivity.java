package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondbuyActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private Button bt_ps1;
    private Button bt_ps2;
    private Button bt_ps3;
    private Button bt_ps4;
    private Button bt_ps5;
    private TextView tv_op1;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_buy);


        bt_ps1 = findViewById(R.id.bt_ps1);//버튼 눌렀을 떄 그 버튼의 텍스트 가져오는거 모르겠음
        bt_ps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_op1.setText(bt_ps1.getText().toString());
            }
        });
        bt_ps2 = findViewById(R.id.bt_ps2);
        bt_ps3 = findViewById(R.id.bt_ps3);
        bt_ps4 = findViewById(R.id.bt_ps4);
        bt_ps5 = findViewById(R.id.bt_ps5);

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondbuyActivity.this, fristbuyActivity.class);
                startActivity(intent);//뒤로가기 버튼 구현
            }
        });
    }
}
