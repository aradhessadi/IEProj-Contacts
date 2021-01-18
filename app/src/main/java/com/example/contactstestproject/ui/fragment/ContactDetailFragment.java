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

import java.util.Objects;

public class ContactDetailFragment extends Fragment {

    private ContactDetailViewModel mContactDetailViewModel;
    private FragmentContactDetailBinding mFragmentContactViewBinding;
    public static final String ARGS_ID = "ARGS_ID";
    private String mId;

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    public static ContactDetailFragment newInstance(String id) {
        ContactDetailFragment fragment = new ContactDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_ID, id);
        fragment.setArguments(args);
        return fragment;
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
        mId = getArguments().getString(ARGS_ID);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        mContactDetailViewModel.insertContacts();
        mContactDetailViewModel.getContactLiveData(mId).observe(this, new Observer<Contact>() {
            @Override
            public void onChanged(Contact contact) {
                initData(contact);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_contact_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_item_back) {
            getActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData(Contact contact) {
        mFragmentContactViewBinding.name.setText(contact.getName());
        mFragmentContactViewBinding.number
                .setText(String.format(getString(R.string.number_contact_detail),
                        contact.getPhoneNumber()));
    }
}