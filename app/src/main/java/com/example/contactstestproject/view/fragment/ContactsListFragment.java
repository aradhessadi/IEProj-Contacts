package com.example.contactstestproject.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactstestproject.R;
import com.example.contactstestproject.databinding.FragmentContactsListBinding;

public class ContactsListFragment extends Fragment {

private FragmentContactsListBinding mFragmentContactsListBinding;

    public ContactsListFragment() {}

    public static ContactsListFragment newInstance() {
        return new ContactsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentContactsListBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contacts_list,
                container,
                false);
        return mFragmentContactsListBinding.getRoot();
    }
}