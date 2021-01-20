package com.example.contactstestproject.ui.activity;

import android.Manifest;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.contactstestproject.ui.fragment.ContactsListFragment;

public class ContactsListActivity extends SingleFragmentActivity {

    public static final int REQUEST_CODE_PERMISSION = 1;

    @Override
    public Fragment createFragment() {
        return ContactsListFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},
                REQUEST_CODE_PERMISSION);
    }
}

