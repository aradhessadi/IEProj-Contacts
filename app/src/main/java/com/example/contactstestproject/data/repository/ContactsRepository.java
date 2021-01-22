package com.example.contactstestproject.data.repository;

import androidx.lifecycle.LiveData;

import com.example.contactstestproject.data.ContactsDAO;
import com.example.contactstestproject.data.room.ContactsRoomDatabase;
import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.utils.ApplicationUtils;
import com.example.contactstestproject.utils.ThreadUtils;
import com.example.contactstestproject.utils.contacts.ContactSyncUtils;

import java.util.List;

public class ContactsRepository implements IContactsRepository {

    private static ContactsRepository sRepository;
    private final ContactsDAO mContactsDAO;
    private final ContactSyncUtils mContactSyncUtils;

    public static ContactsRepository getInstance() {
        if (sRepository == null)
            sRepository = new ContactsRepository();
        return sRepository;
    }

    private ContactsRepository() {
        ContactsRoomDatabase contactsRoomDatabase = ContactsRoomDatabase.
                getDatabase();
        mContactsDAO = contactsRoomDatabase.getContactsDAO();
        mContactSyncUtils = new ContactSyncUtils(ApplicationUtils.getContext());
    }

    @Override
    public LiveData<List<Contact>> getContactsLiveData() {
        return mContactsDAO.getList();
    }

    @Override
    public void clear() {
        mContactsDAO.clear();
    }

    @Override
    public void insertContacts() {
        ThreadUtils.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                clear();
                mContactSyncUtils.sync();
                mContactsDAO.insertContacts(mContactSyncUtils.getContacts().toArray(new Contact[]{}));
            }
        });
    }
}