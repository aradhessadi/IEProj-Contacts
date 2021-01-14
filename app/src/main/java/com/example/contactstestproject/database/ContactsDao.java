package com.example.contactstestproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.contactstestproject.model.Contact;

@Database(entities = Contact.class , version = 1)
public abstract class ContactsDao extends RoomDatabase {
    public abstract IContactsDao contactsDao();
}
