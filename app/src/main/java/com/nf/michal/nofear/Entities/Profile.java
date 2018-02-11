package com.nf.michal.nofear.Entities;

import java.util.ArrayList;

public class Profile {

    String _id;
    String email;
    String username;
    int xp;
    ArrayList<Object> challneges;

    private Profile(String email){

    }

    public static Profile getAccount(String email){
        //TODO: get JSON file through backend API
        //TODO: create Profile object
        Profile profile = null; //API call: API.getAccount()

        return profile;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public ArrayList<Object> getChallneges() {
        return challneges;
    }

    public void setChallneges(ArrayList<Object> challneges) {
        this.challneges = challneges;
    }
}
