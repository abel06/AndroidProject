package com.example.abela.marketspiral;

import android.os.AsyncTask;

import com.example.abela.marketspiral.interfaces.LoginResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by HaZe on 4/8/17.
 */

public class LoginBackFetch extends AsyncTask<HashMap<String, String>, Void, String> {
    private LoginResponse delegate;

    public LoginBackFetch() {
        delegate = null;
    }

    @Override
    protected String doInBackground(HashMap<String, String>... hashMaps) {


        HttpURLConnection connection = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        String response ="";
        String SEARCH_URL = "http://localhost/login.php";
        // String Search="https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?api_key=5cwCk6nhFAkPu9BU3EyxafUN5jqytIGvGD6R4kcO&location=Denver+CO";
        OutputStream outputStream;
        InputStream inputStream = null;
        //--------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------
        URL url = null;
        try {
            url = new URL(SEARCH_URL);


            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");


            connection.setDoOutput(true);
//            connection.setDoInput(true);
            connection.setConnectTimeout(10000);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

            String data = "&username=marco&password=marco";

            wr.write(data);
            wr.flush();


            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                inputStream.close();
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return "" + response;

    }

    @Override
    protected void onPostExecute(String result) {
        delegate.loginFinished(result);
    }
}
