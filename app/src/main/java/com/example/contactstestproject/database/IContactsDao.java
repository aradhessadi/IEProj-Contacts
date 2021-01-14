package com.example.contactstestproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.contactstestproject.model.Contact;

import java.util.List;

@Dao
public interface IContactsDao {

    @Insert
    void insert (Contact contact);

    @Query("select * from contacts")
    List<Contact> getList();
}
