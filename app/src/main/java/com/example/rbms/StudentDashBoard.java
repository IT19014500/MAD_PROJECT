package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDashBoard extends AppCompatActivity {

    Button addSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_student_dash_board );

        addSupplier = (Button)findViewById(R.id.button2);

    }

    @Override
    protected void onResume() {
        super.onResume();
        addSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSup = new Intent(StudentDashBoard.this,StudentSuppliers.class);
                startActivity(addSup);
            }
        });
    }
}