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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmant);


        // 프래그먼트 객체 선언
        Fragment fragmentSchool = new school();
        Fragment fragmentDepartment = new department();
        Fragment fragmentUser = new user();

        //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragmentSchool).commitAllowingStateLoss();

        // 바텀 네비게이션 객체 선언
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 바텀 네비게이션 클릭 리스너 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.menu_schoolhome) {// replace(프레그먼트를 띄워줄 frameLayout, 교체할 fragment 객체)
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragmentSchool).commitAllowingStateLoss();
                    return true;
                } else if (itemId == R.id.menu_departmenthome) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragmentDepartment).commitAllowingStateLoss();
                    return true;
                } else if (itemId == R.id.menu_user) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragmentUser).commitAllowingStateLoss();
                    return true;
                }
                return false;
            }
        });
    }

}


