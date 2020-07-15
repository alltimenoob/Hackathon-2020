package com.example.hackathon.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hackathon.Init;
import com.example.hackathon.R;
import com.example.hackathon.handlers.DatabaseHandler;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText emailEdit, passwordEdit, nameEdit;
    Button signupButton;

    TextView loginLink;
    String email, password, name;

    String url = Init.ip+"Signup.php";

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        emailEdit = findViewById(R.id.email_signup);
        passwordEdit = findViewById(R.id.password_signup);
        nameEdit = findViewById(R.id.name_signup);

        signupButton = findViewById(R.id.signup_button_signup);

        loginLink = findViewById(R.id.login_link_signup);

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoLogin();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signupOperation();
            }
        });


    }

    private void gotoLogin() {
        intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void signupOperation()
    {
        email = emailEdit.getText().toString();
        password = passwordEdit.getText().toString();
        name = nameEdit.getText().toString();

        if (email.isEmpty() || password.isEmpty() || name.isEmpty())
        {
            Toast.makeText(this,"Please Provide All Details !",Toast.LENGTH_SHORT).show();
        }
        else if (password.length() < 8)
        {
            Toast.makeText(this,"Password Should Be 8 Character Long",Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseOperation();
            gotoLogin();
        }
    }

         private void databaseOperation()
         {
             Map<String ,String> values = new HashMap<>();
             values.put("email",email);
             values.put("password",password);
             values.put("name",name);

             DatabaseHandler databaseHandler = new DatabaseHandler(SignupActivity.this,url) {
                 @Override
                 public void getResponse(String response) throws JSONException {
                     JSONObject object = new JSONObject(response);
                     Toast.makeText(SignupActivity.this,object.getString("message"),Toast.LENGTH_SHORT).show();
                 }
             };

             databaseHandler.putValues(values);
             databaseHandler.execute();
         }
}
