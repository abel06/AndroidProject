package com.example.abela.marketspiral;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.example.abela.marketspiral.interfaces.LoginResponse;

import java.util.HashMap;

public class Login extends AppCompatActivity implements LoginResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }



    @Override
    public void loginFinished(String output) {

        if( output.equals("VALIDO")) {
            Intent main_activity = new Intent(this, MainActivity.class);
            startActivity(main_activity);

        }else {

           System.out.println(output);
        }
    }

    public void login(View view) {
        HashMap<String, String> user_data = new HashMap<>();

        user_data.put("username",((TextInputEditText)findViewById(R.id.input_username)).getText().toString());
        user_data.put("password",((TextInputEditText)findViewById(R.id.input_password)).getText().toString());
        new LoginBackFetch(this).execute(user_data);


    }
}
