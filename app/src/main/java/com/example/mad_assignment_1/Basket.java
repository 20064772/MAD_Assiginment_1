/**
 * Bsket. A object that hold the held the didhes that are add to be "checked out"
 *  has constructor, getters and settors.
 *
 * @class           Basket
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */


package com.example.mad_assignment_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Basket implements Serializable {

    private final Map mapBasket;
    private float total;
    public Basket(){
        mapBasket = new HashMap<String, BasketDish>();
        total = 0;
    }

    public Map getMapBasket() {
        return mapBasket;
    }

    public void add(Dish inDish){
        BasketDish bd;
        if (mapBasket.get(inDish.getName()) == null){
            bd = new BasketDish(inDish);
            mapBasket.put(bd.getDishName(), bd);
        }
        else{
            bd = (BasketDish) mapBasket.get(inDish.getName());
            bd.addCount();
        }

        total+=inDish.getPrice();
    }

    public void minus(Dish inDish){
        if (mapBasket.get(inDish.getName()) != null){
            BasketDish bd = (BasketDish) mapBasket.get(inDish.getName());
            bd.minusCount();
            total-=inDish.getPrice();
            if (bd.getCount() == 0){
                mapBasket.remove(bd.getDishName());
            }
        }
    }

    public int getCount(Dish dish){
        int i = 0;
        if (mapBasket.get(dish.getName()) != null){
            BasketDish bd = (BasketDish) mapBasket.get(dish.getName());
            i = bd.getCount();
        }
        return i;
    }

    public float getTotal() {
        return total;
    }
}
