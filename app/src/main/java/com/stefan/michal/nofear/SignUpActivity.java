package com.stefan.michal.nofear;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.stefan.michal.nofear.Entities.Account;


public class SignUpActivity
        extends AppCompatActivity
        implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener,
        FirebaseAuth.AuthStateListener, OnCompleteListener<AuthResult> {

    public static final int RC_SIGN_IN = 1;
    public static final String TAG = "** SIGN IN ACTIVITY -> ";

    private SignInButton mGoogleButton;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mGoogleButton = findViewById(R.id.sign_in_button);
        mGoogleButton.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .requestProfile()
                .build();

        //Configure Google API client
        this.mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(SignUpActivity.this, "Starting intent",
                Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(SignUpActivity.this, "Failed to connect to firebase", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Listener is called when signInIntent is closed
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        //Sate change listener for mAuth
        //TODO: Check if account already exists in DB etc.

        FirebaseUser user = firebaseAuth.getCurrentUser();
        //check if user is authenticated
        if (user != null){
            //TODO: clean up this section of the code, too many duplicates
            //startActivity(new Intent(SignUpActivity.this, ChallengesActivity.class));
            //check if user exists in the system
            Account account = Account.getAccount(user.getEmail()); //for now account is always gonna be null
            //TODO: set condition to (account != null)
            if (account == null){
                Intent challengesActivity = new Intent(SignUpActivity.this, ChallengesActivity.class);
                challengesActivity.putExtra("accountEmail", user.getEmail());
                startActivity(challengesActivity);
            } else {
                Intent signUpFormIntent = new Intent(SignUpActivity.this, SignUpFormActivity.class);
                signUpFormIntent.putExtra("accountEmail", user.getEmail());
                signUpFormIntent.putExtra("accountUsername", user.getDisplayName());
                startActivity(signUpFormIntent);
                return;
            }

            //TODO: Pass Account object to next activity
            Toast.makeText(SignUpActivity.this, "You're signed in", Toast.LENGTH_LONG).show();

            return;
        }

        Log.i(TAG, "Firebase authentication failed");
        Toast.makeText(SignUpActivity.this, "Firebase authentication has failed",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        //On Complete listener for mAuth
        if (task.isSuccessful()) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "signInWithCredential:success");
            FirebaseUser user = mAuth.getCurrentUser();
            updateUI(user);
        } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "signInWithCredential:failure", task.getException());
            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
            updateUI(null);
        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, this);
    }

    private void updateUI(Object object) {

    }
}