package com.example.abela.marketspiral;

import android.location.Location;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abela on 8/12/2016.
 */
public class ItemsInBound {
    public ItemsInBound(){

    }
    public boolean inBound(double lat,double lng,double latCurrent,double lngCurrent) {


        double latitude = lat;
        double longitude = lng;
        float[] results = new float[1];

       if(latCurrent!=0&&lngCurrent!=0){
        Location.distanceBetween(latCurrent, lngCurrent
                , lat
                , lng, results);
        if (results[0] < 10000) {
            return true;
        }else{
        return false;}

    }
   else {
            return false;
       }
    }
}
