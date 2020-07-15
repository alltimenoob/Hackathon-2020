package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hackathon.handlers.DatabaseHandler;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Test extends AppCompatActivity {

    EditText test;
    Button testbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        test = findViewById(R.id.testedittext);
        testbutton = findViewById(R.id.testbutton);

        testbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.43.149/hackathon/GetToken.php";
                String email = test.getText().toString();

                Map<String ,String> values = new HashMap<>();
                values.put("email",email);

                DatabaseHandler databaseHandler = new DatabaseHandler(Test.this,url) {
                    @Override
                    public void getResponse(String response) throws JSONException {
                        String token = response;

                        try {
                            JSONObject notificationContent = new JSONObject("{'contents': {'en': 'The notification message or body'}," +
                                    "'include_player_ids': ['" + token + "'], " +
                                    "'headings': {'en': 'Notification Title'} }");
                            OneSignal.postNotification(notificationContent, null);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                databaseHandler.putValues(values);
                databaseHandler.execute();
            }
        });
    }
}
