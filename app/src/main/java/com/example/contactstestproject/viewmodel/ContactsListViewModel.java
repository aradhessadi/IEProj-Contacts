package com.example.contactstestproject.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.repository.ContactsRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactsListViewModel extends AndroidViewModel {

    private LiveData<List<Contact>> mContactsLiveData;
    private ContactsRepository mRepository;
    private Application mApplication;

    public ContactsListViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mRepository = ContactsRepository.getInstance(application.getApplicationContext());
        fetchData();
    }

    public LiveData<List<Contact>> getContactsLiveData() {
        return mContactsLiveData;
    }

    public void fetchData() {
        mContactsLiveData = mRepository.getContactsLiveData();
    }

    public void insertContacts() {
        mRepository.setContactsList(mApplication.getApplicationContext());
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = mContactsLiveData.getValue();
        return contacts == null ? new ArrayList<Contact>() : contacts;
    }
}
