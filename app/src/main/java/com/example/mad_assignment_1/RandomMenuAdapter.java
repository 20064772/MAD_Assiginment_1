package com.example.mad_assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class  RandomMenuAdapter extends RecyclerView.Adapter<RandomMenuViewHolder> {

    List<Restaurant> restaurantList;
    private SharedViewModel viewModel;
    Random ran = new Random();
    public RandomMenuAdapter(List<Restaurant> restaurantList, SharedViewModel viewModel){
        this.restaurantList = restaurantList;
        this.viewModel = viewModel;
    }
    @NonNull
    @Override
    public RandomMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.random_menu_item,parent,false);
        RandomMenuViewHolder myViewHolder = new RandomMenuViewHolder(v, restaurantList, viewModel);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomMenuViewHolder holder, int position) {
        Menu menu = restaurantList.get(position).getMenu();
        int item = ran.nextInt(menu.getSize());
        Dish dish = menu.getDish(item);
        holder.foodImage.setImageResource(dish.getDrawable());
        holder.resName.setText(restaurantList.get(position).getName());
        holder.name.setText(dish.getName());



    }

    @Override
    public int getItemCount() {

        return restaurantList.size();
    }
}
