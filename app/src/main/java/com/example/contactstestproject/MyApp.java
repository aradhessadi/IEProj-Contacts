package com.example.contactstestproject;

import android.app.Application;

import com.example.contactstestproject.utils.ApplicationUtils;
import com.example.contactstestproject.utils.contacts.ContactsObserver;

public class MyApp extends Application {

    ContactsObserver mContactsObserver;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtils.setContext(getApplicationContext());
        mContactsObserver = new ContactsObserver();
        mContactsObserver.setData();
    }
}
