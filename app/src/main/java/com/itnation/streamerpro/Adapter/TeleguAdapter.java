package com.itnation.streamerpro.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itnation.streamerpro.ModelClass.TamilModel;
import com.itnation.streamerpro.ModelClass.TeleguModel;
import com.itnation.streamerpro.R;
import com.itnation.streamerpro.VideoPlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeleguAdapter extends RecyclerView.Adapter<TeleguAdapter.TeleguViewHolder> {

    Context context;

    ArrayList<TeleguModel> TeleguList;

    public TeleguAdapter(Context context, ArrayList<TeleguModel> teleguList) {
        this.context = context;
        TeleguList = teleguList;
    }

    @NonNull
    @Override
    public TeleguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View teleguView = LayoutInflater.from(context).inflate(R.layout.category_item, parent,false);
        return new TeleguViewHolder(teleguView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeleguViewHolder holder, int position) {

        TeleguModel teleguModel= TeleguList.get(position);
        holder.item_name.setText(teleguModel.getMovieName());
        String movieId= teleguModel.getMovieId();

        String final_id = "https://img.youtube.com/vi/" + movieId + "/hqdefault.jpg";
        Picasso.get().load(final_id).placeholder(R.drawable.place_holder).into(holder.thum_image);



        holder.movie_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                v.getContext().startActivity(intent);

                VideoPlayerActivity.video_id= movieId;

            }
        });






    }

    @Override
    public int getItemCount() {

        return TeleguList.size();
    }

    public static class TeleguViewHolder extends RecyclerView.ViewHolder{


        LinearLayout movie_layout;
        ImageView thum_image;
        TextView item_name;

        public TeleguViewHolder(@NonNull View itemView) {
            super(itemView);

            movie_layout =itemView.findViewById(R.id.movie_layout);
            thum_image=itemView.findViewById(R.id.thum_image);
            item_name=itemView.findViewById(R.id.item_name);
        }
    }
}