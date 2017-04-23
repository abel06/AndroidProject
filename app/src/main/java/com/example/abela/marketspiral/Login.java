package com.example.abela.marketspiral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.abela.marketspiral.Core.LoginFragment;
import com.example.abela.marketspiral.Core.RegisterFragment;
import com.example.abela.marketspiral.interfaces.LoginResponse;
import com.example.abela.marketspiral.interfaces.RegisterResponse;

import java.util.HashMap;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class Login extends AppCompatActivity implements LoginResponse, RegisterResponse {
    private LoginFragment login_fragment;
    private RegisterFragment register_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        login_fragment = new LoginFragment(this);
        register_fragment = new RegisterFragment(this);
        getFragmentManager().beginTransaction().add(R.id.fragment_container,login_fragment).commit();
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
    public void login(HashMap<String,String> data) {
        new LoginBackFetch(this).execute(data);
    }


    /**Thid method swaps between login frame to register frame*/
    public void swapToRegister() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,register_fragment).addToBackStack(NULL).commit();

    }


    @Override
    public void onBackPressed() {
        System.out.println(getFragmentManager().getBackStackEntryCount());
        if(getFragmentManager().getBackStackEntryCount() == 1) {
            getFragmentManager().popBackStack();

        }else{
            super.onBackPressed();
        }

    }

    public void register(HashMap<String, String> data) {

        if(!data.isEmpty()) {
            new RegisterBackFetch(this).execute(data);
        }else{
            //TODO error message
        }

    }


    @Override
    public void registerFinished() {

        onBackPressed();

    }
}
