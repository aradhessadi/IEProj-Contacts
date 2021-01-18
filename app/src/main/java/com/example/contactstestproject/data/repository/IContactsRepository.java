package com.example.contactstestproject.data.repository;

import androidx.lifecycle.LiveData;

import com.example.contactstestproject.model.Contact;

import java.util.List;

public interface IContactsRepository {

    LiveData<List<Contact>> getContactsLiveData();

    LiveData<Contact> getContactLiveData(String id);

    void clear();

    void insertContacts();
}
