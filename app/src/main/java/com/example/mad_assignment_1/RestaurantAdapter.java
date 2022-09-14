package com.example.mad_assignment_1;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;
    public RestaurantAdapter(){

    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
