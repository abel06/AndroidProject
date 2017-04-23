package com.example.abela.marketspiral.Core;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.abela.marketspiral.Login;
import com.example.abela.marketspiral.R;
import java.util.HashMap;

/**
 * Created by HaZe on 4/18/17.
 * This class represent the login_activity frame within it's element.
 */

public class LoginFragment extends Fragment {

    //This is needed for fragment swap
    private AppCompatActivity login_activity;
    private View view;
    private Button sign_up_button;
    private Button login_button;



    public Button getSign_up_button() {
        return sign_up_button;
    }

    public void setSign_up_button(Button sign_up_button) {
        this.sign_up_button = sign_up_button;
    }

    public Button getLogin_button() {
        return login_button;
    }

    public void setLogin_button(Button login_button) {
        this.login_button = login_button;
    }


    public LoginFragment(Login login) {
        this.login_activity = login;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment_layout,container,false);
        return view;
    }

    /**        This overhead it's caused by how fragment's lifecycle works...    **/
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sign_up_button = (Button) view.findViewById(R.id.signup);
        login_button = (Button) view.findViewById(R.id.btn_login);


        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Login) login_activity).swapToRegister();
            }
        });


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,String> data = collect_data();
                ((Login) login_activity).login(data);
            }
        });



    }

    /**
     * This functions works as before, collect data from the layout
     *  (this will be called from the Login activity)
     * **/
    private HashMap<String,String> collect_data(){
        HashMap<String,String> data = new HashMap<>();
        data.put("username",((TextInputEditText)view.findViewById(R.id.input_username)).getText().toString());
        data.put("password",((TextInputEditText)view.findViewById(R.id.input_password)).getText().toString());
        return data;
    }


}
