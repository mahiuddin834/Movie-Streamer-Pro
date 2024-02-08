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

import com.itnation.streamerpro.ModelClass.BollywoodModel;
import com.itnation.streamerpro.ModelClass.HollywoodModel;
import com.itnation.streamerpro.R;
import com.itnation.streamerpro.VideoPlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HollywoodAdapter extends RecyclerView.Adapter<HollywoodAdapter.HollywoodViewHolder> {


    Context context;
    ArrayList<HollywoodModel> HollywoodList;

    public HollywoodAdapter(Context context, ArrayList<HollywoodModel> hollywoodList) {
        this.context = context;
        HollywoodList = hollywoodList;
    }

    @NonNull
    @Override
    public HollywoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View hollywoodView = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);

        return new HollywoodViewHolder(hollywoodView);
    }

    @Override
    public void onBindViewHolder(@NonNull HollywoodViewHolder holder, int position) {


        HollywoodModel hollywoodModel= HollywoodList.get(position);

        holder.item_name.setText(hollywoodModel.getMovieName());

        String movieId= hollywoodModel.getMovieId();


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

        return HollywoodList.size();
    }


    public static class HollywoodViewHolder extends RecyclerView.ViewHolder{



        LinearLayout movie_layout;
        ImageView thum_image;
        TextView item_name;


        public HollywoodViewHolder(@NonNull View itemView) {
            super(itemView);

            movie_layout=itemView.findViewById(R.id.movie_layout);
            thum_image=itemView.findViewById(R.id.thum_image);
            item_name=itemView.findViewById(R.id.item_name);
        }
    }







}