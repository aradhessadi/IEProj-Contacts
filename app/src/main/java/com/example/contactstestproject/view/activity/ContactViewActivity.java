package com.example.contactstestproject.view.activity;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.view.fragment.ContactViewFragment;

public class ContactViewActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return ContactViewFragment.newInstance();
    }
}
