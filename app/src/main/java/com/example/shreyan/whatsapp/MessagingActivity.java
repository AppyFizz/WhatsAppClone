package com.example.shreyan.whatsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/*
 * The actual 'Chat Activity', wherein the user exchanges messages
 * with a particular contact. Includes a text-box to type a message
 * at the bottom, a 'send-message' button, and a list showing the
 * user's contact history with that particular contact.
 */

public class MessagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display contact thumbail on left end of action bar.
        // Display contact name beside it.

        setContentView(R.layout.activity_messaging);

        // Implement a RecyclerView or ListView to display previous messages
        // exchanged with a particular contact.

        // EditText at bottom to type in new messages.

        // 'Send messsage' button at bottom-right.
    }
}
