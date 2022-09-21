package com.example.mad_assignment_1;

import java.util.HashMap;

public class BasketDish {

    private int count;
    Dish dish;
    public BasketDish(Dish dish){
        this.dish = dish;
        this.count = 1;
    }

    public void addCount(){
        count++;
    }

    public void minusCount(){
        if (count > 0){
            count --;
        }
    }

    public int getCount() {
        return count;
    }

    public Dish getDish() {
        return dish;
    }

    public String getDishName(){
        return dish.getName();
    }
}
