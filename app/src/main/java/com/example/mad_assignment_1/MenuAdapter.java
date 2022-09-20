package com.example.mad_assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private Restaurant restaurant;
    private Menu menuList;
    String name;

    public MenuAdapter(Restaurant res) {
        this.restaurant = res;
        menuList  = restaurant.getMenu();

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.menu_item,parent,false);
        MenuViewHolder myViewHolder = new MenuViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        holder.name.setText(menuList.getDish(position).getName());
        holder.description.setText(menuList.getDish(position).getDescription());
        holder.pic.setImageResource(menuList.getDish(position).getDrawable());

    }

    @Override
    public int getItemCount() {
        return menuList.getSize();
    }
}
