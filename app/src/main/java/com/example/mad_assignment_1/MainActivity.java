package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        RandomMenuFragment rmf = (RandomMenuFragment) fm.findFragmentById(R.id.rmrl);

        if (rmf == null)
        {
            Bundle b = new Bundle();

            rmf = new RandomMenuFragment();
            rmf.setArguments(b);
            fm.beginTransaction().add(R.id.mainFrag, rmf).commit();
        }
    }
}


//I think database needs to be read into objects at the start. List<Restaurants>
//Restarunt holds Menu Object which is list of dishes.