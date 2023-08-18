package com.example.cambus;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static private String URL = "";
    private Map<String, String> map;

    public RegisterRequest(String userName, String userNumber, String userMajor, String userEmail, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userName", userName);
        map.put("userNumber", userNumber);
        map.put("userMajor", userMajor);
        map.put("userEmail", userEmail);
        map.put("userPassword", userPassword);
    }
    @Override
    protected Map<String, String>getParams() throws AuthFailureError{
        return map;
    }
}