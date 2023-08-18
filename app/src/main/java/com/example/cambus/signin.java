package com.example.cambus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class signin extends AppCompatActivity {

    private EditText et_joinName, et_joinNumber, et_joinMajor, et_joinEmail, et_joinPassword, et_joinPasswordCheck;
    private Button bt_joinSubmit;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        et_joinName = findViewById(R.id.et_joinName);
        et_joinNumber = findViewById(R.id.et_joinNumber);
        et_joinEmail = findViewById(R.id.et_joinEmail);
        et_joinPassword = findViewById(R.id.et_joinPassword);
        et_joinPasswordCheck = findViewById(R.id.et_joinPasswordCheck);

        bt_joinSubmit = bt_joinSubmit.findViewById(R.id.bt_joinSubmit);
        bt_joinSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userName = et_joinName.getText().toString();
                final String userNumber = et_joinNumber.getText().toString();
                final String userMajor = et_joinMajor.getText().toString();
                final String userEmail = et_joinEmail.getText().toString();
                final String userPassword = et_joinPassword.getText().toString();

                if(userName.equals("") || userNumber.equals("") || userMajor.equals("") || userEmail.equals("") || userPassword.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(signin.this);
                    dialog = builder.setMessage("모두 입력하시오").setNegativeButton("확인",null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(userPassword.equals(et_joinPasswordCheck)){
                                if(success){
                                    Toast.makeText(getApplicationContext(),String.format("%s님 가입을 환영합니다.",userName),Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(signin.this, login.class);
                                    startActivity(intent);
                                } else{
                                    Toast.makeText(getApplicationContext(),"회원가입에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(signin.this);
                                dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인",null).create();
                                dialog.show();
                                return;
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userName, userNumber, userMajor, userEmail, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(signin.this);
                queue.add(registerRequest);
            }

        });
    }
}