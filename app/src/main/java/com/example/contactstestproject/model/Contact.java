package com.example.contactstestproject.model;

public class Contact {

    private String mName;
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
