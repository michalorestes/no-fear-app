package com.nf.michal.nofear.Activities.startscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.nf.michal.nofear.Entities.Challenge;
import com.nf.michal.nofear.R;
import com.nf.michal.nofear.Activities.profile.ProfileActivity;
import com.nf.michal.nofear.Activities.submitchallenge.AddChallengeActivity;
import com.nf.michal.nofear.Repository.ChallengesRepository;
import com.nf.michal.nofear.Services.DataServices.Clietn;
import com.nf.michal.nofear.Services.DataServices.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChallengesActivity extends AppCompatActivity implements Runnable {

    private RecyclerView recycleView;
    private ChallengesRecycleViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        Thread t = new Thread(this);
        t.start();
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

        recycleView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        adapter = new ChallengesRecycleViewAdapter(dataSet);

        adapter.setOnClickListener(new ChallengesRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ChallengesRecycleViewAdapter.ViewHolder item) {
                Toast.makeText(getApplicationContext(), "Just clicked the button", Toast.LENGTH_LONG).show();
            }
        });

        recycleView.setAdapter(adapter);
    }

    /**
     * Called when app bar is created
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar, menu);
        return true;
    }

    /**
     * Called when action buttons in app bar
     * are clicked
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = null;
        switch (item.getItemId()) {
            case R.id.action_add_challenge:
                i = new Intent(getApplicationContext(), AddChallengeActivity.class);
                break;
            case R.id.action_profile:
                i = new Intent(getApplicationContext(), ProfileActivity.class);
                break;
        }
        startActivity(i);

        return true;
    }

    @Override
    public void run() {

    }
}
