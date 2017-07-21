package com.example.shreyan.whatsapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by AppyFizz and AbinayaRajesh on 7/21/2017.
 */

/*
 * Runs as soon as the Application starts.
 * only performs some inital setup for the Parse server.
 */

public class StartApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Enable local datastore
        Parse.enableLocalDatastore(this);

        // Initialize Parse
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.parse_app_id))
                .clientKey(getString(R.string.parse_client_key))
                .server(getString(R.string.parse_server_url))
                .build()
        );

        // Grant public access
        ParseACL parseACL = new ParseACL();
        parseACL.setPublicReadAccess(true);
        parseACL.setPublicWriteAccess(true);
        parseACL.setDefaultACL(parseACL, true);
    }
}
