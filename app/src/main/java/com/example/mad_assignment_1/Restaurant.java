package com.example.mad_assignment_1;

public class Restaurant {

    private String name;
    private int drawable;


    public Restaurant(String name, int drawable){
        this.name = name;
        this.drawable = drawable;
    }

    public String getName(){
        return name;
    }

    public int getDrawable() {
        return drawable;
    }
}
