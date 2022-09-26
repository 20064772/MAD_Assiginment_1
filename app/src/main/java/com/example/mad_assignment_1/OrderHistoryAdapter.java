/**
 * Adapter for the orderHistory recyclerview
 *
 * @class           OrderHistoryAdaptr
 * @extends         RecyclerView.Adapter
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryViewHolder> {

    ArrayList<Order> orders;
    public OrderHistoryAdapter(ArrayList<Order> orders){
        this.orders = orders;
    }


    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.order_history_item,parent,false);
        OrderHistoryViewHolder orderHistoryViewHolder = new OrderHistoryViewHolder(v);
        return orderHistoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        /*
         * need to set the below to the data pulled from the DB/object
         * commented out so the program runs
         */
        //holder.resName.setText();
        //holder.dateTime.setText();
        /*
         *  was thinking a FOR loop for each dish in some list ie:
         *  For (Dish i : orderHistorydishlist)
         *         {
         *             holder.orderHistory.append("Dish: "i.getItem() + " Quant: " + i.getCount() +"\n"  );
         *         }
         *
         */
        //holder.cost.setText();
        holder.bind(orders.get(position));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
