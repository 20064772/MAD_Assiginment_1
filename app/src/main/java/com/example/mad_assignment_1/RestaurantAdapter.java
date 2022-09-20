package com.example.mad_assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;
    public RestaurantAdapter(List<Restaurant> res){
        this.restaurantList = res;

    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.restaurant_item,parent, false);
        RestaurantViewHolder restaurantViewHolder = new RestaurantViewHolder(v);
        return restaurantViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant rest = restaurantList.get(position);
        holder.logo.setImageResource(rest.getDrawable());
        holder.name.setText(rest.getName());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
