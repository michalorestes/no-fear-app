package com.nf.michal.nofear.Activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.nf.michal.nofear.R;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private ActiveChallengesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");

        recycleView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);

        String[] dataSet =  {
                "Never lose anything",
                "Nerve",
                "Lay down on the floor",
                "Approach a stranger and say hello",
                "Never give up",
                "Read a book",
                "Never lose anything",
                "Nerve",
                "Lay down on the floor",
                "Approach a stranger and say hello",
                "Scream on the street",
                "Never give up",
                "Read a book",
                "Never lose anything",
                "Nerve",
                "Lay down on the floor",
                "Approach a stranger and say hello",
                "Scream on the street",
                "Never give up",
                "Read a book",
                "Never lose anything",
                "Nerve",
        };

        adapter = new ActiveChallengesAdapter(dataSet);
        recycleView.setAdapter(adapter);
    }

    /**
     * Called when app bar is created
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        return true;
    }

    /**
     * Called when action buttons in app bar
     * are clicked
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = null;
        switch (item.getItemId()) {
            case R.id.homeAsUp:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



