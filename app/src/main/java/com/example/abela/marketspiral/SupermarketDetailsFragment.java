package com.example.abela.marketspiral;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class SupermarketDetailsFragment extends Fragment {

    private RecyclerView recyclerView;
    private SupermarketsDetailAdapter adapter;
    private List<SupermarketDetail> supermarketDetailList;

    private ProgressBar mProgressBar;
    private Handler handler = new Handler();
    // TODO: Rename and change types of parameters
    private String title;
    private String supermarket;
    private String price;
    private String offer_end_date;
    private int image;

    private OnFragmentInteractionListener mListener;

    public SupermarketDetailsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SupermarketDetailsFragment newInstance(String param1, String param2) {
        SupermarketDetailsFragment fragment = new SupermarketDetailsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
           // title=getArguments().getString("title");
           // supermarket="Conad";
           // price="12";
           // image=getArguments().getInt("image");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_supermarket_details, container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//========================================================================================================
       recyclerView = (RecyclerView) view.findViewById(R.id.supermarket_details_recycler_view);

        supermarketDetailList = new ArrayList<>();
        adapter = new SupermarketsDetailAdapter(getContext(),supermarketDetailList);

        //  RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 4);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.addItemDecoration(new ItemsFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        // recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ab","am logged");
            }
        });
        Log.d("ab",""+adapter);
        prepareDescriptions();
        ImageView map_image_btn= (ImageView) view.findViewById(R.id.map_image_button);
        map_image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Communicator communicator= (Communicator) getContext();
               // communicator.replaceFragment(SupermarketsFragment,bundle);

                Log.d("ab","map button");
            }
        });


//========================================================================================================


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        //if (mListener != null) {
        // mListener.onFragmentInteraction(uri);
        // }
    }
    private void prepareDescriptions() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};


        SupermarketDetail s= new SupermarketDetail("Supermarket","Conad");
        supermarketDetailList.add(s);
        s = new SupermarketDetail("Distance","13km");
        supermarketDetailList.add(s);
        s = new SupermarketDetail("Pets Allowed","yes");
        supermarketDetailList.add(s);
        s = new SupermarketDetail("Parking","yes");

        supermarketDetailList.add(s);
        s = new SupermarketDetail("Service Hour","8:30-2:30  3:30-8:30" );

        supermarketDetailList.add(s);



        adapter.notifyDataSetChanged();
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
