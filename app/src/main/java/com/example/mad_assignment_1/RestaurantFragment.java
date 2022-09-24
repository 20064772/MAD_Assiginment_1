/**
 * Restaurant Fragment. holds the recycler view for the restaurants.
 *
 * @class           RestaurantFragment
 * @extends         Fragment
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class RestaurantFragment extends Fragment {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;

    public RestaurantFragment() {
        // Required empty public constructor
    }

    public static RestaurantFragment newInstance(String param1, String param2) {
        RestaurantFragment fragment = new RestaurantFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        restaurantList = viewModel.getRestaurantList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_restaurant,container, false);
        RecyclerView rv = v.findViewById(R.id.RestaurantRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantList, viewModel);//maybe like this
        rv.setAdapter(restaurantAdapter);
        return v;
    }
}