package com.example.abela.marketspiral.Core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.abela.marketspiral.R;
import android.support.v4.app.Fragment;

/**
 * Created by HaZe on 4/18/17.
 *  This class represents the register frame within it's elements
 * */

public class RegisterFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_fragment_layout,container,false);
    }

}
