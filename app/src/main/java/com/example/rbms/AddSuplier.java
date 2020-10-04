package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSuplier extends AppCompatActivity {

    EditText supname,supage,supemail,supcontact,supnic;
    Button supadd;
    DatabaseReference reff;
    Supplier supplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_suplier );
        Toast.makeText(AddSuplier.this, "Database Connected", Toast.LENGTH_LONG).show();

        supname = findViewById(R.id.editTextTextPersonName3);
        supage = findViewById(R.id.editTextTextPersonName4);
        supemail = findViewById(R.id.editTextTextPersonName5);
        supcontact = findViewById(R.id.editTextTextPersonName6);
        supnic = findViewById(R.id.editTextTextPersonName7);
        supadd = findViewById(R.id.button5);
        supplier = new Supplier();
        reff = FirebaseDatabase.getInstance().getReference().child("Supplier");

        supadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age1 = Integer.parseInt(supage.getText().toString().trim());
                Long phone = Long.parseLong(supcontact.getText().toString().trim());

                supplier.setSupname(supname.getText().toString().trim());
                supplier.setSupage(age1);
                supplier.setSupemail(supemail.getText().toString().trim());
                supplier.setSupcontact(phone);
                supplier.setSupnic(supnic.getText().toString().trim());
                reff.push().setValue(supplier);
                Toast.makeText(AddSuplier.this, "Data Inserted !", Toast.LENGTH_LONG).show();
            }
        });

    }
}