package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * call method to populate database. Im not sure how you have done it.
         */

        List<Restaurant> restaurantList = new ArrayList<Restaurant>();
        RestaurantList.getList(restaurantList); /** this well need to be replaced with a method call to populate the List with the restaurants for the database*/
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        RandomMenuFragment rmf = (RandomMenuFragment) fm.findFragmentById(R.id.rmrl);

        if (rmf == null)
        {
            Bundle b = new Bundle();
            b.putSerializable("list", (Serializable) restaurantList);

            rmf = new RandomMenuFragment();
            rmf.setArguments(b);
            fm.beginTransaction().add(R.id.mainFrag, rmf).commit();
        }
    }
}


