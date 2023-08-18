package com.example.cambus;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    final static private String URL = "";
    private Map<String, String> map;

    public LoginRequest(String userEmail, String userPassword, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userEmail", userEmail);
        map.put("userPassword",userPassword);
    }

    protected Map<String, String>getParams() throws AuthFailureError{
        return map;
    }
}