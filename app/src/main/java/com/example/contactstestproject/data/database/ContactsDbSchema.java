package com.example.contactstestproject.data.database;

public class ContactsDbSchema {
    public static final String NAME = "contacts.db";
    public static final int VERSION = 1;

    public static final class ContactsTable {
        public static final String NAME = "contacts";

        public static final class COLS {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String PHONE_NUMBER = "phoneNo";
        }
    }
}
