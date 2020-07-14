package com.example.hackathon.handlers;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public abstract class DatabaseHandler {

    Context context = null;
    String Url = null;
    Map<String,String> map = null;
    RequestQueue requestQueue = null;

    public DatabaseHandler(Context context, String url)
    {
        this.context = context ;
        this.Url = url;
    }

    public abstract void getResponse(String response) throws JSONException;

    public void putValues(Map<String,String> map){
         this.map = map;
    }

    public void execute(){
        requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            getResponse(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VolleyError", "onErrorResponse: "+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };

        request.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 5000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 0;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        requestQueue.add(request);
    };



}
