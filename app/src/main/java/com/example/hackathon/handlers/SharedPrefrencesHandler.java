package com.example.hackathon.handlers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrencesHandler {

    static SharedPreferences sharedPreferences ;
    static SharedPreferences.Editor editor;

    String name;
    String email;
    String address;
    String mobile;

    String type;
    boolean isLoggedIn;


    public SharedPrefrencesHandler(Context context) {
        sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        editor.putString("address",address);
        editor.commit();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        editor.putString("mobile",mobile);
        editor.commit();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        editor.putString("type",type);
        editor.commit();
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
