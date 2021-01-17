package com.example.contactstestproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Id")
    private String mID;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "phone-number")
    private String mPhoneNumber;

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        this.mName = mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public Contact() {
    }

    public Contact(String ID, String mName, String mPhoneNumber) {
        this.mID = ID;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
    }
}
