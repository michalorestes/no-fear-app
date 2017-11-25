package com.stefan.michal.nofear.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stefan.michal.nofear.R;

public class ChallengesRecycleViewAdapter extends RecyclerView.Adapter<ChallengesRecycleViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public ViewHolder(TextView view){
            super(view);
            title = view;
        }
    }

    String[] dataSet;

    public ChallengesRecycleViewAdapter(String[] dataSet){
        this.dataSet = dataSet;
    }

    @Override
    public ChallengesRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView title = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.challenges_recycle_view, parent, false);
        ViewHolder v = new ViewHolder(title);

        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
