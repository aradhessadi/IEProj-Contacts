package com.example.contactstestproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.repository.ContactsRepository;

public class ContactViewViewModel extends AndroidViewModel {

    private LiveData<Contact> mContact;
    private ContactsRepository mRepository;
    private Application mApplication;

    public ContactViewViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mRepository = ContactsRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<Contact> getContactLiveData(String id){
        return mRepository.getContactLiveData(id);
    }
}
