package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminDashBoard extends AppCompatActivity {

    Button Lmanager;
    Button Smanager;
    Button Supmanager;
    Button Paymanager;
    TextView stu,sup,lec;
    DatabaseReference reference;
    DatabaseReference reff2;
    DatabaseReference reff3;
    int sum = 0;
    int tot = 0;
    int tot2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_dash_board );

        Lmanager = (Button)findViewById(R.id.button2);
        Smanager = (Button)findViewById(R.id.button3);
        Supmanager = (Button)findViewById(R.id.button6);
        Paymanager = (Button)findViewById(R.id.button11);
        stu = findViewById(R.id.textView8);
        sup = findViewById(R.id.textView27);
        lec = findViewById(R.id.textView29);

        reference = FirebaseDatabase.getInstance().getReference().child("Student");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    sum = (int) snapshot.getChildrenCount();
                    stu.setText(Integer.toString(sum));
                }else{
                    stu.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reff2 = FirebaseDatabase.getInstance().getReference().child("Supplier");
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    tot = (int) snapshot.getChildrenCount();
                    sup.setText(Integer.toString(tot));
                }else{
                    sup.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reff3 = FirebaseDatabase.getInstance().getReference().child("Lecturer");
        reff3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    tot2 = (int) snapshot.getChildrenCount();
                    lec.setText(Integer.toString(tot2));
                }else{
                    lec.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        Lmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lec = new Intent(adminDashBoard.this,ManageLecturer.class);
                startActivity(Lec);
            }
        });
        Supmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lec = new Intent(adminDashBoard.this,ManageSupplier.class);
                startActivity(Lec);
            }
        });
        Smanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lec = new Intent(adminDashBoard.this,ManageStudent.class);
                startActivity(Lec);
            }
        });
        Paymanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lec = new Intent(adminDashBoard.this,ManagePayment.class);
                startActivity(Lec);
            }
        });
    }
}