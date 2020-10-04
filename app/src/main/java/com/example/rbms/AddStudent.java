package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudent extends AppCompatActivity {

    EditText sname,sage,semail,scontact,snic,ssubject;
    Button sadd;
    DatabaseReference reff;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_student );
        Toast.makeText(AddStudent.this, "Database Connected", Toast.LENGTH_LONG).show();

        sname = findViewById(R.id.editTextTextPersonName3);
        sage = findViewById(R.id.editTextTextPersonName4);
        semail = findViewById(R.id.editTextTextPersonName5);
        scontact = findViewById(R.id.editTextTextPersonName6);
        snic = findViewById(R.id.editTextTextPersonName7);
        ssubject = findViewById(R.id.editTextTextPersonName8);
        sadd = findViewById(R.id.button5);
        student = new Student();
        reff = FirebaseDatabase.getInstance().getReference().child("Student");

        sadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ages = Integer.parseInt(sage.getText().toString().trim());
                Long phones = Long.parseLong(scontact.getText().toString().trim());

                student.setSname(sname.getText().toString().trim());
                student.setSage(ages);
                student.setSemail(semail.getText().toString().trim());
                student.setScontact(phones);
                student.setSnic(snic.getText().toString().trim());
                student.setSsubject(ssubject.getText().toString().trim());
                reff.push().setValue(student);


                Toast.makeText(AddStudent.this, "Data Inserted Successfully !", Toast.LENGTH_LONG).show();

            }


        });

    }
}