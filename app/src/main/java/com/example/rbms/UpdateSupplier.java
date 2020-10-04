package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateSupplier extends AppCompatActivity {

    EditText suname,suage,suemail,sucn,sunic;
    Button susave;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_supplier );

        suname = findViewById(R.id.editTextTextPersonName3);
        suage = findViewById(R.id.editTextTextPersonName4);
        suemail = findViewById(R.id.editTextTextPersonName5);
        sucn = findViewById(R.id.editTextTextPersonName6);
        sunic = findViewById(R.id.editTextTextPersonName7);
        susave = findViewById(R.id.button5);

        reff = FirebaseDatabase.getInstance().getReference().child("Supplier").child("-MIik1Uo2u1jQhHSP8cc");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("supname").getValue().toString();
                String age = snapshot.child("supage").getValue().toString();
                String email = snapshot.child("supemail").getValue().toString();
                String cn = snapshot.child("supcontact").getValue().toString();
                String nic = snapshot.child("supnic").getValue().toString();
                suname.setText(name);
                suage.setText(age);
                suemail.setText(email);
                sucn.setText(cn);
                sunic.setText(nic);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}