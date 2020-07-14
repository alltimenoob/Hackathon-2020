package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                gotoNextActivity();

            }
        },500);
    }

    private void gotoNextActivity()
    {
        intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
