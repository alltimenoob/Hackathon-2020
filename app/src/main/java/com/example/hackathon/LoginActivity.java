package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.hackathon.handlers.DatabaseHandler;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText emailEdit, passwordEdit;
    Button loginButton;

    TextView forgotPasswordLink, signupLink;
    String email, password;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        emailEdit = findViewById(R.id.email_login);
        passwordEdit = findViewById(R.id.password_login);

        forgotPasswordLink = findViewById(R.id.forgot_password_link_login);
        signupLink = findViewById(R.id.signup_link_login);

        loginButton = findViewById(R.id.login_button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginOperation();
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoSignup();
            }
        });

        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoForgotPassword();
            }
        });

    }

    private void loginOperation() {

        email = emailEdit.getText().toString();
        password = passwordEdit.getText().toString();

        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this,"Email & Password Should Not Be Empty !",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Map<String ,String> values = new HashMap<>();
            values.put("email",email);
            values.put("password",password);

            DatabaseHandler databaseHandler = new DatabaseHandler(LoginActivity.this,"http://192.168.0.104/hackathon/Login.php") {
                @Override
                public void getResponse(String response) {
                    Toast.makeText(LoginActivity.this,response,Toast.LENGTH_SHORT).show();
                }
            };

            databaseHandler.putValues(values);

            databaseHandler.execute();
        }

    }

    private void gotoSignup() {
        intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }

    private void gotoForgotPassword() {
        intent = new Intent(this,SendOtpActivity.class);
        startActivity(intent);
    }

}
