package com.itnation.streamerpro.CategoryActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itnation.streamerpro.Adapter.AdventureAdapter;
import com.itnation.streamerpro.Adapter.BanglaAdapter;
import com.itnation.streamerpro.ModelClass.AdventureModel;
import com.itnation.streamerpro.ModelClass.BanglaModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class BanglaActivity extends AppCompatActivity {

    LinearLayout back_presed;

    RecyclerView bangla_recycler;


    DatabaseReference databaseReference;
    BanglaAdapter banglaAdapter;
    ArrayList<BanglaModel> BanglaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla);


        back_presed = findViewById(R.id.back_presedBa);
        bangla_recycler=findViewById(R.id.bangla_recycler);








        databaseReference = FirebaseDatabase.getInstance().getReference("BanglaMovie");

        bangla_recycler.setLayoutManager(new GridLayoutManager(BanglaActivity.this,2));

        BanglaList = new ArrayList<>();

        banglaAdapter = new BanglaAdapter(this, BanglaList);
        bangla_recycler.setAdapter(banglaAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    BanglaModel banglaModel = dataSnapshot.getValue(BanglaModel.class);
                    BanglaList.add(banglaModel);


                }

                banglaAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(BanglaActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });




















        //-------------------------------------------------

        back_presed. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBack();



            }






            private void onBack() {
                finish();
            }
        });

    }
}