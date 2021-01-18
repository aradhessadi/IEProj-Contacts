package com.example.contactstestproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactstestproject.data.repository.ContactsRepository;
import com.example.contactstestproject.model.Contact;

public class ContactDetailViewModel extends ViewModel {

    private final ContactsRepository mRepository;

    public ContactDetailViewModel() {
        mRepository = ContactsRepository.getInstance();
    }

    public LiveData<Contact> getContactLiveData(String id) {
        return mRepository.getContactLiveData(id);
    }

    public void insertContacts() {
        mRepository.insertContacts();
    }
}
