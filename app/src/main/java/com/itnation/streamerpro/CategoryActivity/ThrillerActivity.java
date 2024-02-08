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
import com.itnation.streamerpro.Adapter.KoreanAdapter;
import com.itnation.streamerpro.Adapter.ThrillerAdapter;
import com.itnation.streamerpro.ModelClass.KoreanModel;
import com.itnation.streamerpro.ModelClass.ThrillerModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class ThrillerActivity extends AppCompatActivity {


    RecyclerView Thriller_recycler;
    DatabaseReference databaseReference;
    ThrillerAdapter thrillerAdapter;
    ArrayList<ThrillerModel> ThrillerList;
    LinearLayout back_presedThri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thriller);



        back_presedThri = findViewById(R.id.back_presedThri);





        Thriller_recycler = findViewById(R.id.Thriller_recycler);






        databaseReference = FirebaseDatabase.getInstance().getReference("ThrillerMovie");

        Thriller_recycler.setLayoutManager(new GridLayoutManager(ThrillerActivity.this,2));

        ThrillerList = new ArrayList<>();

        thrillerAdapter = new ThrillerAdapter(this, ThrillerList);
        Thriller_recycler.setAdapter(thrillerAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    ThrillerModel thrillerModel = dataSnapshot.getValue(ThrillerModel.class);
                    ThrillerList.add(thrillerModel);


                }

                thrillerAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ThrillerActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });










//---------------------------------------------------------------------------

        back_presedThri. setOnClickListener(new View.OnClickListener() {
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