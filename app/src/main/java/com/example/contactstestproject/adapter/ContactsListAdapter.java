package com.example.contactstestproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactstestproject.R;
import com.example.contactstestproject.databinding.RowContactsListBinding;
import com.example.contactstestproject.model.Contact;

import java.util.List;


public class ContactsListAdapter extends
        RecyclerView.Adapter<ContactsListAdapter.ContactsListHolder> {

    private final List<Contact> mContacts;
    private final Context mContext;

    public ContactsListAdapter(Context context, List<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @NonNull
    @Override
    public ContactsListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        RowContactsListBinding rowContactsListBinding =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.row_contacts_list,
                        parent,
                        false);

        return new ContactsListHolder(rowContactsListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsListHolder holder, int position) {
        holder.bindProduct(position);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ContactsListHolder extends RecyclerView.ViewHolder {
        private final RowContactsListBinding mRowContactsListBinding;

        public ContactsListHolder(RowContactsListBinding rowContactsListBinding) {
            super(rowContactsListBinding.getRoot());
            mRowContactsListBinding = rowContactsListBinding;
        }

        public void bindProduct(int position) {
            Contact mContact = mContacts.get(position);
            mRowContactsListBinding.textViewName.setText(mContact.getName());
        }
    }
}
