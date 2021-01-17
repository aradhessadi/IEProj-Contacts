package com.example.contactstestproject.repository;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;


import com.example.contactstestproject.database.ContactsDAO;
import com.example.contactstestproject.database.ContactsRoomDatabase;
import com.example.contactstestproject.model.Contact;

import java.util.List;

public class ContactsRepository implements IContactsRepository {

    private static ContactsRepository sRepository;
    private final ContactsDAO mContactsDAO;

    public static ContactsRepository getInstance(Context context) {
        if (sRepository == null)
            sRepository = new ContactsRepository(context);

        return sRepository;
    }

    private ContactsRepository(Context context) {
        ContactsRoomDatabase contactsRoomDatabase = ContactsRoomDatabase.getDatabase(context);
        mContactsDAO = contactsRoomDatabase.getContactsDAO();
    }

    @Override
    public LiveData<List<Contact>> getContactsLiveData() {
        return mContactsDAO.getList();
    }

    @Override
    public LiveData<Contact> getContactLiveData(String id) {
        return mContactsDAO.getContact(id);
    }

    public void insert(final Contact contact) {
        ContactsRoomDatabase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mContactsDAO.insert(contact);
            }
        });
    }

    public void setContactsList(Context context) {
        /*ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        while (cursor != null && cursor.moveToNext()) {
            String Id = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cursor.getString(cursor.getColumnIndex(
                    ContactsContract.Contacts.DISPLAY_NAME));
            *//*String number = cursor.getString(cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER));*//*
            mContactsDAO.insert(new Contact("4", name, "00"));
        }
        if (cursor != null) {
            cursor.close();
        }*/

        insert(new Contact("d", "y", "6"));
        insert(new Contact("3", "3", "7"));
    }
}