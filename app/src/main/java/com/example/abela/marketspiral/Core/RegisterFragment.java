package com.example.abela.marketspiral.Core;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abela.marketspiral.Login;
import com.example.abela.marketspiral.R;

/**
 * Created by HaZe on 4/18/17.
 *  This class represents the register frame within it's elemexnts
 * */

public class RegisterFragment extends Fragment {


    public RegisterFragment(Login login) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_signup,container,false);
    }

}
