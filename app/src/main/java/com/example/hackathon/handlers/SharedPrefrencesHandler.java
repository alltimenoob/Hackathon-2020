package com.example.hackathon.handlers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrencesHandler {

    static SharedPreferences sharedPreferences ;
    static SharedPreferences.Editor editor;

    String name,email;
    boolean isLoggedIn;

    public SharedPrefrencesHandler(Context context) {
        sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getName() {
        return sharedPreferences.getString("name","");
    }

    public void setName(String name) {
        editor.putString("name",name);
        editor.commit();
    }

    public String getEmail() {
        return sharedPreferences.getString("email","");
    }

    public void setEmail(String email) {
        editor.putString("email",email);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn",false);
    }

    public void setLoggedIn(boolean loggedIn) {
        editor.putBoolean("isLoggedIn",loggedIn);
        editor.commit();
    }
}
