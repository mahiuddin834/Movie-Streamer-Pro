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
import com.itnation.streamerpro.Adapter.TeleguAdapter;
import com.itnation.streamerpro.ModelClass.KoreanModel;
import com.itnation.streamerpro.ModelClass.TeleguModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class TeleguActivity extends AppCompatActivity {


    RecyclerView telegu_recycler;

    DatabaseReference databaseReference;

    TeleguAdapter teleguAdapter;

    ArrayList<TeleguModel> teleguList;

    LinearLayout back_presedTelu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegu);


        back_presedTelu = findViewById(R.id.back_presedTelu);




        telegu_recycler = findViewById(R.id.telegu_recycler);







        databaseReference = FirebaseDatabase.getInstance().getReference("TamilMovie");

        telegu_recycler.setLayoutManager(new GridLayoutManager(TeleguActivity.this,2));

        teleguList = new ArrayList<>();

        teleguAdapter = new TeleguAdapter(this, teleguList);
        telegu_recycler.setAdapter(teleguAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    TeleguModel teleguModel = dataSnapshot.getValue(TeleguModel.class);
                    teleguList.add(teleguModel);


                }

                teleguAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(TeleguActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });






//------------------------------------------------------


        back_presedTelu. setOnClickListener(new View.OnClickListener() {
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