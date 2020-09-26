package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminDashBoard extends AppCompatActivity {

    Button Lmanager;
    Button Smanager;
    Button Supmanager;
    Button Paymanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_dash_board );

        Lmanager = (Button)findViewById(R.id.button2);
        Smanager = (Button)findViewById(R.id.button3);
        Supmanager = (Button)findViewById(R.id.button6);
        Paymanager = (Button)findViewById(R.id.button11);


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