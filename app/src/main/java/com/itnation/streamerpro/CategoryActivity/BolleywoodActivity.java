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
import com.itnation.streamerpro.Adapter.BanglaAdapter;
import com.itnation.streamerpro.Adapter.BollywoodAdapter;
import com.itnation.streamerpro.ModelClass.BanglaModel;
import com.itnation.streamerpro.ModelClass.BollywoodModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class BolleywoodActivity extends AppCompatActivity {


    LinearLayout back_presed;


    RecyclerView bollywood_recycler;


    DatabaseReference databaseReference;
    BollywoodAdapter bollywoodAdapter;
    ArrayList<BollywoodModel> BollywoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolleywood);



        back_presed = findViewById(R.id.back_presedBo);
        bollywood_recycler = findViewById(R.id.bollywood_recycler);









        databaseReference = FirebaseDatabase.getInstance().getReference("BollywoodMovie");

        bollywood_recycler.setLayoutManager(new GridLayoutManager(BolleywoodActivity.this,2));

        BollywoodList = new ArrayList<>();

        bollywoodAdapter = new BollywoodAdapter(this, BollywoodList);
        bollywood_recycler.setAdapter(bollywoodAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    BollywoodModel bollywoodModel = dataSnapshot.getValue(BollywoodModel.class);
                    BollywoodList.add(bollywoodModel);


                }

                bollywoodAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(BolleywoodActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

















        //---------------------------------------------


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