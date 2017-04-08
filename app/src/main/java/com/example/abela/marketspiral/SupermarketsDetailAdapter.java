package com.example.abela.marketspiral;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.List;

/**
 * Created by Abela on 3/20/2017.
 */

public class SupermarketsDetailAdapter  extends RecyclerView.Adapter<SupermarketsDetailAdapter.MyViewHolder> {

    private Context mContext;
    private List<SupermarketDetail> supermarketDetailList;
    ArcProgress arcProgress ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;
        public ImageView thumbnail, overflow;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
        }
    }


    public SupermarketsDetailAdapter(Context mContext, List<SupermarketDetail> supermarketDetailList) {
        this.mContext = mContext;
        this.supermarketDetailList =supermarketDetailList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.supermarket_details_card, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupermarketDetailsFragment SupermarketsFragment=new SupermarketDetailsFragment();
                // mainActivity.replace(new SupermarketsFragment());
                // mainActivity.replace(new SupermarketsFragment());
                Toast toast =Toast.makeText(mContext,"am clicked",Toast.LENGTH_LONG);
                toast.show();

                Bundle bundle = new Bundle();
                bundle.putInt("position",1);
                //bundle.putString("title", String.valueOf(album.getName()));
                //bundle.putInt("image", album.getThumbnail());

                Communicator communicator= (Communicator) mContext;
                communicator.replaceFragment(SupermarketsFragment,bundle);
            }
        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final SupermarketDetail supermarketDetail = supermarketDetailList.get(position);

        holder.title.setText(supermarketDetail.getTitle());
        holder.subtitle.setText(supermarketDetail.getSubtitle());

       // arcProgress.setProgress(60);

        // loading supermarket cover using Glide library
       // Glide.with(mContext).load(supermarket.getThumbnail()).into(holder.thumbnail);

        /*holder.overflow.setOnClickListener(new View.OnClickListener() {
        /    @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/

    }


    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu

    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return supermarketDetailList.size();
    }
}