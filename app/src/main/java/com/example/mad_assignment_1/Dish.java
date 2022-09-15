package com.example.mad_assignment_1;

public class Dish {

    private String name;
    private String description;
    private int drawable;
    private float price;

    public Dish(int drawableId, String name, String description, float price) {
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

    public float getPrice() {return price;}
}
