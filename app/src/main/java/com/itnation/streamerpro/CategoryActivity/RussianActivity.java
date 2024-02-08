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
import com.itnation.streamerpro.Adapter.RussianAdapter;
import com.itnation.streamerpro.ModelClass.KoreanModel;
import com.itnation.streamerpro.ModelClass.RussianModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class RussianActivity extends AppCompatActivity {


    RecyclerView russian_recycler;
    DatabaseReference databaseReference;

    RussianAdapter russianAdapter;

    ArrayList<RussianModel> RussianList;

    LinearLayout back_presed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian);

        back_presed = findViewById(R.id.back_presedRu);
        russian_recycler = findViewById(R.id.russian_recycler);






        databaseReference = FirebaseDatabase.getInstance().getReference("RussianMovie");

        russian_recycler.setLayoutManager(new GridLayoutManager(RussianActivity.this,2));

        RussianList = new ArrayList<>();

        russianAdapter = new RussianAdapter(this, RussianList);
        russian_recycler.setAdapter(russianAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    RussianModel russianModel = dataSnapshot.getValue(RussianModel.class);
                    RussianList.add(russianModel);


                }

                russianAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(RussianActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });




//---------------------------------------------------------------------

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