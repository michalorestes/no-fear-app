package com.nf.michal.nofear.Activities.startscreen;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nf.michal.nofear.R;

public class ChallengesRecycleViewAdapter extends RecyclerView.Adapter<ChallengesRecycleViewAdapter.ViewHolder> {

    private String[] dataSet;
    private OnItemClickListener listener;

    public ChallengesRecycleViewAdapter(String[] dataSet){
        this.dataSet = dataSet;
    }

    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    //This is where you create/inflate the view from XML resource file
    @Override
    public ChallengesRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.challenges_recycle_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    //Tell the adapter how to bind data to the view
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(dataSet[position]);
        holder.bind(holder, listener);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    public interface OnItemClickListener {
        void onItemClick(ViewHolder item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        public TextView title;

        public ViewHolder(CardView view){
            super(view);
            this.cardView = view;
            this.title = cardView.findViewById(R.id.challengeTitle);
        }

        public void bind(final ViewHolder holder, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(holder);
                }
            });
        }

        public void clickedButton(View view){
            //Toast.makeText(ChallengesActivity.class, "Just clicked the button", Toast.LENGTH_LONG).show();
        }
    }
}
