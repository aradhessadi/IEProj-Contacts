package com.example.contactstestproject.viewmodel;

import android.app.Application;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.contactstestproject.model.Contact;

import java.util.List;

public class ContactsListViewModel extends AndroidViewModel {

    private List<Contact> mContacts;

    public ContactsListViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Contact> getContacts(){
        return mContacts;
    }
}
