/**
 * Menu. Object the stores Dish information for the restaurant object
 * has Constructor, getter and setters.
 *
 * @class           Menu
 * @Implements      Serializable
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {

    ArrayList<Dish> menu;

    public Menu (){
        menu = new ArrayList<>();
    }

    public void addDish(String name, String desc, double price, int draw){
        Dish dish = new Dish(draw,name,desc,price);
        menu.add(dish);
    }

    public void addDish(Dish dish)
    {
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
