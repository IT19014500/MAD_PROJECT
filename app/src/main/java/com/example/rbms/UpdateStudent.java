package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateStudent extends AppCompatActivity {

    EditText stname,stage,stemail,stcn,stnic,stsub;
    Button stsave;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_student );
        Toast.makeText(this, "Database Connected", Toast.LENGTH_SHORT).show();

        stname = findViewById(R.id.editTextTextPersonName3);
        stage = findViewById(R.id.editTextTextPersonName4);
        stemail = findViewById(R.id.editTextTextPersonName5);
        stcn = findViewById(R.id.editTextTextPersonName6);
        stnic = findViewById(R.id.editTextTextPersonName7);
        stsub = findViewById(R.id.editTextTextPersonName8);
        stsave = findViewById(R.id.button5);

        reff = FirebaseDatabase.getInstance().getReference().child("Student").child("-MIiee8gK5EcBlQVNMH7");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("sname").getValue().toString();
                String age = snapshot.child("sage").getValue().toString();
                String email = snapshot.child("semail").getValue().toString();
                String cn = snapshot.child("scontact").getValue().toString();
                String nic = snapshot.child("snic").getValue().toString();
                String sub = snapshot.child("ssubject").getValue().toString();
                stname.setText(name);
                stage.setText(age);
                stemail.setText(email);
                stcn.setText(cn);
                stnic.setText(nic);
                stsub.setText(sub);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}