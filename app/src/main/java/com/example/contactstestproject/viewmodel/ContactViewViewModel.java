package com.example.contactstestproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.repository.ContactsRepository;

public class ContactViewViewModel extends AndroidViewModel {

    private LiveData<Contact> mContact;
    private ContactsRepository mRepository;
    private Application mApplication;

    public ContactViewViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Contact> getContactLiveData(){
        return null;
    }

    public Contact getContact(){
        return null;
    }
}
