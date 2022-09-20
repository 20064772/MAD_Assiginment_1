package com.example.mad_assignment_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        if (getArguments() != null) {
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        restaurantList = new ArrayList<Restaurant>();// might need to move to on create
        RestaurantList.getList(restaurantList);// might need to move to on create
        View v = inflater.inflate(R.layout.fragment_random_menu,container, false);
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);// might need to move to on create
        RecyclerView rv = v.findViewById(R.id.RandomMenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RandomMenuAdapter menuAdapter = new RandomMenuAdapter(restaurantList, viewModel);
        rv.setAdapter(menuAdapter);
        return v;
    }
}