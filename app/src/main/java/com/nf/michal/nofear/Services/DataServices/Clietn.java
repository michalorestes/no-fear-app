package com.nf.michal.nofear.Services.DataServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class Clietn {

    private Request request;
    private URLConnection urlConnection;
    private BufferedReader bufferedReader;

    public Clietn() {

    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String fetch() throws Exception {
        urlConnection = request.getRequestUrl().openConnection();

        this.bufferedReader = new BufferedReader(
            new InputStreamReader(
                urlConnection.getInputStream()
            )
        );

        String results = "";
        String inputLine;

        while((inputLine = this.bufferedReader.readLine()) != null) {
            results += inputLine;
        }

        return results;
    }
}
