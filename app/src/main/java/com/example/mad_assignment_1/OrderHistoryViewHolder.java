/**
 * OrderHistoryAdaptor View holder. View holder for the orderHistory rcyclerview
 *
 * @class           OrderHistoryViewHolder
 * @extends         RecyclerView.ViewHolder
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class OrderHistoryViewHolder extends RecyclerView.ViewHolder {

    TextView resName;
    TextView dateTime;
    TextView orderHistory;
    TextView cost;
    public OrderHistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        resName = itemView.findViewById(R.id.resname);
        dateTime = itemView.findViewById(R.id.dateandtime);
        orderHistory = itemView.findViewById(R.id.orderhistory);
        cost = itemView.findViewById(R.id.cost);


    }
}
