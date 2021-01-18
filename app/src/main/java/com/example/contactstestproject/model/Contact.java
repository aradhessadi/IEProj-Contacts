package com.example.contactstestproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String mId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "phone-number")
    private String mPhoneNumber;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mName = mId;
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

    public Contact(@NonNull String id, String mName, String mPhoneNumber) {
        this.mId = id;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
    }
}
