package com.example.contactstestproject.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "contacts")
public class Contact {

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "phone-number")
    private String mPhoneNumber;

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

    public Contact(String mName, String mPhoneNumber) {
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
    }
}
