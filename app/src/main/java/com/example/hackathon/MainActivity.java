package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static BottomNavigationView bottom;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        fragmentManager = getSupportFragmentManager();
        bottom = findViewById(R.id.bottomnav_main);

        bottom.setSelectedItemId(R.id.home_menu_main);
        fragmentManager.beginTransaction().add(R.id.container_main,new HomeScreenFragment(),null).commit();
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_menu_main :
                        fragment = new HomeScreenFragment();
                        break;

                    case R.id.account_menu_main:

                        break;

                }
                fragmentManager.beginTransaction().replace(R.id.container_main,fragment,null).commit();
                return true;
            }
        });
    }
}