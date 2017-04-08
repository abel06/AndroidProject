package com.example.abela.marketspiral;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by HaZe on 4/8/17.
 */

public class LoginBackFetch extends AsyncTask<HashMap<String,String>,Void,String> {





    @Override
    protected String doInBackground(HashMap<String, String>... hashMaps) {

        HttpURLConnection connection = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        //TODO change to login.php
        String SEARCH_URL = "http://192.168.43.137:80/db/pp.php/?";
        // String Search="https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?api_key=5cwCk6nhFAkPu9BU3EyxafUN5jqytIGvGD6R4kcO&location=Denver+CO";
        OutputStream outputStream;
        InputStream inputStream;
        //--------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------
        try {
            URL url = new URL(SEARCH_URL);
            connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(10000);

            inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String response = "";
            String line = "";

            while ((line = reader.readLine()) != null) {
                response = line;
            }
            reader.close();
            inputStream.close();
            connection.disconnect();
            return  ""+response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "net"+e;

        } catch (IOException e) {
            return "connFailed"+e;
        }

    }
}
