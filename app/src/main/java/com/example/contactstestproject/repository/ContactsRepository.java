package com.example.contactstestproject.repository;

import android.content.Context;

import androidx.room.Room;

import com.example.contactstestproject.database.ContactsDao;

public class ContactsRepository implements IContactsRepository {

    private static ContactsRepository sRepository;
    private static Context sContext;
    private ContactsDao mDatabase;

    public static ContactsRepository getInstance(Context context) {
        sContext = context.getApplicationContext();
        if (sRepository == null)
            sRepository = new  ContactsRepository();
        return sRepository;
    }

    private ContactsRepository(){
        if (mDatabase==null)
            mDatabase = Room.databaseBuilder(sContext, ContactsDao.class, "contactsDB")
                    .allowMainThreadQueries()
                    .build();
    }

}
