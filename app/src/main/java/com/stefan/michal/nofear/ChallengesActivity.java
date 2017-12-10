package com.stefan.michal.nofear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.stefan.michal.nofear.Adapters.ChallengesRecycleViewAdapter;

public class ChallengesActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private ChallengesRecycleViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

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
                Intent intent = new Intent(getApplicationContext(), ViewChallengeActivity.class);
                startActivity(intent);

            }
        });
        recycleView.setAdapter(adapter);
    }
}
