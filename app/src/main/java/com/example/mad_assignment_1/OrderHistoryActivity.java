/**
 * OrderHistoryActivity. Holds a recylerView that displays the order history
 *
 * @class           OrderHistoryActivty
 * @extends         AppCompatActivity
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class OrderHistoryActivity extends AppCompatActivity {

    TextView emailview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        //emailview = findViewById(R.id.emaildisplay); /** need to set this to the user email from DB */
        /**
         *  I think an object will need to be created to store the each order for the user.
         *  then pass the object to the adapter. I havent created anything.
         */
        RecyclerView rv = findViewById(R.id.orderhistoryrecview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        OrderHistoryAdapter orderHistoryAdapter = new OrderHistoryAdapter(/** some object*/);
        rv.setAdapter(orderHistoryAdapter);

    }
}