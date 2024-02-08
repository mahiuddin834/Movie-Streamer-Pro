package com.itnation.streamerpro.CategoryActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.itnation.streamerpro.ModelClass.ActionModel;
import com.itnation.streamerpro.R;

import java.util.ArrayList;

public class ActionActivity extends AppCompatActivity {

    LinearLayout back_presed;
    RecyclerView action_recycler;

    DatabaseReference databaseReference;
    ActionAdapter actionAdapter;
    ArrayList<ActionModel> ActionList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        back_presed = findViewById(R.id.back_presed);
        action_recycler = findViewById(R.id.action_recycler);

        databaseReference = FirebaseDatabase.getInstance().getReference("ActionMovie");

        action_recycler.setLayoutManager(new GridLayoutManager(ActionActivity.this,2));

        ActionList = new ArrayList<>();

        actionAdapter = new ActionAdapter(ActionActivity.this, ActionList);
        action_recycler.setAdapter(actionAdapter);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot :snapshot.getChildren()){


                    ActionModel actionModel= dataSnapshot.getValue(ActionModel.class);
                    ActionList.add(actionModel);


                }

                actionAdapter.notifyDataSetChanged();




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ActionActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });



//=====================================================

        back_presed. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBack();



            }

            private void onBack() {
                finish();
            }
        });


        // backpresed end








    }



    
}