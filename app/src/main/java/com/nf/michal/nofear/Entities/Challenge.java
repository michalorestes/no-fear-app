package com.nf.michal.nofear.Entities;

import android.util.Log;

import org.json.simple.JSONObject;

public class Challenge {
    String _id;
    String title;
    String description;
    String dateAdded;
    Profile addedBy;
    int upVotes;
    int acceptedCount;
    int wonCount;

    public Challenge(JSONObject jsonObject) {
        this._id = jsonObject.get("_id").toString();
        this.title = jsonObject.get("title").toString();
        this.description = jsonObject.get("description").toString();
        this.dateAdded = jsonObject.get("dateAdded").toString();
        //this.addedBy = jsonObject.get("addedBy").toString();
        this.upVotes = Integer.parseInt(jsonObject.get("upVotes").toString());
        this.acceptedCount = Integer.parseInt(jsonObject.get("acceptedCount").toString());
        this.wonCount = Integer.parseInt(jsonObject.get("wonCount").toString());
    }

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public Profile getAddedBy() {
        return addedBy;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotesIncrement(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getAcceptedCount() {
        return acceptedCount;
    }

    public void setAcceptedCountIncrement(int acceptedCount) {
        this.acceptedCount = acceptedCount;
    }

    public int getWonCount() {
        return wonCount;
    }

    public void setWonCountIncrement(int wonCount) {
        this.wonCount = wonCount;
    }
}
