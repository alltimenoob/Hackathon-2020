package com.example.hackathon.donor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hackathon.R;

public class GalleryActivity extends AppCompatActivity {

    String email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);


        email = getIntent().getStringExtra("email");



    }
}