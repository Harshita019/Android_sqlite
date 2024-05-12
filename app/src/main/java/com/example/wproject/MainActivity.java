package com.example.wproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText t_id,t_name, t_address, t_mobile;
    Button submit, view;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_id = findViewById(R.id.id);
        t_name = findViewById(R.id.name);
        t_address = findViewById(R.id.address);
        t_mobile = findViewById(R.id.mobile);

        submit = findViewById(R.id.submit);
        view = findViewById(R.id.view);

        db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = t_id.getText().toString();
                String name = t_name.getText().toString();
                String address = t_address.getText().toString();
                String mobile = t_mobile.getText().toString();

                /*String MobilePattern = "[0-9]{10}";
                String NamePattern = "[a-zA-Z]";*/

                long insert = db.insertdata(id, name, address, mobile);

                if (name.length() == 0 || name.length() == 0 || address.length() == 0 || mobile.length() == 0 )
                {
                    Toast.makeText(getApplicationContext(), "pls fill the empty fields", Toast.LENGTH_SHORT).show();

                }
                /*else if (!name.matches(NamePattern))
                {
                    Toast.makeText(getApplicationContext(), "pls enter valid name", Toast.LENGTH_SHORT).show();
                }*/
                else
                {
                    Toast.makeText(MainActivity.this, "Submitted.", Toast.LENGTH_SHORT).show();
                    t_id.setText("");
                    t_name.setText("");
                    t_address.setText("");
                    t_mobile.setText("");
                }

            }
                /*if (name.equals("") || address.equals("") || mobile.equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill all the necessary details.", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(MainActivity.this, "Submitted.", Toast.LENGTH_SHORT).show();

                    t_name.setText("");
                    t_address.setText("");
                    t_mobile.setText("");
                }
            }*/
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ViewData.class);
                startActivity(i);

            }
        });
    }
}