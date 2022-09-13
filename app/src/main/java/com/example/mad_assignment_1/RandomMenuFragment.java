package com.example.mad_assignment_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RandomMenuFragment extends Fragment {



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
        View v = inflater.inflate(R.layout.fragment_random_menu,container, false);
        RecyclerView rv = v.findViewById(R.id.RandomMenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RandomMenuAdapter menuAdapter = new RandomMenuAdapter();
        rv.setAdapter(menuAdapter);
        return v;
    }
}