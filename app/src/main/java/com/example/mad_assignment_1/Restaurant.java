/**
 * Object the hold restaurant data
 *
 * @class           Restaurant
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */


package com.example.mad_assignment_1;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private String name;
    private int drawable;
    private Menu menu;

    public Restaurant(String name, int drawable)
    {
        this.name = name;
        this.drawable = drawable;
        this.menu = null;
    }

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

    protected void setMenu(Menu menu)
    {
        this.menu = menu;
    }
}
