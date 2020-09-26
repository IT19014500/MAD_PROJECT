package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageRefBook extends AppCompatActivity {

    Button updateRefB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_ref_book );

        updateRefB = (Button)findViewById(R.id.button7);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateRefB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refB = new Intent(ManageRefBook.this,UpdateRefBook.class);
                startActivity(refB);
            }
        });
    }
}