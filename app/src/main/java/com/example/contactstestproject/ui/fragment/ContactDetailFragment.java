package com.example.contactstestproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactstestproject.R;
import com.example.contactstestproject.databinding.FragmentContactDetailBinding;
import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.viewmodel.ContactDetailViewModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ContactDetailFragment extends Fragment {

    private ContactDetailViewModel mContactDetailViewModel;
    private FragmentContactDetailBinding mFragmentContactViewBinding;
    private Contact mContact;
    public static final String ARGS_CONTACT = "ARGS_CONTACT";

    public ContactDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContactDetailViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(Objects.requireNonNull(getActivity()).getApplication()))
                .get(ContactDetailViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentContactViewBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contact_detail,
                container,
                false);
        return mFragmentContactViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContact = (Contact) (getArguments() != null ? getArguments().getSerializable(ARGS_CONTACT) : null);
        initData(mContact);
        mContactDetailViewModel.getContactsLiveData().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                initData(mContactDetailViewModel.getContactNewInfo(contacts, mContact));
            }
        });
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_contact_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_item_back) {
            Objects.requireNonNull(getActivity()).onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData(Contact contact) {
        if (contact != null) {
            mFragmentContactViewBinding.name.setText(contact.getName());
            mFragmentContactViewBinding.number
                    .setText(String.format(getString(R.string.number_contact_detail),
                            contact.getPhoneNumber()));
        } else {
            mFragmentContactViewBinding.name.setText(R.string.no_contact);
            mFragmentContactViewBinding.number.setText("");
        }
    }

    public static ContactDetailFragment newInstance(Serializable serializable) {
        ContactDetailFragment fragment = new ContactDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARGS_CONTACT, serializable);
        fragment.setArguments(args);
        return fragment;
    }
}