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
import com.itnation.streamerpro.Adapter.HorrorAdapter;
import com.itnation.streamerpro.Adapter.LoveAdapter;
import com.itnation.streamerpro.ModelClass.HorrorModel;
import com.itnation.streamerpro.ModelClass.LoveModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class LoveActivity extends AppCompatActivity {



    RecyclerView love_recycler;
    DatabaseReference databaseReference;

    LoveAdapter loveAdapter;
    ArrayList<LoveModel> LoveList;



    LinearLayout back_presed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);


        back_presed = findViewById(R.id.back_presedLo);
        love_recycler = findViewById(R.id.love_recycler);





        databaseReference = FirebaseDatabase.getInstance().getReference("LoveMovie");

        love_recycler.setLayoutManager(new GridLayoutManager(LoveActivity.this,2));

        LoveList = new ArrayList<>();

        loveAdapter = new LoveAdapter(this, LoveList);
        love_recycler.setAdapter(loveAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    LoveModel loveModel = dataSnapshot.getValue(LoveModel.class);
                    LoveList.add(loveModel);


                }

                loveAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(LoveActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });







//------------------------------------------------------------
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