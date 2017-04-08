package com.example.abela.marketspiral;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Item> itemList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price,distance;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_item);
            price = (TextView) view.findViewById(R.id.price);
            distance=(TextView)view.findViewById(R.id.distance);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public ItemsAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Item item = itemList.get(position);

        holder.title.setText(item.getTitle());
        holder.price.setText(""+item.getPrice()+" $");
        holder.distance.setText(""+item.getDistance()+" km");
      //  holder.count.setText(item.getNumOfSongs() + " songs");
        Log.d("ab",""+item.getTitle());
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         Log.d("ab",item.getTitle());
                DescriptionFragment descriptionFragment =new DescriptionFragment();
                Bundle bundle = new Bundle();
               // bundle.putSerializable("item", (Serializable) item);
                //bundle.putInt("position",position);

                bundle.putString("title", String.valueOf(item.getTitle()));
                bundle.putString("date",item.getDate());
                bundle.putString("description",item.getDescription());
                bundle.putString("image", item.getThumbnail());
                bundle.putString("price",""+item.getPrice()+" $");
                bundle.putDouble("lat",item.getLat());
                bundle.putDouble("lng",item.getLng());


                Communicator communicator= (Communicator) mContext;
                communicator.replaceFragment(descriptionFragment,bundle);
            }
        });
        // loading item cover using Glide library
        Glide.with(mContext).load(item.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_item, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

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
        return itemList.size();
    }
}
