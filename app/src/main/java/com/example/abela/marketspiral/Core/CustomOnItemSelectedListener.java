package com.example.abela.marketspiral.Core;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Abela on 4/28/2017.
 */

class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
       /* Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
