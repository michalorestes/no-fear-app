package com.nf.michal.nofear.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nf.michal.nofear.R;
import com.nf.michal.nofear.startscreen.ChallengesActivity;

public class SignUpFormActivity extends AppCompatActivity {

    private String TAG = "** Sign Up Form Activity -> ";
    private EditText emailInput;
    private EditText usernameInput;
    private Button confirmBtn;
    private Button cancelBtn;
    private String email;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        Bundle extras = getIntent().getExtras();
        if (extras == null){
            return;
        }

        email = extras.getString("accountEmail");
        username = extras.getString("accountUsername");

        Log.i(TAG, "E-mail: " + email + " Username: " + username);

        emailInput = findViewById(R.id.email_input_box);
        usernameInput = findViewById(R.id.username_input_box);
        confirmBtn = findViewById(R.id.confirm_button);
        cancelBtn = findViewById(R.id.cancel_button);

        emailInput.setText(email);
        usernameInput.setText(username);
    }

    public void confirmSignUp(View view) {
        //TODO: Input validation
        //TODO: add user to database using backend API
        Log.i(TAG, "Confirm button clicked");
        Intent challengesIntent = new Intent(this, ChallengesActivity.class);
        challengesIntent.putExtra("accountEmail", email);
        startActivity(challengesIntent);
    }

    public void cancelSignUp(View view) {
        Log.i(TAG, "Cancel button clicked");
    }
}
