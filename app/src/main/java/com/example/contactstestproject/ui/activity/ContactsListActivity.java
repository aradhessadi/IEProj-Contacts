package com.example.contactstestproject.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.contactstestproject.ui.fragment.ContactsListFragment;

public class ContactsListActivity extends SingleFragmentActivity {

    public static final int REQUEST_CODE_PERMISSION = 1;

    @Override
    public Fragment createFragment() {
        return ContactsListFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},
                REQUEST_CODE_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1 && (grantResults.length == 0
                || grantResults[0] == PackageManager.PERMISSION_DENIED)) {

            Toast.makeText(this, "Permission denied to read your External storage",
                    Toast.LENGTH_SHORT).show();
            finishAffinity();
        }
    }
}

