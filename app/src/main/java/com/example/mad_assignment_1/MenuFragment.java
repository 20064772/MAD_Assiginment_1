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


public class MenuFragment extends Fragment {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;
    String resName;
    Restaurant restaurant;

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

        for (Restaurant i : restaurantList)
        {
            if (i.getName()== resName)
            {
                restaurant = (Restaurant) i;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu,container, false);
        RecyclerView rv = v.findViewById(R.id.MenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuAdapter menuAdapter = new MenuAdapter(restaurant);
        rv.setAdapter(menuAdapter);
        return v;
    }
}