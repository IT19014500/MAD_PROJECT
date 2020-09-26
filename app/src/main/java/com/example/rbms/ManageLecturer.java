package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageLecturer extends AppCompatActivity {

    Button add;
    Button updateLec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_lecturer );

        add = (Button)findViewById(R.id.button4);
        updateLec = (Button)findViewById(R.id.button7);
    }

    @Override
    protected void onResume() {
        super.onResume();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addL = new Intent(ManageLecturer.this,AddLecturer.class);
                startActivity(addL);
            }
        });
        updateLec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addL = new Intent(ManageLecturer.this,UpdateLecturer.class);
                startActivity(addL);
            }
        });
    }
}