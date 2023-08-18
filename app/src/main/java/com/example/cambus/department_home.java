package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;

public class department_home extends AppCompatActivity {

    private ImageButton button;
    private ImageButton button1;
    private Button button2; //학교공지로 가는 버튼


    private ImageButton gouser;
    private ImageButton godepartment;
    private ImageButton goschool;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_home);

        button = findViewById(R.id.ib_maincardnews);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(department_home.this, departmentnotice.class);
                startActivity(intent);

            }
        });
        button1 =findViewById(R.id.ib_thumdnail);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(department_home.this,fristbuyActivity.class);
                startActivity(intent);
            }
        });
        button2 = findViewById(R.id.tb_gobuy);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(department_home.this,fristbuyActivity.class);
                startActivity(intent);
            }
        });

        goschool = findViewById(R.id.ib_goschool);
        goschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(department_home.this,firstpage.class);
                startActivity(intent);

            }
        });

        godepartment = findViewById(R.id.ib_godepartment);
        godepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(department_home.this,department_home.class);
                startActivity(intent);
            }
        });

        gouser = findViewById(R.id.ib_gouser);
        gouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(department_home.this,userhome.class);
                startActivity(intent);
            }
        });

        imageView =findViewById(R.id.ib_maincardnews);

        Intent intent = getIntent();
        if (intent != null) {
            String image = intent.getStringExtra("image");


            if (image != null) {
                Picasso.get().load(image).into(imageView);
            }
        }
    }
}


