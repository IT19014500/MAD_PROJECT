package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageSupplier extends AppCompatActivity {

    Button add;
    Button updateSup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_supplier );

        add = (Button)findViewById(R.id.button4);
        updateSup = (Button)findViewById(R.id.button7);

    }

    @Override
    protected void onResume() {
        super.onResume();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSup= new Intent(ManageSupplier.this,AddSuplier.class);
                startActivity(addSup);
            }
        });
        updateSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSup= new Intent(ManageSupplier.this,UpdateSupplier.class);
                startActivity(addSup);
            }
        });
    }
}