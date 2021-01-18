package com.example.contactstestproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactstestproject.data.repository.ContactsRepository;
import com.example.contactstestproject.model.Contact;

import java.util.List;

public class ContactsListViewModel extends ViewModel {

    private final ContactsRepository mRepository;

    public ContactsListViewModel() {
        mRepository = ContactsRepository.getInstance();
    }

    public LiveData<List<Contact>> getContactsLiveData() {
        return mRepository.getContactsLiveData();
    }

    public void insertContacts() {
        mRepository.insertContacts();
    }
}
