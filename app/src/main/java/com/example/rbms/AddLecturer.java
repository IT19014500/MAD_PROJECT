package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddLecturer extends AppCompatActivity {

    EditText name,age,email,contact,nic,subject;
    Button add;
    DatabaseReference reff;
    Lecturer lecturer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_lecturer );
        Toast.makeText(AddLecturer.this, "Database Connected", Toast.LENGTH_LONG).show();

        name = findViewById(R.id.editTextTextPersonName3);
        age = findViewById(R.id.editTextTextPersonName4);
        email = findViewById(R.id.editTextTextPersonName5);
        contact = findViewById(R.id.editTextTextPersonName6);
        nic = findViewById(R.id.editTextTextPersonName7);
        subject = findViewById(R.id.editTextTextPersonName8);
        add = findViewById(R.id.button5);
        lecturer = new Lecturer();
        reff = FirebaseDatabase.getInstance().getReference().child("Lecturer");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age1 = Integer.parseInt(age.getText().toString().trim());
                Long phone = Long.parseLong(contact.getText().toString().trim());

                lecturer.setName(name.getText().toString().trim());
                lecturer.setAge(age1);
                lecturer.setEmail(email.getText().toString().trim());
                lecturer.setPhone(phone);
                lecturer.setNic(nic.getText().toString().trim());
                lecturer.setSubject(subject.getText().toString().trim());
                reff.push().setValue(lecturer);
                Toast.makeText(AddLecturer.this, "Data Inserted Successfully !", Toast.LENGTH_LONG).show();

            }
        });

    }
}