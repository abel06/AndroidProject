package com.example.abela.marketspiral;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SupermarketsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SupermarketsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SupermarketsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private SupermarketsAdapter adapter;
    private List<Supermarket> supermarketList;

    private ProgressBar mProgressBar;
    private Handler handler = new Handler();
    // TODO: Rename and change types of parameters
    private String title;
    private String supermarket;
    private String price;
    private String offer_end_date;
    private int image;

    private OnFragmentInteractionListener mListener;

    public SupermarketsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SupermarketsFragment newInstance(String param1, String param2) {
        SupermarketsFragment fragment = new SupermarketsFragment();
        //Bundle args = new Bundle();
        //  args.putString("position", param1);
        // args.putString(ARG_PARAM2, param2);
        //  fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
            title=getArguments().getString("title");
            supermarket="Conad";
            price="12";
            image=getArguments().getInt("image");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_supermarkets, container, false);


        return view;
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

        Supermarket s = new Supermarket("Conad Supermarket",13,covers[0]);

        supermarketList.add(s);
         s = new Supermarket("Ziger Supermarket",13,covers[1]);
        supermarketList.add(s);
        s = new Supermarket("Mara Supermarket",13,covers[2]);
        supermarketList.add(s);
        s = new Supermarket("Shewa Supermarket",13,covers[3]);
        supermarketList.add(s);
        s = new Supermarket("Ab Supermarket",13,covers[4]);
        supermarketList.add(s);



        adapter.notifyDataSetChanged();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//========================================================================================================
        recyclerView = (RecyclerView) view.findViewById(R.id.supermarket_recycler_view);

        supermarketList = new ArrayList<>();
        adapter = new SupermarketsAdapter(getContext(),supermarketList);

        //  RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 4);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.addItemDecoration(new ItemsFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        // recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);

        Log.d("ab",""+adapter);
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

