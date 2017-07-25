package com.example.shreyan.whatsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shreyan.whatsapp.Contact.Contact;
import com.example.shreyan.whatsapp.Contact.ContactsAdapter;

import java.util.ArrayList;

/*
 * This activity displays all the user's contacts in the
 * form of a (scrollable) list, which includes thumbnails
 * of each contact, their username (later to be changed to name/nickname),
 * and a preview of the last message exchanged with this contact, if it exists.
 */

public class ContactsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        // ArrayList of contacts, to be displayed to the user using a RecyclerView.
        ArrayList<Contact> contactsList = new ArrayList<>();
        contactsList.add(new Contact(R.drawable.batman_silhouette, "Batman", "Hi"));
        contactsList.add(new Contact(R.drawable.wonder_woman_silhouette, "Wonder Woman", "Hii"));
        contactsList.add(new Contact(R.drawable.wonder_woman_silhouette, "Diana", "Hiii"));
        contactsList.add(new Contact(R.drawable.batman_silhouette, "Bruce", "Hello"));
        contactsList.add(new Contact(R.drawable.wonder_woman_silhouette, "Steve", "Bye"));
        contactsList.add(new Contact(R.drawable.batman_silhouette, "Dark Knight", "G'night"));
        contactsList.add(new Contact(R.drawable.batman_silhouette, "Joker", "*Smirk*"));
        contactsList.add(new Contact(R.drawable.appy_fizz, "Guess Who?", "???"));


        // Implement a RecyclerView or ListView to display user's contacts.


        recyclerView = (RecyclerView) findViewById(R.id.contacts_list);

        // We use this setting to improve performance if changes
        // in content do not change the layout size of the RecyclerView.
        recyclerView.setHasFixedSize(true);

        // We use a linear layout manager.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /**
         * We use our custom adapter {@link ContactsAdapter} here.
         */
        adapter = new ContactsAdapter(ContactsListActivity.this, contactsList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        /**
         * Do nothing here yet.
         * Prevent the user from accessing the {@link SignInActivity} again,
         * once they're already signed in.
         */

        /**
         * TODO: If possible
         * But if they press the back button three times consecutively,
         * pause the app.
         */
    }
}
