package com.stefan.michal.nofear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChallengesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
    }

    public void logOut(View view){
        Toast.makeText(ChallengesActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
