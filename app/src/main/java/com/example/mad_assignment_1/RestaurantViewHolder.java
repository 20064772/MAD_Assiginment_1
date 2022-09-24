/**
 * View holder for the Resturant recyclerview
 *
 * @class           RestaurantViewHolder
 * @extends         RecyclerView.ViewHolder
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    ImageView logo;
    TextView name;
    Button select;

    public RestaurantViewHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.logo);
        name = itemView.findViewById(R.id.name);
        select = itemView.findViewById(R.id.select);
    }
}
