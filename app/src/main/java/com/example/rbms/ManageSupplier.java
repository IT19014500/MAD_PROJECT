package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManageSupplier extends AppCompatActivity {

    Button add;
    Button updateSup;
    TextView n,admin;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_supplier );
        Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();

        add = (Button)findViewById(R.id.button4);
        updateSup = (Button)findViewById(R.id.button7);
        n = findViewById(R.id.supjView23);
        admin = findViewById(R.id.textView9);

        reff = FirebaseDatabase.getInstance().getReference().child("Supplier").child("-MIik1Uo2u1jQhHSP8cc");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("supname").getValue().toString();
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
                Intent addSup= new Intent(ManageSupplier.this,AddSuplier.class);
                startActivity(addSup);
            }
        });
        updateSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSup= new Intent(ManageSupplier.this,UpdateSupplier.class);
                startActivity(addSup);
            }
        });
    }
}