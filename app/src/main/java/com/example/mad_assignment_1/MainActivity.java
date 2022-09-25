/**
 * MainActivty.
 *
 * @class           MainActivity
 * @extends         AppCompatActivity
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

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

        DBModel db = new DBModel(getApplicationContext());
        ArrayList<Restaurant> restaurantList = db.getRestaurants();

        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        RandomMenuFragment rmf = (RandomMenuFragment) fm.findFragmentById(R.id.rmrl);

        if (rmf == null)
        {
            Bundle b = new Bundle();
            b.putSerializable("list", /*(Serializable)*/ restaurantList);// Stores restaurantList in a bundle to pass to the random menu fragment.

            rmf = new RandomMenuFragment();
            rmf.setArguments(b);
            fm.beginTransaction().add(R.id.mainFrag, rmf).commit();
        }
    }
}


