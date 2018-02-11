package com.nf.michal.nofear.Services;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;

/**
 * Created by michal on 12/02/18.
 */

public class TestClass extends AsyncTask<URL, Integer, Long> {

    public TestClass(){
        Log.i("**", "constructing test class");
    }

    @Override
    protected Long doInBackground(URL... urls) {
        return Long.valueOf(22);
    }
}
