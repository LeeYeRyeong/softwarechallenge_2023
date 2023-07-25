package com.example.cambus;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Fragment category;
    Fragment school;
    Fragment department;
    Fragment user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_home);

        school = new Fragment();
        department = new Fragment();
        user = new Fragment();

        getSupportFragmentManager().beginTransaction().replace(androidx.fragment.R.id.action_container, school).commit();

    }
}



