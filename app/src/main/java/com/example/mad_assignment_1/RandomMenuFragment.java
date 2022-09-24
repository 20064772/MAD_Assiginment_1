/**
 * MenuRandomFragment. A fragment that holds the recycler view that displays the RandomMenuVenu.
 *
 * @class           RandomMenufragment
 * @extends         Fragment
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */


package com.example.mad_assignment_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RandomMenuFragment extends Fragment {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;

    public RandomMenuFragment() {
        // Required empty public constructor
    }

    public static RandomMenuFragment newInstance(String param1, String param2) {
        RandomMenuFragment fragment = new RandomMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantList = (List<Restaurant>)getArguments().getSerializable("list");
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);// might need to move to on create
        viewModel.setRestaurantList(restaurantList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_random_menu,container, false);
        RecyclerView rv = v.findViewById(R.id.RandomMenuRecyclerView);
        Button button = v.findViewById(R.id.resbutton);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RandomMenuAdapter menuAdapter = new RandomMenuAdapter(restaurantList, viewModel);
        rv.setAdapter(menuAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                RestaurantFragment restaurantFragment = new RestaurantFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrag,restaurantFragment ).addToBackStack(null).commit();
            }
        });
        return v;
    }
}