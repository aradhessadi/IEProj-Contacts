package com.example.contactstestproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactstestproject.data.repository.ContactsRepository;
import com.example.contactstestproject.model.Contact;

import java.util.List;

public class ContactDetailViewModel extends ViewModel {

    private final ContactsRepository mRepository;

    public ContactDetailViewModel() {
        mRepository = ContactsRepository.getInstance();
    }

    public LiveData<List<Contact>> getContactsLiveData() {
        return mRepository.getContactsLiveData();
    }

    public Contact getContactNewInfo(List<Contact> contacts, Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(contact.getId()))
                return contacts.get(i);
        }
        return null;
    }
}
