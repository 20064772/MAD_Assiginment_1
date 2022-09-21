package com.example.mad_assignment_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;


public class MenuViewHolder extends RecyclerView.ViewHolder {
    ImageView pic;
    TextView name;
    TextView description;
    TextView count;
    Button plus;
    Button minus;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        pic = itemView.findViewById(R.id.foodImage);
        name = itemView.findViewById(R.id.foodName);
        description = itemView.findViewById(R.id.description);
        count = itemView.findViewById(R.id.count); // might not be needed
        plus = itemView.findViewById(R.id.plus); //same
        minus = itemView.findViewById(R.id.minus); //same




    }
}
