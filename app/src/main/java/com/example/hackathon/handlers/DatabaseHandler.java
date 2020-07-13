package com.example.hackathon.handlers;

import android.provider.ContactsContract;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class DatabaseHandler {

    public static DatabaseHandler object = null;
    public static Response.ErrorListener errorListener = null;
    public static Response.Listener responseListener = null;

    public static DatabaseHandler getInstance(final String url){

        if(object==null)
        {
            object = new DatabaseHandler();

            errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("VolleyError", "StringRequestError: "+error);
                }
            };

            responseListener =  new Response.Listener() {
                @Override
                public void onResponse(Object response) {
                    getResponse(url);
                }
            };

            return object;
        }
        else
        {
            return object;
        }
    }

    public static void getResponse(String url)
    {
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST,url,responseListener,errorListener);

    }
}
