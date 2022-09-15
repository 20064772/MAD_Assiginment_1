package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


//I think database needs to be read into objects at the start. List<Restaurants>
//Restarunt holds Menu Object which is list of dishes.