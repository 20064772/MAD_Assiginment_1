/**
 *  Fragment adapter for the menu fragment. this holds the recycler view
 *
 * @class           MenuAdapter
 * @extends         RecyclerView.Adapter
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */


package com.example.mad_assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private Restaurant restaurant;
    private Menu menuList;
    private String name;
    private Basket checkOut;
    private TextView total;


    //construtor
    public MenuAdapter(Restaurant res, Basket basket, TextView total) {
        this.restaurant = res;
        menuList  = restaurant.getMenu();
        this.checkOut = basket;
        this.total = total;
    }


    //On create. inflates the view held int the recyclerView
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.menu_item,parent,false);
        MenuViewHolder myViewHolder = new MenuViewHolder(v);
        return myViewHolder;
    }


    //on bond view holder. binds the elements of the views held in the recycler view.
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        holder.name.setText(menuList.getDish(position).getName());
        holder.description.setText(menuList.getDish(position).getDescription());
        holder.pic.setImageResource(menuList.getDish(position).getDrawable());
        holder.price.setText("$" + String.valueOf(menuList.getDish(position).getPrice()));
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //adds a dish to the basket and increments the count.
                checkOut.add(menuList.getDish(holder.getAbsoluteAdapterPosition()));
                int x = checkOut.getCount(menuList.getDish(holder.getAbsoluteAdapterPosition()));
                holder.count.setText(String.valueOf(x));
                total.setText("$" + String.valueOf(checkOut.getTotal()));
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() { //removes a dish from the basket and decrments the count.
            @Override
            public void onClick(View view) {
                checkOut.minus(menuList.getDish(holder.getAbsoluteAdapterPosition()));
                int x = checkOut.getCount(menuList.getDish(holder.getAbsoluteAdapterPosition()));
                holder.count.setText(String.valueOf(x));
                total.setText("$" + String.valueOf(checkOut.getTotal()));
            }
        });

    }

    @Override
    public int getItemCount() { // returns the number of items in the menu
        return menuList.getSize();
    }
}
