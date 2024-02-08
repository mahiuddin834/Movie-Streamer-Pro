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
import com.itnation.streamerpro.Adapter.HollywoodAdapter;
import com.itnation.streamerpro.Adapter.HorrorAdapter;
import com.itnation.streamerpro.ModelClass.HollywoodModel;
import com.itnation.streamerpro.ModelClass.HorrorModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class HorrorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    HorrorAdapter horrorAdapter;

    ArrayList<HorrorModel> HorrorList;


    LinearLayout back_presed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror);


        back_presed = findViewById(R.id.back_presedHorror);

        recyclerView= findViewById(R.id.horror_recycler);





        databaseReference = FirebaseDatabase.getInstance().getReference("HorrorMovie");

        recyclerView.setLayoutManager(new GridLayoutManager(HorrorActivity.this,2));

        HorrorList = new ArrayList<>();

        horrorAdapter = new HorrorAdapter(this, HorrorList);
        recyclerView.setAdapter(horrorAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    HorrorModel horrorModel = dataSnapshot.getValue(HorrorModel.class);
                    HorrorList.add(horrorModel);


                }

                horrorAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(HorrorActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });




//------------------------------------------------
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