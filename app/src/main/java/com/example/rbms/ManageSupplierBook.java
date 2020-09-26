package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageSupplierBook extends AppCompatActivity {

    Button addSbook;
    Button updateSbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manage_supplier_book );

        addSbook = (Button)findViewById(R.id.button4);
        updateSbook = (Button)findViewById(R.id.button7);

    }

    @Override
    protected void onResume() {
        super.onResume();
        addSbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sBook = new Intent(ManageSupplierBook.this,AddSupplierBook.class);
                startActivity(sBook);
            }
        });
        updateSbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sBook = new Intent(ManageSupplierBook.this,UpdateSupplierBook.class);
                startActivity(sBook);
            }
        });
    }
}