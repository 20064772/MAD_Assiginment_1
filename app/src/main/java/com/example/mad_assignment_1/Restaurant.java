package com.example.mad_assignment_1;

public class Restaurant {

    private String name;
    private int drawable;
    private Menu menu;


    public Restaurant(String name, int drawable, Menu menu){
        this.name = name;
        this.drawable = drawable;
        this.menu = menu;
    }

    public String getName(){
        return name;
    }

    public int getDrawable() {
        return drawable;
    }

    public Menu getMenu() {
        return menu;
    }
}
