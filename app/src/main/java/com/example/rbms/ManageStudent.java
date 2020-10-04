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

public class ManageStudent extends AppCompatActivity {

    Button add;
    Button updateStu;
    TextView n;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_student );
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

        add = (Button)findViewById(R.id.button4);
        updateStu = (Button)findViewById(R.id.button7);
        n = findViewById(R.id.supjView23);

        reff = FirebaseDatabase.getInstance().getReference().child("Student").child("-MIiee8gK5EcBlQVNMH7");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("sname").getValue().toString();
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
                Intent addStudent = new Intent(ManageStudent.this,AddStudent.class);
                startActivity(addStudent);
            }
        });
        updateStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addStudent = new Intent(ManageStudent.this,UpdateStudent.class);
                startActivity(addStudent);
            }
        });
    }
}