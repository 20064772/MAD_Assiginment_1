package com.example.mad_assignment_1;

import java.util.ArrayList;

public class Menu {

    ArrayList<Dish> menu;

    public Menu (){
        menu = new ArrayList<>();
    }

    public void addDish(String name, String desc, double price, int draw){
        Dish dish = new Dish(draw,name,desc,price);
        menu.add(dish);
    }

    public ArrayList<Dish> getMenu(){
        return menu;
    }

    public int getSize(){
        return menu.size();
    }

    public Dish getDish(int i){
        return menu.get(i);
    }


}
