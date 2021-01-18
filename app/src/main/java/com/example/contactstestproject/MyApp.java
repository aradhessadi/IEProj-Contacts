package com.example.contactstestproject;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.contactstestproject.ui.activity.SingleFragmentActivity;
import com.example.contactstestproject.utils.ApplicationUtils;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtils.setContext(getApplicationContext());
    }


}
