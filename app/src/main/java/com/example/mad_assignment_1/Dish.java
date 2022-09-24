/**
 * Dish. A simple object that hold the information for each dish that a restaurant has.
 * Has constructor, getter and setter.
 *
 * @class           Dish
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import java.io.Serializable;

public class Dish implements Serializable{

    private String name;
    private String description;
    private int drawable;
    private double price;

    public Dish(int drawableId, String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.drawable = drawableId;
        this.price = price;

    }

    public int getDrawable() {
        return drawable;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {return price;}
}
