package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManageLecturer extends AppCompatActivity {

    Button add;
    Button updateLec;
    TextView n;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_lecturer );
        Toast.makeText(this, "Database Connected", Toast.LENGTH_LONG).show();

        add = (Button)findViewById(R.id.button4);
        updateLec = (Button)findViewById(R.id.button7);
        n = findViewById(R.id.supjView23);

        reff = FirebaseDatabase.getInstance().getReference().child("Lecturer").child("-MIiW7PB7q97yd-Q2PQl");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue().toString();
                n.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addL = new Intent(ManageLecturer.this,AddLecturer.class);
                startActivity(addL);
            }
        });
        updateLec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addL = new Intent(ManageLecturer.this,UpdateLecturer.class);
                startActivity(addL);
            }
        });
    }
}