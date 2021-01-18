package com.example.contactstestproject;

import android.app.Application;

import com.example.contactstestproject.utils.ApplicationUtils;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtils.setContext(getApplicationContext());
    }
}
