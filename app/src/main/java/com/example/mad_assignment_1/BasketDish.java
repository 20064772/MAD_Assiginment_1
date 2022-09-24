/**
 * BsketDish. A simple object that hold the information for each dish in stored in the basket
 *  has basic constructor, getters and settors.
 *
 * @class           BasketDish
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */


package com.example.mad_assignment_1;

import java.io.Serializable;
import java.util.HashMap;

public class BasketDish implements Serializable {

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
