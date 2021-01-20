package com.example.contactstestproject.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.ui.fragment.ContactDetailFragment;

public class ContactDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Fragment createFragment() {
        return ContactDetailFragment.newInstance(getIntent().getSerializableExtra(EXTRA_CONTACT));
    }

    public static Intent newIntent(Context context, Contact contact) {
        Intent intent = new Intent(context, ContactDetailActivity.class);
        intent.putExtra(EXTRA_CONTACT, contact);
        return intent;
    }
}
