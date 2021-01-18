package com.example.contactstestproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.data.repository.ContactsRepository;
import com.example.contactstestproject.utils.ApplicationUtils;

public class ContactViewViewModel extends ViewModel {

    private final ContactsRepository mRepository;

    public ContactViewViewModel() {
        mRepository = ContactsRepository.getInstance();
    }

    public LiveData<Contact> getContactLiveData(String id) {
        return mRepository.getContactLiveData(id);
    }

    public void insertContacts() {
        mRepository.insertContacts();
    }
}
