package com.itnation.streamerpro.Adapter;


import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.itnation.streamerpro.MainActivity;
import com.itnation.streamerpro.ModelClass.ChildItem;
import com.itnation.streamerpro.R;
import com.itnation.streamerpro.VideoPlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<ChildItem> childItemList;

    Context context;

    InterstitialAd interstitialAd;



    public void setChildItemList(List<ChildItem> childItemList){
        this.childItemList = childItemList;

        this.childItemList.removeAll(Collections.singleton(null));
    }



    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item , parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {

        ChildItem childItem = childItemList.get(position);
        holder.childName.setText(childItem.getChildName());
        holder.childDes.setText(childItem.getChildDes());
        String thumbId= childItem.getChildImage();


        String final_id = "https://img.youtube.com/vi/" + thumbId + "/hqdefault.jpg";
        Picasso.get().load(final_id).placeholder(R.drawable.place_holder).into(holder.childImageView);


        holder.child_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                v.getContext().startActivity(intent);

                VideoPlayerActivity.video_id= thumbId;



            }
        });


    }

    @Override
    public int getItemCount() {
        if (childItemList != null){
            return childItemList.size();
        }else{
            return  0;
        }
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder{
        TextView childName, childDes;
        ImageView childImageView;
        LinearLayout child_layout;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);

            childName = itemView.findViewById(R.id.movie_name);
            childImageView = itemView.findViewById(R.id.child_image);
            childDes = itemView.findViewById(R.id.movie_des);
            child_layout= itemView.findViewById(R.id.child_layout);
        }
    }








}