package com.example.contactstestproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.contactstestproject.model.Contact;

import java.util.List;

@Dao
public interface ContactsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Contact contact);

    @Query("select * from contacts")
    LiveData<List<Contact>> getList();

    @Query("select * from contacts where name = :name")
    LiveData<Contact> getContact(String name);
}
