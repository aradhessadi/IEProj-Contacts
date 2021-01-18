package com.example.contactstestproject.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.ui.fragment.ContactDetailFragment;

public class ContactDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_ID = "EXTRA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Fragment createFragment() {
        return ContactDetailFragment.newInstance(getIntent().getStringExtra(EXTRA_ID));
    }

    public static Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, ContactDetailActivity.class);
        intent.putExtra(EXTRA_ID, id);
        return intent;
    }
}
