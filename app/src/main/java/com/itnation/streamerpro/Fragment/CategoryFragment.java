package com.itnation.streamerpro.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itnation.streamerpro.CategoryActivity.ActionActivity;
import com.itnation.streamerpro.CategoryActivity.AdventureActivity;
import com.itnation.streamerpro.CategoryActivity.BanglaActivity;
import com.itnation.streamerpro.CategoryActivity.BolleywoodActivity;
import com.itnation.streamerpro.CategoryActivity.HolleywoodActivity;
import com.itnation.streamerpro.CategoryActivity.HorrorActivity;
import com.itnation.streamerpro.CategoryActivity.KoreanActivity;
import com.itnation.streamerpro.CategoryActivity.LoveActivity;
import com.itnation.streamerpro.CategoryActivity.RussianActivity;
import com.itnation.streamerpro.CategoryActivity.TamilActivity;
import com.itnation.streamerpro.CategoryActivity.TeleguActivity;
import com.itnation.streamerpro.CategoryActivity.ThrillerActivity;
import com.itnation.streamerpro.R;

public class CategoryFragment extends Fragment {

    TextView action_id, adventure, thriller, horror, bolleywood, holleywood, tamil, telegu, korean, bangla, love, russian ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_category, container, false);


        action_id= myView.findViewById(R.id.action_id);
        adventure= myView.findViewById(R.id.adventure_id);
        thriller= myView.findViewById(R.id.thrileer_id);
        horror= myView.findViewById(R.id.horror_id);
        bolleywood= myView.findViewById(R.id.bolleywood_id);
        holleywood= myView.findViewById(R.id.holleywood_id);
        tamil= myView.findViewById(R.id.tamil_id);
        telegu= myView.findViewById(R.id.telegu_id);
        korean= myView.findViewById(R.id.korean_id);
        bangla= myView.findViewById(R.id.bangla_id);
        love= myView.findViewById(R.id.love_id);
        russian= myView.findViewById(R.id.russian_id);






        action_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), ActionActivity.class);
                startActivity(intent);
            }
        });


        adventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), AdventureActivity.class);
                startActivity(intent);
            }
        });

        thriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), ThrillerActivity.class);
                startActivity(intent);
            }
        });

        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), HorrorActivity.class);
                startActivity(intent);
            }
        });

        bolleywood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), BolleywoodActivity.class);
                startActivity(intent);
            }
        });

        holleywood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), HolleywoodActivity.class);
                startActivity(intent);
            }
        });

        tamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), TamilActivity.class);
                startActivity(intent);
            }
        });

        telegu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), TeleguActivity.class);
                startActivity(intent);
            }
        });

        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), KoreanActivity.class);
                startActivity(intent);
            }
        });

        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), RussianActivity.class);
                startActivity(intent);
            }
        });

        bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), BanglaActivity.class);
                startActivity(intent);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), LoveActivity.class);
                startActivity(intent);
            }
        });















        return myView;


    }
}