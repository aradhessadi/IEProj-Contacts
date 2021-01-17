package com.example.contactstestproject.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.contactstestproject.model.Contact;

import java.util.List;

@Dao
public interface ContactsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContacts (Contact... contacts);

    @Query("delete from contacts")
    void clear();

    @Query("select * from contacts")
    LiveData<List<Contact>> getList();

    @Query("select * from contacts where Id = :id")
    Contact getContact(String id);
}
