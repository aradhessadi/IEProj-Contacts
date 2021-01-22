package com.example.contactstestproject.data.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contactstestproject.data.ContactsDAO;
import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.utils.ApplicationUtils;

@Database(entities = Contact.class, version = 1, exportSchema = false)
public abstract class ContactsRoomDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "contacts.db";

    public abstract ContactsDAO getContactsDAO();

    public static ContactsRoomDatabase getDatabase() {
        return Room.databaseBuilder(
                ApplicationUtils.getContext().getApplicationContext(),
                ContactsRoomDatabase.class,
                ContactsRoomDatabase.DATABASE_NAME).build();
    }
}
