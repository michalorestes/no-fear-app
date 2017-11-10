package com.stefan.michal.nofear.Entities;

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
}
