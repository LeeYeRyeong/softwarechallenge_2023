package com.example.cambus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class paymentcheck extends AppCompatActivity {
    Button buttonChange;
    TextView checkList;
    boolean isButtonClicked = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_confirmation);

        buttonChange = findViewById(R.id.bt_change);
        checkList = findViewById(R.id.check_list);

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isButtonClicked = !isButtonClicked;
                updateBackgroundColor();
            }
        });
    }

    private void updateBackgroundColor() {
        if (isButtonClicked) {
            buttonChange.setBackgroundResource(R.drawable.yrectangle);
        } else {
            buttonChange.setBackgroundResource(R.drawable.prectangle); // 변경할 다른 색상 리소스로 수정
        }
    }
}


