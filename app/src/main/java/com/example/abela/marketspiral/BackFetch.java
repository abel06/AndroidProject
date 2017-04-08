package com.example.abela.marketspiral;

/**
 * Created by Abela on 3/28/2017.
 */

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class  BackFetch extends AsyncTask<ArrayList<String>,Void,String> {

    private Communicator comm;

    Context mContext;
    public BackFetch (Context context) {
       /// this.comm=communicator;
        mContext=context;
    }

    @Override
    protected String doInBackground(ArrayList<String>... params) {
        HttpURLConnection connection = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        String SEARCH_URL = "http://192.168.43.137:80/db/pp.php/?";
       // String Search="https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?api_key=5cwCk6nhFAkPu9BU3EyxafUN5jqytIGvGD6R4kcO&location=Denver+CO";
        OutputStream outputStream;
        InputStream inputStream;
        //--------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------
        try {
            URL url = new URL(SEARCH_URL);
            connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(10000);

            inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String response = "";
            String line = "";

            while ((line = reader.readLine()) != null) {
                response = line;
            }
            reader.close();
            inputStream.close();
            connection.disconnect();
            return  ""+response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "net"+e;

        } catch (IOException e) {
            return "connFailed"+e;
        }


        //return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Comment
        // AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.mActivity);
        // alertDialogBuilder.setTitle(R.string.no_item_found_dialog_title);
        // String mssg=mContext.getString(R.string.no_item_found_dialog_mssg);
        ///  alertDialogBuilder.setMessage(mssg);
        //alertDialog = alertDialogBuilder.create();
    }

    @Override
    protected void onPostExecute(String result) {

        TextWriteRead textWriteRead =new TextWriteRead();
       textWriteRead.writeToFile(result,mContext,"result");

       // Log.d("ab","homes  "+result);
        HashMap<Integer,List<Item>> itemsHashmap= new HashMap<>();
        List<HashMap<Integer,List<Item>>>hashMaps =new ArrayList<>();

        Dataloader dataloader= (Dataloader)mContext;
        //communicator.replaceFragment(descriptionFragment,bundle);
        JSONObject jsonRootObject=null;
        JSONObject homeJobj=null;
        JSONObject productJobj=null;

        double latCurrent;
        double lngCurrent;
        Log.d("ab","result "+result);
        try {

            jsonRootObject = new JSONObject(result);
           // Log.d("ab","homes  "+jsonRootObject);
        if(jsonRootObject!=null){
            try {
                JSONArray homes=jsonRootObject.getJSONArray("homes");

                for (int i=0;i<homes.length();i++) {

                    homeJobj = new JSONObject(homes.get(i).toString());
                    String title = (String) homeJobj.get("label");

                    double price = Double.parseDouble((String) homeJobj.get("price"));
                    String description = (String) homeJobj.get("description");
                    String image = (String) homeJobj.get("image");
                    double lat = Double.parseDouble((String) homeJobj.get("lat"));
                    double lng = Double.parseDouble((String) homeJobj.get("lng"));
                    String date = (String) homeJobj.get("added");


                    List<Item> itemList = new ArrayList<Item>();
                    ItemsInBound itemsInBound = new ItemsInBound();

                    String current=textWriteRead.readFromFile(mContext, "mlastLocation.txt");
                    String[] separeted=current.split(":");

                    latCurrent=Double.parseDouble(separeted[0]);
                    lngCurrent=Double.parseDouble(separeted[1]);

               if(itemsInBound.inBound(lat,lng,latCurrent,lngCurrent)){
                   float[] results=new float[1];
                   Location.distanceBetween(lat,lng,latCurrent,lngCurrent,results);
                   DecimalFormat numberFormat = new DecimalFormat("#.0");
                   double distance= Double.parseDouble(numberFormat.format(results[0]/1000));
                    Item item = new Item(i, title, price, image, description, lat, lng, date,distance);
                    item.setPosition(i);
                    item.setTitle(title);
                    item.setPrice(price);
                    item.setThumbnail(image);
                    item.setDescription(description);
                    item.setLat(lat);
                    item.setLng(lng);
                    item.setDate(date);

                    itemList.add(item);
                    itemsHashmap.put(i, itemList);
                    }
                    JSONObject ownerJobj = (JSONObject) homeJobj.get("owner");
                    String name = ownerJobj.getString("name");
                    String phone = ownerJobj.getString("phone");
                    String email = ownerJobj.getString("email");
                    String country = ownerJobj.getString("country");
                    String speakes = ownerJobj.getString("speaks");

                    //Owner ownerr = new Owner(name, phone, email, country, speakes);
                }
                dataloader.dataload(itemsHashmap);


            }catch (JSONException j){
                Log.d("ab","homes  "+j);
            }
        }
               // for (int i=0;i<homes.length();i++) {}
                    /*productsJobj = new JSONObject(homes.get(i).toString());

                    JSONArray products = productsJobj.getJSONArray("product");

                    List<Item>itemList=new ArrayList<Item>();
                    for(int j=0;j<products.length();j++){
                    productJobj = new JSONObject(products.get(j).toString());
                    String label = (String) productJobj.get("label");
                    String image = (String) productJobj.get("image");

                    Item item = new Item(label, 0, image);
                        itemList.add(item);
                        //items.add(item);

                       */


                   // itemsHashmap.put(i,itemList);
                   // hashMaps.add(itemsHashmap);
                /*}
                dataloader.dataload(itemsHashmap);
              //  Log.d("ab","cat   "+item);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }*/

       // dataloader.dataload(result);
       // Log.d("ab","result   "+result);
        // Toast.makeText(mContext, "post"+result, Toast.LENGTH_SHORT).show();
    } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}