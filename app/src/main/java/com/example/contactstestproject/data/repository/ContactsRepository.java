package com.example.contactstestproject.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.contactstestproject.data.ContactsDAO;
import com.example.contactstestproject.data.room.ContactsRoomDatabase;
import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.utils.ApplicationUtils;
import com.example.contactstestproject.utils.ContactSyncUtils;
import com.example.contactstestproject.utils.ThreadUtils;

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
                getDatabase(ApplicationUtils.getContext());
        mContactsDAO = contactsRoomDatabase.getContactsDAO();
        mContactSyncUtils = new ContactSyncUtils(ApplicationUtils.getContext());
    }

    @Override
    public LiveData<List<Contact>> getContactsLiveData() {
        return mContactsDAO.getList();
    }

    @Override
    public LiveData<Contact> getContactLiveData(final String id) {
        final MutableLiveData<Contact> liveData = new MutableLiveData<>();

        ThreadUtils.dataBaseWriteExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        Contact contact = mContactsDAO.getContact(id);
                        liveData.postValue(contact);
                    }
                }
        );
        return liveData;
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