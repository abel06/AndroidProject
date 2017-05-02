package com.example.abela.marketspiral.GUI;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abela.marketspiral.Login;
import com.example.abela.marketspiral.R;

import java.util.HashMap;

/**
 * Created by HaZe on 4/18/17.
 *  This class represents the register frame within it's elemexnts
 * */

public class RegisterFragment extends Fragment {

    private AppCompatActivity login_activity;
    private View view;
    private Button register_button;



    public RegisterFragment(Login login) {

        this.login_activity = login;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signup,container,false);
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        register_button = (Button) view.findViewById(R.id.btn_signup);


        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("PREMUTO");
                ((Login) login_activity).register(collect_data());

            }
        });

    }


    private HashMap<String,String> collect_data(){
        HashMap<String,String> data_collected = new HashMap<>();
        data_collected.put("name",((EditText)view.findViewById(R.id.input_name)).getText().toString());
        data_collected.put("address",((EditText)view.findViewById(R.id.input_address)).getText().toString());
        data_collected.put("email",((EditText)view.findViewById(R.id.input_email)).getText().toString());
        data_collected.put("mobile",((EditText)view.findViewById(R.id.input_mobile)).getText().toString());
        data_collected.put("password",((EditText)view.findViewById(R.id.input_password)).getText().toString());

        String confirm_password = ((EditText)view.findViewById(R.id.input_reEnterPassword)).getText().toString();


        if(confirm_password.equals(data_collected.get("password").toString())) {

            return data_collected;
        }else return null;
    }




}
