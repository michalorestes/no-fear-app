package com.stefan.michal.nofear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.stefan.michal.nofear.Adapters.ChallengesRecycleViewAdapter;

public class ChallengesActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private ChallengesRecycleViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

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

        adapter = new ChallengesRecycleViewAdapter(dataSet);
        adapter.setOnClickListener(new ChallengesRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ChallengesRecycleViewAdapter.ViewHolder item) {
                Toast.makeText(getApplicationContext(), "Just clicked the button", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        recycleView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
