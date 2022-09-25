package com.example.mad_assignment_1;

/**
 * Class containing information relating to a historical order
 *
 * @class           Order
 * @author          Tristan S. Tutungis
 * @date_created    25/09/2022
 * @last_modified   25/09/2022 20:33
 */
public class Order
{
    private Basket dishes;
    private String date_time;
    private String user;

    public Order(String date_time, String user)
    {
        this.dishes = new Basket();
        this.date_time = date_time;
        this.user = user;
    }

    public String getDateTime()
    {
        return this.date_time;
    }

    public String getUser()
    {
        return this.user;
    }

    public void addDish(Dish dish, int qty)
    {
        for(int i = 0; i < qty; i++) dishes.add(dish);
    }
}
