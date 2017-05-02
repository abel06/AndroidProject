package com.example.abela.marketspiral.Core;

import android.os.AsyncTask;

import com.example.abela.marketspiral.Utility.Actions;
import com.example.abela.marketspiral.Utility.Functions;
import com.example.abela.marketspiral.Utility.ServerInfo;
import com.example.abela.marketspiral.interfaces.RemoteResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by HaZe on 5/2/17.
 * This class performs all the remote tasks (user registration , login ecc.. ) that are needed
 */

public class RemoteTask extends AsyncTask<Void,Void,Integer> {

    /**This interface is used to notify when a task finish*/
    private RemoteResponse delegate;

    /**This is the current action to perform @{@link Actions}**/
    private int ACTION;

    /** Here is where the data is stored (Using Objects doesn't not matter if are strings or Item or whatever)*/
    private Object args;

    public  RemoteTask(int ACTION, Object args,RemoteResponse delegate){

        this.ACTION = ACTION;
        this.args = args;
        this.delegate = delegate;
    }


    public RemoteResponse getDelegate() {
        return delegate;
    }

    public void setDelegate(RemoteResponse delegate) {
        this.delegate = delegate;
    }

    public int getACTION() {
        return ACTION;
    }

    public void setACTION(int ACTION) {
        this.ACTION = ACTION;
    }

    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }

    @Override
    protected Integer doInBackground(Void... voids) {

        switch (ACTION){

            case Actions.USER_REGISTRATION : return userRegistration();

            case Actions.USER_LOGIN : return userLogin();

            case Actions.NEW_ITEM : return newItem();

            case Actions.REMOVE_ITEM : return removeItem();

        }

        return -1;
    }


    @Override
    protected void onPostExecute(Integer integer) {

        switch (ACTION){

            case Actions.USER_REGISTRATION: delegate.registerFinished(integer);break;

            case Actions.USER_LOGIN : delegate.loginFinished(integer); break;

            case Actions.NEW_ITEM : delegate.itemAdded(integer);break;

            case Actions.REMOVE_ITEM: delegate.itemRemoved(integer);break;

        }

    }

    private Integer removeItem() {


        return 0;
    }

    private Integer newItem() {
        return 0;
    }

    private int userRegistration() {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String response ="";
        // String Search="https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?api_key=5cwCk6nhFAkPu9BU3EyxafUN5jqytIGvGD6R4kcO&location=Denver+CO";
        InputStream inputStream = null;
        //--------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        URL url = null;
        try {
            //Login php script location
            url = new URL(ServerInfo.DB_URL+ServerInfo.REGISTER);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");      //Data sent via POST method

            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

//            HashMap<String,String> user_data = hashMaps[0]; //Collect data from input
//            String data = "username="+user_data.get("username")+"&password="+user_data.get("password"); // Concatenate data into a request

            HashMap<String,String> user_data = (HashMap<String, String>) args;

            wr.write(Functions.ConcatenateForServer(user_data));
            wr.flush();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return 0;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
            //                reader.close();
            //                inputStream.close();
            connection.disconnect();
        }

        return 1;

    }


    private int userLogin(){
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String response ="";
        // String Search="https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?api_key=5cwCk6nhFAkPu9BU3EyxafUN5jqytIGvGD6R4kcO&location=Denver+CO";
        InputStream inputStream = null;
        //----------------------------------------ad    ---------------------------

        //-----------------------------------------------------------------------------------------------
        URL url = null;
        try {
            //Login php script location
            url = new URL(ServerInfo.DB_URL+ServerInfo.LOGIN);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");      //Data sent via POST method

            connection.setDoOutput(true);
            connection.setConnectTimeout(7000);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

//            HashMap<String,String> user_data = hashMaps[0]; //Collect data from input
//
//            String data = "username="+user_data.get("username")+"&password="+user_data.get("password"); // Concatenate data into a request


            HashMap<String,String> user_data = (HashMap<String, String>) args;

            wr.write(Functions.ConcatenateForServer(user_data));
            wr.flush();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return 0;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
            //                reader.close();
//                inputStream.close();
            connection.disconnect();
        }

        return 1;
    }

}
