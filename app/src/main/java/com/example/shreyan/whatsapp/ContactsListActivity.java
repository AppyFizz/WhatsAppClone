package com.example.shreyan.whatsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/*
 * This activity displays all the user's contacts in the
 * form of a (scrollable) list, which includes thumbnails
 * of each contact, their username (later to be changed to name/nickname),
 * and a preview of the last message exchanged with this contact, if it exists.
 */

public class ContactsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        // Implement a RecyclerView or ListView to display user's contacts.
    }
}
