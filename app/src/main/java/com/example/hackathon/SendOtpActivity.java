package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SendOtpActivity extends AppCompatActivity {

    TextInputEditText emailEdit;
    Button sendOtpButton;

    String email;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_otp_activity);
        
        emailEdit = findViewById(R.id.email_reset);
        
        sendOtpButton = findViewById(R.id.send_otp_button_reset);
        
        sendOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOtpOperation();
            }
        });
    }

    private void sendOtpOperation() {

        email = emailEdit.getText().toString();

        if (email.isEmpty())
        {
            Toast.makeText(this,"Email Should Not Be Empty !",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,email+"",Toast.LENGTH_SHORT).show();

//            intent = new Intent(this,);
//            startActivity(intent);
        }

    }
}
