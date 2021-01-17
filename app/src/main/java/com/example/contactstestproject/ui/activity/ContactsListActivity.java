package com.example.contactstestproject.ui.activity;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.ui.fragment.ContactsListFragment;

public class ContactsListActivity extends SingleFragmentActivity{
    @Override
    public Fragment createFragment() {
        return ContactsListFragment.newInstance();
    }
}
