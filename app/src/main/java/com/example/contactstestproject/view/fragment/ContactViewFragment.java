package com.example.contactstestproject.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactstestproject.R;
import com.example.contactstestproject.databinding.FragmentContactViewBinding;
import com.example.contactstestproject.model.Contact;
import com.example.contactstestproject.viewmodel.ContactViewViewModel;
import com.example.contactstestproject.viewmodel.ContactsListViewModel;

import java.util.Objects;

public class ContactViewFragment extends Fragment {

    private ContactViewViewModel mContactViewViewModel;
    private FragmentContactViewBinding mFragmentContactViewBinding;
    public static final String ARGS_ID = "ARGS_ID";
    private String mId;

    public ContactViewFragment() {
        // Required empty public constructor
    }

    public static ContactViewFragment newInstance(String id) {
        ContactViewFragment fragment = new ContactViewFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContactViewViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(Objects.requireNonNull(getActivity()).getApplication()))
                .get(ContactViewViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentContactViewBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contact_view,
                container,
                false);
        mId = getArguments().getString(ARGS_ID);
        return mFragmentContactViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData(mContactViewViewModel.getContact(mId));

        mContactViewViewModel.getContactLiveData(mId).observe(this, new Observer<Contact>() {
            @Override
            public void onChanged(Contact contact) {
                initData(contact);
            }
        });
    }

    private void initData(Contact contact) {
        mFragmentContactViewBinding.name.setText(contact.getName());
        mFragmentContactViewBinding.number.setText(contact.getPhoneNumber());
    }
}