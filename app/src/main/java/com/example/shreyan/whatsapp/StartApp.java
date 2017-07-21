package com.example.shreyan.whatsapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by AppyFizz and AbinayaRajesh on 7/21/2017.
 */

public class StartApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Datastore
        Parse.enableLocalDatastore(this);

        // Initialize Parse
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5de637131295b59d3664c565b5bc9f64ce19cdba")
                .clientKey("2860c55df22729357195e5a31c57ed7a3bec4364")
                .server("http://ec2-52-14-76-109.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );

        // ParseUser.enableAutomaticUser();

        ParseACL parseACL = new ParseACL();
        parseACL.setPublicReadAccess(true);
        parseACL.setPublicWriteAccess(true);
        parseACL.setDefaultACL(parseACL, true);
    }


}
