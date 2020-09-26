package com.example.rbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupplierDashBoard extends AppCompatActivity {

    Button addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_supplier_dash_board );

        addBook = (Button)findViewById(R.id.button2);

    }

    @Override
    protected void onResume() {
        super.onResume();
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addBook = new Intent(SupplierDashBoard.this,ManageSupplierBook.class);
                startActivity(addBook);
            }
        });
    }
}