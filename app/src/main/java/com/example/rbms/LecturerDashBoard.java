package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LecturerDashBoard extends AppCompatActivity {

    Button addRef;
    Button manage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lecturer_dash_board );

        addRef = (Button)findViewById(R.id.button2);
        manage = (Button)findViewById(R.id.button3);

    }

    @Override
    protected void onResume() {
        super.onResume();
        addRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ref = new Intent(LecturerDashBoard.this,AddRefBook.class);
                startActivity(ref);
            }
        });
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ref = new Intent(LecturerDashBoard.this,ManageRefBook.class);
                startActivity(ref);
            }
        });
    }
}