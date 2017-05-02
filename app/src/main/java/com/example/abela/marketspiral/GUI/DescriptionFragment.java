package com.example.abela.marketspiral.GUI;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abela.marketspiral.Communicator;
import com.example.abela.marketspiral.Description;
import com.example.abela.marketspiral.DescriptionsAdapter;
import com.example.abela.marketspiral.MapFragment;
import com.example.abela.marketspiral.R;

import java.util.ArrayList;
import java.util.List;


public class DescriptionFragment extends Fragment {
    private RecyclerView recyclerView;
    private DescriptionsAdapter adapter;
    private List<Description> descriptionList;
    // TODO: Rename and change types of parameters
    private String title;
    private String date;
    private String price;
    private String description;
    private double lat;
    private double lng;
    private String imageUrl;
    private Bitmap image;

    private OnFragmentInteractionListener mListener;

    public DescriptionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DescriptionFragment newInstance(String param1, String param2) {
        DescriptionFragment fragment = new DescriptionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            title=getArguments().getString("title");

            date=getArguments().getString("date");
            description=getArguments().getString("description");
           imageUrl =getArguments().getString("image");
           price =getArguments().getString("price");
            lat=getArguments().getDouble("lat");
            lng=getArguments().getDouble("lng");
           // imageUrl=getArguments().getString("image");

            // image= BitmapFactory.decodeFile(imageUrl);




        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_description, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.description_image);
        TextView title_textView= (TextView) view.findViewById(R.id.description_title);
        title_textView.setText(title);
        TextView show_location_on_map =(TextView)view.findViewById(R.id.show_location_on_map);

        imageView.setImageBitmap(image);
        //imageView.setImageDrawable(R.drawable.album1);
       // textView.setText(""+mParam2);
        show_location_on_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putDouble("lat",lat);
                bundle.putDouble("lng",lng);
                Communicator communicator= (Communicator) getContext();
                communicator.replaceFragment(new MapFragment(),bundle);

                Log.d("ab","map button");
            }
        });
        return view;
    }
    private void prepareDescriptions() {


        //ItemsAdapter itemsAdapter =new ItemsAdapter()
       // Log.d("ab","   desc"+ );
       Description d = new Description();
        d= new Description("Price ",""+price);
        descriptionList.add(d);
        d= new Description("Added on ",date);
        descriptionList.add(d);
        d= new Description("Description",description);
        descriptionList.add(d);



        adapter.notifyDataSetChanged();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//========================================================================================================
        recyclerView = (RecyclerView) view.findViewById(R.id.description_recycler_view);

        descriptionList = new ArrayList<>();
        adapter = new DescriptionsAdapter(getContext(),descriptionList);

     //  RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 4);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.addItemDecoration(new ItemsFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        // recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.setAdapter(adapter);

        prepareDescriptions();
//========================================================================================================


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        //if (mListener != null) {
           // mListener.onFragmentInteraction(uri);
       // }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /// if (context instanceof OnFragmentInteractionListener) {
        //    mListener = (OnFragmentInteractionListener) context;
       // } else {
        //    throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        //}
    }

    @Override
    public void onDetach() {
        super.onDetach();
      //  mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
