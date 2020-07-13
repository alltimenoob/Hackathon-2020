package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ResetPasswordActivity extends AppCompatActivity {

    TextInputEditText otpEdit, newPasswordEdit;
    Button resetPasswordButton;

    String otp, newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password_activity);

        otpEdit = findViewById(R.id.otp_reset);
        newPasswordEdit = findViewById(R.id.password_reset);

        resetPasswordButton = findViewById(R.id.reset_password_button_reset);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetPasswordOperation();
            }
        });
    }

    private void resetPasswordOperation()
    {
        otp = otpEdit.getText().toString();
        newPassword = newPasswordEdit.getText().toString();

        if (otp.isEmpty() || newPassword.isEmpty())
        {
            Toast.makeText(this,"Otp & Password Should Not Be Empty !",Toast.LENGTH_SHORT).show();
        }
        else if (newPassword.length() < 8)
        {
            Toast.makeText(this,"Password Should Be 8 Character Long",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,otp+" "+newPassword,Toast.LENGTH_SHORT).show();
        }
    }
}
