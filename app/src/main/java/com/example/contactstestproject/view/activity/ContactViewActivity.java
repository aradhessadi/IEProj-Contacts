package com.example.contactstestproject.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.contactstestproject.view.fragment.ContactViewFragment;

public class ContactViewActivity extends SingleFragmentActivity {

    public static final String EXTRA_ID = "EXTRA_ID";
    private String mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mId = getIntent().getStringExtra(EXTRA_ID);
    }

    @Override
    public Fragment createFragment() {
        return ContactViewFragment.newInstance(mId);
    }

    public static Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, ContactViewActivity.class);
        intent.putExtra(EXTRA_ID, id);
        return intent;
    }
}
