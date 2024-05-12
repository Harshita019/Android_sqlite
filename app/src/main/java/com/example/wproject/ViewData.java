package com.example.wproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {

    ArrayList<Modal> modalArrayList;
    DBHelper db;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        recyclerView = findViewById(R.id.recyclerview);

        modalArrayList = new ArrayList<>();

        db = new DBHelper(ViewData.this);

                Log.d("MYTAG", "onCreate: " + db.fetchData());

                modalArrayList = db.fetchData();
                recyclerView.setAdapter(new UserAdapter(ViewData.this, modalArrayList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setHasFixedSize(false);

            }



    }
