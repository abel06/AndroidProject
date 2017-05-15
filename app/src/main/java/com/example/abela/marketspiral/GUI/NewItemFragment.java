package com.example.abela.marketspiral.GUI;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.abela.marketspiral.MainActivity;
import com.example.abela.marketspiral.R;

/**
 * Created by HaZe on 5/2/17.
 */

public class NewItemFragment extends Fragment {
    private AppCompatActivity main_activity;
    private View view;
    private Button save;

    public NewItemFragment(AppCompatActivity main_activity) {
        this.main_activity = main_activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      view =  inflater.inflate(R.layout.add_new_item, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        save = (Button) view.findViewById(R.id.save_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)main_activity).addNewItem();

            }
        });
    }
}
