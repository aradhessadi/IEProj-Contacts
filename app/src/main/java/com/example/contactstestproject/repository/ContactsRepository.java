package com.example.contactstestproject.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;


import com.example.contactstestproject.database.ContactsDAO;
import com.example.contactstestproject.database.ContactsRoomDatabase;
import com.example.contactstestproject.model.Contact;

import java.util.List;

public class ContactsRepository implements IContactsRepository {

    private static ContactsRepository sRepository;
    private ContactsDAO mContactsDAO;

    public static ContactsRepository getInstance(Context context) {
        if (sRepository == null)
            sRepository = new ContactsRepository(context);

        return sRepository;
    }

    private ContactsRepository(Context context) {
        ContactsRoomDatabase contactsRoomDatabase = ContactsRoomDatabase.getDatabase(context);
        mContactsDAO = contactsRoomDatabase.getContactsDAO();
    }

    public LiveData<List<Contact>> getContactsLiveData() {
        return mContactsDAO.getList();
    }

    public LiveData<Contact> getContactLiveData(String name) {
        return mContactsDAO.getContact(name);
    }

    public void insert(Contact contact) {
        mContactsDAO.insert(contact);
    }
}