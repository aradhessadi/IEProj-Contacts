package com.example.contactstestproject.view.activity;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.view.fragment.ContactsListFragment;

public class ContactsListActivity extends SingleFragmentActivity{
    @Override
    public Fragment createFragment() {
        return ContactsListFragment.newInstance();
    }
}
