package com.example.mad_assignment_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RandomMenuViewHolder extends RecyclerView.ViewHolder {
    ImageView foodImage;
    TextView name;
    TextView resName;
    Button select;
    private SharedViewModel viewModel;

    public RandomMenuViewHolder(@NonNull View itemView, List<Restaurant> resList, SharedViewModel viewModel) {
        super(itemView);
        this.viewModel = viewModel;
        foodImage = itemView.findViewById(R.id.foodImage);
        name = itemView.findViewById(R.id.foodName);
        resName = itemView.findViewById(R.id.restaurantName);
        select = itemView.findViewById(R.id.select);
    }
}


