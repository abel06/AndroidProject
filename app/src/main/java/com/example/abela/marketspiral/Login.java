package com.example.abela.marketspiral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abela.marketspiral.Core.RemoteTask;
import com.example.abela.marketspiral.GUI.LoginFragment;
import com.example.abela.marketspiral.GUI.RegisterFragment;
import com.example.abela.marketspiral.Utility.Actions;
import com.example.abela.marketspiral.interfaces.LoginResponse;
import com.example.abela.marketspiral.interfaces.RegisterResponse;
import com.example.abela.marketspiral.interfaces.RemoteResponse;

import java.util.HashMap;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class Login extends AppCompatActivity implements RemoteResponse{
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




    /**
     * This code the login part
     * */
    public void login(HashMap<String,String> data) {

        new RemoteTask(Actions.USER_LOGIN,data,this).execute();
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
            new RemoteTask(Actions.USER_REGISTRATION,data,this).execute();

    }else{
            //TODO error message
        }

    }


    @Override
    public void loginFinished(int value) {
        if(value == 1) {
            Intent main_activity = new Intent(this, MainActivity.class);
            startActivity(main_activity);

        }else {
            System.out.println("Error during login");
        }

    }

    @Override
    public void registerFinished(int value) {
        if(value == 1){
            onBackPressed();
        }else {
            System.out.println("ERROR during register");
        }

    }

    @Override
    public void itemAdded(int id) {

    }

    @Override
    public void itemRemoved(int id) {

    }
}
