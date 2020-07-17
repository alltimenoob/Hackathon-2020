package com.example.hackathon.ngo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hackathon.Init;
import com.example.hackathon.R;
import com.example.hackathon.handlers.DatabaseHandler;
import com.example.hackathon.login.SplashActivity;
import com.google.android.gms.common.util.JsonUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcceptRequestActivity extends AppCompatActivity {

    String rno,city;

    String url = Init.ip+"NeedyAreaNGO.php";

    List<String> areas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accept_request_activity);

        rno = getIntent().getStringExtra("rno");
        city = getIntent().getStringExtra("city");

        areas = new ArrayList<>();


        Map<String,String> values = new HashMap<>();
        values.put("email",SplashActivity.sharedPrefrencesHandler.getEmail());
        values.put("city",city);

        DatabaseHandler databaseHandler = new DatabaseHandler(AcceptRequestActivity.this,url) {
            @Override
            public void getResponse(String response) throws Exception {
                JSONArray jsonArray =new JSONArray(response);

                for(int i = 0 ;i<jsonArray.length();i++)
                {
                    JSONObject object  = jsonArray.getJSONObject(i);
                    areas.add(object.getString("area"));
                }
            }
        };


        databaseHandler.putValues(values);
        databaseHandler.execute();

        Spinner spinner = findViewById(R.id.acceptrequest_area_spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(AcceptRequestActivity.this,android.R.layout.simple_spinner_item,areas);

        spinner.setAdapter(arrayAdapter);




    }
}