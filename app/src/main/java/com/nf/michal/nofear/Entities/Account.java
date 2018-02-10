package com.nf.michal.nofear.Entities;

/**
 * Created by Michal on 11/11/2017.
 */

public class Account {

    private String username;
    private String email;
    private int points;
    private String rank;

    private Account(String email){

    }

    public static Account getAccount(String email){
        //TODO: get JSON file through backend API
        //TODO: create Account object
        Account accoun = null; //API call: API.getAccount()

        return accoun;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
