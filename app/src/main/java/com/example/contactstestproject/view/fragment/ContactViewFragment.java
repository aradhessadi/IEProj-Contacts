package com.example.contactstestproject.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactstestproject.R;
import com.example.contactstestproject.databinding.FragmentContactViewBinding;
import com.example.contactstestproject.viewmodel.ContactViewViewModel;

public class ContactViewFragment extends Fragment {

    private ContactViewViewModel mContactViewViewModel;
    private FragmentContactViewBinding mFragmentContactViewBinding;

    public ContactViewFragment() {
        // Required empty public constructor
    }

    public static ContactViewFragment newInstance() {
        ContactViewFragment fragment = new ContactViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        initData();
        return mFragmentContactViewBinding.getRoot();
    }

    private void initData() {
        mFragmentContactViewBinding.name.setText(mContactViewViewModel.getContact().getName());
        mFragmentContactViewBinding.number.setText(mContactViewViewModel.getContact().getPhoneNumber());
    }

}