package com.example.abela.marketspiral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abela.marketspiral.interfaces.LoginResponse;

import java.util.HashMap;

public class Login extends AppCompatActivity implements LoginResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }



    void login(HashMap<String, String> user_data) {

        new LoginBackFetch().execute(user_data);

    }


    @Override
    public void loginFinished(String output) {
        Intent main_activity = new Intent(this,MainActivity.class);
        startActivity(main_activity);
    }
}
