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
import com.itnation.streamerpro.Adapter.BollywoodAdapter;
import com.itnation.streamerpro.Adapter.HollywoodAdapter;
import com.itnation.streamerpro.ModelClass.BollywoodModel;
import com.itnation.streamerpro.ModelClass.HollywoodModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class HolleywoodActivity extends AppCompatActivity {

    LinearLayout back_presed;
    RecyclerView hollywood_recycler;

    DatabaseReference databaseReference;

    HollywoodAdapter hollywoodAdapter;

    ArrayList<HollywoodModel> HollywoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holleywood);



        back_presed = findViewById(R.id.back_presedHo);
        hollywood_recycler= findViewById(R.id.hollywood_recycler);




        databaseReference = FirebaseDatabase.getInstance().getReference("HollywoodMovie");

        hollywood_recycler.setLayoutManager(new GridLayoutManager(HolleywoodActivity.this,2));

        HollywoodList = new ArrayList<>();

        hollywoodAdapter = new HollywoodAdapter(this, HollywoodList);
        hollywood_recycler.setAdapter(hollywoodAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    HollywoodModel hollywoodModel = dataSnapshot.getValue(HollywoodModel.class);
                    HollywoodList.add(hollywoodModel);


                }

                hollywoodAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(HolleywoodActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });






        //--------------------------------------


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