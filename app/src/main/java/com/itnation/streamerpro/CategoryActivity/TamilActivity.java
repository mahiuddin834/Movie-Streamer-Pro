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
import com.itnation.streamerpro.Adapter.TamilAdapter;
import com.itnation.streamerpro.ModelClass.KoreanModel;
import com.itnation.streamerpro.ModelClass.TamilModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class TamilActivity extends AppCompatActivity {

    RecyclerView tamil_recycler;

    DatabaseReference databaseReference;

    TamilAdapter tamilAdapter;
    ArrayList<TamilModel> tamilList;

    LinearLayout back_presedTam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamil);

        back_presedTam = findViewById(R.id.back_presedTam);




        tamil_recycler = findViewById(R.id.tamil_recycler);






        databaseReference = FirebaseDatabase.getInstance().getReference("TamilMovie");

        tamil_recycler.setLayoutManager(new GridLayoutManager(TamilActivity.this,2));

        tamilList = new ArrayList<>();

        tamilAdapter = new TamilAdapter(this, tamilList);
        tamil_recycler.setAdapter(tamilAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    TamilModel tamilModel = dataSnapshot.getValue(TamilModel.class);
                    tamilList.add(tamilModel);


                }

                tamilAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(TamilActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });



//---------------------------------------------------------------------------------

        back_presedTam. setOnClickListener(new View.OnClickListener() {
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