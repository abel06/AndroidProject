package com.example.abela.marketspiral.Core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.abela.marketspiral.R;
import java.util.HashMap;

/**
 * Created by HaZe on 4/18/17.
 * This class represent the login frame within it's element.
 */

public class LoginFragment extends Fragment {

    private View view;
    private Button sign_up_button;
    private Button login_button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment_layout,container,false);
        return view;
    }



    /**
     * Once the view have been inflated i collect buttons reference
     * */
    @Override
    public void onStart() {
        super.onStart();
        sign_up_button = (Button) view.findViewById(R.id.signup);
        login_button = (Button) view.findViewById(R.id.btn_login);
    }

    public Button getSign_up_button(){
        return sign_up_button;
    }

    public Button getLogin_button(){
        return login_button;
    }


    /**
     * This functions works as before, collect data from the layout
     *  (this will be called from the Login activity
     * **/
    public HashMap<String,String> collect_data(){
        HashMap<String,String> data = new HashMap<>();
        data.put("username",((TextInputEditText)view.findViewById(R.id.input_username)).getText().toString());
        data.put("password",((TextInputEditText)view.findViewById(R.id.input_password)).getText().toString());
        return data;
    }


}
