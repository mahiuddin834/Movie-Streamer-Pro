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
import com.itnation.streamerpro.Adapter.ActionAdapter;
import com.itnation.streamerpro.Adapter.AdventureAdapter;
import com.itnation.streamerpro.ModelClass.ActionModel;
import com.itnation.streamerpro.ModelClass.AdventureModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class AdventureActivity extends AppCompatActivity {

    LinearLayout back_presed;

    RecyclerView adventure_recycler;


    DatabaseReference databaseReference;
    AdventureAdapter adventureAdapter;
    ArrayList<AdventureModel> AdventureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        back_presed = findViewById(R.id.back_presedAd);
        adventure_recycler = findViewById(R.id.adventure_recycler);



        databaseReference = FirebaseDatabase.getInstance().getReference("AdventureMovie");

        adventure_recycler.setLayoutManager(new GridLayoutManager(AdventureActivity.this,2));

        AdventureList = new ArrayList<>();

        adventureAdapter = new AdventureAdapter(this, AdventureList);
        adventure_recycler.setAdapter(adventureAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    AdventureModel adventureModel = dataSnapshot.getValue(AdventureModel.class);
                    AdventureList.add(adventureModel);


                }

                adventureAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(AdventureActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });














        //-----------------------------------------------------------------------
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