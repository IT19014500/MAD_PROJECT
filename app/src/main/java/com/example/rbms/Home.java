package com.example.rbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login,regi;
    private int counter=5;
    private TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );

        name =(EditText)findViewById(R.id.editTextTextPersonName);
        password =(EditText)findViewById(R.id.editTextTextPersonName2);
        login = (Button) findViewById(R.id.button);
        regi = findViewById(R.id.button16);
        info = (TextView)findViewById(R.id.textView46);




        info.setText("Number of Attempts Remaining : 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

    }


    private void validate(String userName, String userPassword ){
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Home.this, adminDashBoard.class);
            startActivity(intent);
        }
        if ((userName.equals("Paymanager")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Home.this, ManagePayment.class);
            startActivity(intent);
        }
        if ((userName.equals("Stmanager")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Home.this, ManageStudent.class);
            startActivity(intent);
        }
        if ((userName.equals("Supplier")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Home.this, SupplierDashBoard.class);
            startActivity(intent);
        }
        if ((userName.equals("Lecturer")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Home.this, LecturerDashBoard.class);
            startActivity(intent);
        }
        if ((userName.equals("Student")) && (userPassword.equals("1234"))) {
            Intent intent1 = new Intent(Home.this, StudentDashBoard.class);
            startActivity(intent1);
        }else {
            counter--;
            info.setText("Number of Attempts Remaining : "+ String.valueOf(counter));

            if (counter==0){
                login.setEnabled(false);

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regp = new Intent(Home.this,Reigister.class);
                startActivity(regp);
            }
        });
    }
}