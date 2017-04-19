package com.example.abela.marketspiral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.abela.marketspiral.Core.LoginFragment;
import com.example.abela.marketspiral.Core.RegisterFragment;
import com.example.abela.marketspiral.interfaces.LoginResponse;

public class Login extends AppCompatActivity implements LoginResponse{
    private LoginFragment login_fragment;
    private RegisterFragment register_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        login_fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,login_fragment).commit();
    }


    /***
     * for better coding manners i moved the entire login on the activity, once the signup button or the login button are pressed the corresponding method is called
    **/
    @Override
    protected void onStart() {
        super.onStart();

        ((Button)login_fragment.getLogin_button()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        ((Button)login_fragment.getSign_up_button()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapToRegister();
            }
        });
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


    /**
     * This code the login part
     * */
    public void login() {
        new LoginBackFetch(this).execute(login_fragment.collect_data());
    }


    /**Thid method swaps between login frame to register frame*/
    public void swapToRegister() {
        register_fragment = new RegisterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,register_fragment).commit();

    }
}
