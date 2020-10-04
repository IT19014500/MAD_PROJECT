package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UpdateLecturer extends AppCompatActivity {

    EditText ulname,ulage,ulemail,ulcn,ulnic,ulsub;
    Button ulsave;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_lecturer );
        Toast.makeText(this, "Database Connected", Toast.LENGTH_SHORT).show();

        ulname = findViewById(R.id.editTextTextPersonName3);
        ulage = findViewById(R.id.editTextTextPersonName4);
        ulemail = findViewById(R.id.editTextTextPersonName5);
        ulcn = findViewById(R.id.editTextTextPersonName6);
        ulnic = findViewById(R.id.editTextTextPersonName7);
        ulsub = findViewById(R.id.editTextTextPersonName8);
        ulsave = findViewById(R.id.button5);

        reff = FirebaseDatabase.getInstance().getReference().child("Lecturer").child("-MIiW7PB7q97yd-Q2PQl");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String name = snapshot.child("name").getValue().toString();
                String age = snapshot.child("age").getValue().toString();
                String email = snapshot.child("email").getValue().toString();
                String cn = snapshot.child("phone").getValue().toString();
                String nic = snapshot.child("nic").getValue().toString();
                String sub = snapshot.child("subject").getValue().toString();
                ulname.setText(name);
                ulage.setText(age);
                ulemail.setText(email);
                ulcn.setText(cn);
                ulnic.setText(nic);
                ulsub.setText(sub);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}