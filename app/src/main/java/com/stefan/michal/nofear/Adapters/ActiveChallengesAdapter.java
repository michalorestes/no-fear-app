package com.stefan.michal.nofear.Adapters;

import android.os.Debug;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stefan.michal.nofear.R;

public class ActiveChallengesAdapter extends RecyclerView.Adapter<ActiveChallengesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public TextView title;

        public ViewHolder(CardView itemView) {
            super(itemView);
            Log.i("TAG**", "getting title view->>>>>>>>>>>>>>>");
            this.cardView = itemView;
            this.title = cardView.findViewById(R.id.activeChallengeTitle);
        }
    }

    String[] dataSet;

    public ActiveChallengesAdapter(String[] dataSet){
        this.dataSet = dataSet;
        Log.i("TAG", "adapter constructor -------------------------------->>>>");
    }

    //This is where you create/inflate the view from XML resource file
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.active_challenge_recycle_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("TAG", "on create view holder is here");
        holder.title.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
