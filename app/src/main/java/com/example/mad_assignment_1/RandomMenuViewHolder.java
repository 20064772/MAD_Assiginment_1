package com.example.mad_assignment_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RandomMenuViewHolder extends RecyclerView.ViewHolder {
    ImageView foodImage;
    TextView name;
    TextView resName;
    Button select;

    public RandomMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        foodImage = itemView.findViewById(R.id.foodImage);
        name = itemView.findViewById(R.id.foodName);
        resName = itemView.findViewById(R.id.restaurantName);
        select = itemView.findViewById(R.id.select);

    }
}
