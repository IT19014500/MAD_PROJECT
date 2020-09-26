package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageStudent extends AppCompatActivity {

    Button add;
    Button updateStu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_student );

        add = (Button)findViewById(R.id.button4);
        updateStu = (Button)findViewById(R.id.button7);

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