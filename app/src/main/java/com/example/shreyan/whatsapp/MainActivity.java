package com.example.shreyan.whatsapp;

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

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();

    private enum SignIn {
        SIGN_UP, LOG_IN
    }

    private SignIn signInMode = SignIn.SIGN_UP;
    private boolean signedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayUseLogoEnabled(true);
        menu.setLogo(R.drawable.ic_whatsapp_logo_1);
        setContentView(R.layout.activity_main);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    /**
     *
     *
     * @param view
     */
    public void toggleSigninMode(View view) {
        Button signInButton = (Button) findViewById(R.id.signInButton);
        TextView signInTextView = (TextView) findViewById(R.id.signInText);

        if (signInMode == SignIn.LOG_IN) {
            signInMode = SignIn.SIGN_UP;
            signInButton.setText("Sign Up");
            signInTextView.setText("Already have an account? Log In");
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUp(view);
                }
            });
        } else if (signInMode == SignIn.SIGN_UP) {
            signInMode = SignIn.LOG_IN;
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
     *
     *
     * @param view
     */
    public void signUp(View view) {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        // Create a new Parse user
        ParseUser user = new ParseUser();

        // Get username and password from the EditTexts
        user.setUsername(username);
        user.setPassword(password);

        // Sign up the user in the background
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) Log.d(TAG, "Sign up successful");
                else Toast.makeText(MainActivity.this, e.getMessage().substring(e.getMessage().indexOf(" ")), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *
     *
     * @param view
     */
    public void logIn(View view) {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        // Log in the user in the background
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) Log.d(TAG, "Log in successful");
                else Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
