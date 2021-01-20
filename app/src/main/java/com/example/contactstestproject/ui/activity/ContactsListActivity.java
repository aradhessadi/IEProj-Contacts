package com.example.contactstestproject.ui.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.ui.fragment.ContactsListFragment;
import com.example.contactstestproject.utils.ContactPermissionUtils;

public class ContactsListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return ContactsListFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContactPermissionUtils.requestPermission(this);
    }
}

