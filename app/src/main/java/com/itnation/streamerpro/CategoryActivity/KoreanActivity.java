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
import com.itnation.streamerpro.Adapter.KoreanAdapter;
import com.itnation.streamerpro.ModelClass.HorrorModel;
import com.itnation.streamerpro.ModelClass.KoreanModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class KoreanActivity extends AppCompatActivity {


    RecyclerView korean_recycler;
    DatabaseReference databaseReference;

    KoreanAdapter koreanAdapter;

    ArrayList<KoreanModel> KoreanList;




    LinearLayout back_presed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean);



        korean_recycler = findViewById(R.id.korean_recycler);






        databaseReference = FirebaseDatabase.getInstance().getReference("KoreanMovie");

        korean_recycler.setLayoutManager(new GridLayoutManager(KoreanActivity.this,2));

        KoreanList = new ArrayList<>();

        koreanAdapter = new KoreanAdapter(this, KoreanList);
        korean_recycler.setAdapter(koreanAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    KoreanModel koreanModel = dataSnapshot.getValue(KoreanModel.class);
                    KoreanList.add(koreanModel);


                }

                koreanAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(KoreanActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });





        //------------------------------------------------------
        back_presed = findViewById(R.id.back_presedKo);


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