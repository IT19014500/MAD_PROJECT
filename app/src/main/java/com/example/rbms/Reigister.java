package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Reigister extends AppCompatActivity {

    EditText aname,aage,aemail,acn,anic,apass;
    Button reg;
    DatabaseReference reff;
    Admin admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reigister);
        Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();

        aname = findViewById(R.id.editTextTextPersonName3);
        aage = findViewById(R.id.editTextTextPersonName4);
        aemail = findViewById(R.id.editTextTextPersonName5);
        acn = findViewById(R.id.editTextTextPersonName6);
        anic = findViewById(R.id.editTextTextPersonName7);
        apass = findViewById(R.id.editTextTextPersonName8);
        reg = findViewById(R.id.button5);
        admin = new Admin();
        reff = FirebaseDatabase.getInstance().getReference().child("Admin");

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age1 = Integer.parseInt(aage.getText().toString().trim());
                Long phone = Long.parseLong(acn.getText().toString().trim());

                admin.setAname(aname.getText().toString().trim());
                admin.setAage(age1);
                admin.setAemail(aemail.getText().toString().trim());
                admin.setAcn(phone);
                admin.setAnic(anic.getText().toString().trim());
                admin.setApass(apass.getText().toString().trim());
                reff.push().setValue(admin);
                Toast.makeText(Reigister.this, "Inserted", Toast.LENGTH_LONG).show();
            }
        });

    }
}