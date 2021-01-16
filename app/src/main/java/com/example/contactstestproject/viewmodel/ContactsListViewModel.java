package com.example.contactstestproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.repository.ContactsRepository;

import java.util.List;

public class ContactsListViewModel extends AndroidViewModel {

    private final ContactsRepository mRepository;
    private final Application mApplication;

    public ContactsListViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mRepository = ContactsRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<List<Contact>> getContactsLiveData() {
        return mRepository.getContactsLiveData();
    }

    public void insertContacts() {
        mRepository.setContactsList(mApplication.getApplicationContext());
    }
}
