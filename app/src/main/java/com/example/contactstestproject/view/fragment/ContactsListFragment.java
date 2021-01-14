package com.example.contactstestproject.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactstestproject.R;
import com.example.contactstestproject.adapter.ContactsListAdapter;
import com.example.contactstestproject.databinding.FragmentContactsListBinding;
import com.example.contactstestproject.viewmodel.ContactsListViewModel;

import java.util.Objects;

public class ContactsListFragment extends Fragment {

    private FragmentContactsListBinding mFragmentContactsListBinding;
    private ContactsListAdapter mContactsListAdapter;
    private ContactsListViewModel mContactsListViewModel;

    public ContactsListFragment() {
    }

    public static ContactsListFragment newInstance() {
        return new ContactsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContactsListViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory
                .getInstance(Objects.requireNonNull(getActivity()).getApplication()))
                .get(ContactsListViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mFragmentContactsListBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contacts_list,
                container,
                false);
        setAdapter();
        return mFragmentContactsListBinding.getRoot();
    }

    private void setAdapter() {
        if (mContactsListAdapter == null) {
            mContactsListAdapter = new ContactsListAdapter(getContext(), mContactsListViewModel.getContacts());
            mFragmentContactsListBinding.ContactsList.setAdapter(mContactsListAdapter);
        } else {
            mContactsListAdapter.notifyDataSetChanged();
        }
    }
}