package com.example.mad_assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {

    private SharedViewModel viewModel;
    List<Restaurant> restaurantList;
    public RestaurantAdapter(List<Restaurant> res, SharedViewModel viewModel){
        this.restaurantList = res;
        this.viewModel = viewModel;
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
        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setNameMutableLiveData(restaurantList.get(holder.getAdapterPosition()).getName());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                MenuFragment menuFragment = new MenuFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrag, menuFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
