package com.example.mad_assignment_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MenuFragment extends Fragment {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;
    String resName;
    Restaurant restaurant;
    Basket basket;

    public MenuFragment() {
        // Required empty public constructor
    }


    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        restaurantList = viewModel.getRestaurantList();
        resName = String.valueOf(viewModel.getViewModelName());
        basket = new Basket();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        for (Restaurant i : restaurantList)
        {
            if (i.getName()== resName)
            {
                restaurant = (Restaurant) i;
            }
        }
        View v = inflater.inflate(R.layout.fragment_menu,container, false);
        Button button = v.findViewById(R.id.checkout);
        TextView total = v.findViewById(R.id.total);
        RecyclerView rv = v.findViewById(R.id.MenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuAdapter menuAdapter = new MenuAdapter(restaurant, basket, total);
        rv.setAdapter(menuAdapter);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheckOutActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}