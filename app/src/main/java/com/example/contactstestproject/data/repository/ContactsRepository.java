package com.example.contactstestproject.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.contactstestproject.data.ContactsDAO;
import com.example.contactstestproject.data.room.ContactsRoomDatabase;
import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.utils.ApplicationUtils;
import com.example.contactstestproject.utils.ContactSyncUtils;

import java.util.List;

public class ContactsRepository implements IContactsRepository {

    private static ContactsRepository sRepository;
    private final ContactsDAO mContactsDAO;
    private ContactSyncUtils mContactSyncUtils;

    public static ContactsRepository getInstance() {
        if (sRepository == null)
            sRepository = new ContactsRepository();

        return sRepository;
    }

    private ContactsRepository() {
        ContactsRoomDatabase contactsRoomDatabase = ContactsRoomDatabase.getDatabase(ApplicationUtils.getContext());
        mContactsDAO = contactsRoomDatabase.getContactsDAO();
    }

    @Override
    public LiveData<List<Contact>> getContactsLiveData() {
        return mContactsDAO.getList();
    }

    @Override
    public LiveData<Contact> getContactLiveData(final String id) {
        final MutableLiveData<Contact> liveData = new MutableLiveData<>();
        ContactsRoomDatabase.dataBaseWriteExecutor.execute(
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
        mContactSyncUtils = new ContactSyncUtils(ApplicationUtils.getContext());
        ContactsRoomDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                clear();
                mContactSyncUtils.sync();
                mContactsDAO.insertContacts(mContactSyncUtils.getContacts().toArray(new Contact[]{}));
            }
        });
    }
}