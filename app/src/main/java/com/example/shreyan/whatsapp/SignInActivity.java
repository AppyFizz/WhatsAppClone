package com.example.shreyan.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/*
 * The very first Activity displayed to the user.
 * Prompts them for their login information.
 */

public class SignInActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();

    private enum SignInMode {
        SIGN_UP, LOG_IN
    }

    private SignInMode signInMode = SignInMode.SIGN_UP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Modify Action Bar to display logo instead.
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayUseLogoEnabled(true);
        menu.setLogo(R.drawable.ic_whatsapp_logo_1);

        // Display SignIn screen to the user.
        setContentView(R.layout.activity_sign_in);

        // Perform Parse Analytics in the background.
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        /**
         * If the user is already logged in, skip the sign in process,
         * and directly take them to their contacts' list.
         */
        onSuccessfulLogin();
    }

    /**
     * Toggles the Sign in mode between 'Sign up' and 'Log in'.
     *
     * @param view The View which calls this method when clicked.
     */
    private void toggleSigninMode(View view) {
        Button signInButton = (Button) findViewById(R.id.signInButton);
        TextView signInTextView = (TextView) findViewById(R.id.signInText);

        if (signInMode == SignInMode.LOG_IN) {
            signInMode = SignInMode.SIGN_UP;
            signInButton.setText("Sign Up");
            signInTextView.setText("Already have an account? Log In");
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUp(view);
                }
            });
        } else if (signInMode == SignInMode.SIGN_UP) {
            signInMode = SignInMode.LOG_IN;
            signInButton.setText("Log In");
            signInTextView.setText("Don't have an account? Sign Up");
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    logIn(view);
                }
            });
        }
    }

    /**
     * Signs up the user.
     *
     * @param view The View which calls this method when clicked.
     */
    private void signUp(View view) {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        // Create a new Parse user.
        ParseUser user = new ParseUser();

        // Get username and password from the EditTexts.
        user.setUsername(username);
        user.setPassword(password);

        // Sign up the user in the background.
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d(TAG, "Sign up successful");
                    onSuccessfulLogin();
                } else
                    Toast.makeText(SignInActivity.this, e.getMessage().substring(e.getMessage().indexOf(" ")), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Logs in the user.
     *
     * @param view The View which calls this method when clicked.
     */
    private void logIn(View view) {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        // Log in the user in the background.
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    Log.d(TAG, "Log in successful");
                    onSuccessfulLogin();
                }
                else Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * To be called only after the user has successfully logged in.
     * <p>
     * Redirects the user to their list of contacts.
     */
    private void onSuccessfulLogin() {
        if (ParseUser.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), ContactsListActivity.class));
        }
    }
}
