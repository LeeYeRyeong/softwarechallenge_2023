package com.example.cambus;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {
    private EditText et_loginEmail, et_loginPassword;
    private Button bt_loginSubmit;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_loginEmail = findViewById(R.id.et_loginEmail);
        et_loginPassword = findViewById(R.id.et_loginPassword);

        bt_loginSubmit = findViewById(R.id.bt_loginSubmit);
        bt_loginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = et_loginEmail.getText().toString();
                String userPassword = et_loginPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success){
                                String userEmail = jsonObject.getString("userEmail");
                                String userPassword = jsonObject.getString("userPassword");
                                String userName = jsonObject.getString("userName");
                                String userNumber = jsonObject.getString("userNumber");
                                String userMajor = jsonObject.getString("userMajor");

                                Toast.makeText(getApplicationContext(), String.format("%s님 환영합니다.",userName),Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login.this, MainActivity.class);

                                intent.putExtra("userEmail",userEmail);
                                intent.putExtra("userPassword",userPassword);
                                intent.putExtra("userName",userName);
                                intent.putExtra("userNumber",userNumber);
                                intent.putExtra("userMajor",userMajor);

                                startActivity(intent);
                            } else{
                                Toast.makeText(getApplicationContext(),"로그인에 실패하셨습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userEmail, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(login.this);
                queue.add(loginRequest);
            }
        });
    }
}