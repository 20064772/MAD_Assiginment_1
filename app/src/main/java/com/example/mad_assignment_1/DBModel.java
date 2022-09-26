package com.example.mad_assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mad_assignment_1.DBSchema.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Database Model Class - Facilitates database table manipulation
 *
 * @class           DBModel
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   24/09/2022 22:02
 */
public class DBModel
{
    private final SQLiteDatabase db; //The database
    
    /**
     * Creates a new object containing a writeable database
     *
     * @param context   (Context)
     */
    public DBModel(Context context)
    {
        this.db = new DBHelper(context).getWritableDatabase();
    }

    /**
     * Closes the SQLiteDatabase connection
     */
    public void close()
    {
        this.db.close();
    }

    /**
     * Adds a user with a given email and password which is SHA-512 hashed
     *
     * @param email     (String) Email address of user to be added
     * @param passwd    (String) Plain-text password of the user to be added
     * @throws IllegalArgumentException if the user already exists
     */
    public void addUser(String email, String passwd) throws IllegalArgumentException
    {
        
        if(!findUser(email, passwd))
        {
            ContentValues cv = new ContentValues();
    
            cv.put(UserTable.Columns.EMAIL, email);
            cv.put(UserTable.Columns.PASS, hashPasswd(passwd));
    
            db.insert(UserTable.NAME, null, cv);
        } else throw new IllegalArgumentException("User already exists");
    }
    
    /**
     * Finds whether a user with a given email exists
     *
     * @param email     (String) Email address of user to be added
     * @param passwd    (String) Plain-text password of the user to be added
     * @return          (boolean) true if the user exists, false otherwise
     */
    public boolean findUser(String email, String passwd)
    {
        boolean userExists;

        try (UserCursor cursor = new UserCursor(db.query(UserTable.NAME, null,
                UserTable.Columns.EMAIL + " = ? AND " + UserTable.Columns.PASS + " = ?",
                new String[]{email, hashPasswd(passwd)}, null, null, "1"))) {
            userExists = cursor.getCount() != 0;
        }
        
        return userExists;
    }

    /**
     * Gets a list of the restaurants from the DB
     *
     * @return restaurantList   (List<Restaurant>)
     */
    public ArrayList<Restaurant> getRestaurants()
    {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        String restaurantName;

        try (RestaurantCursor restCursor = new RestaurantCursor(
                db.query(RestaurantTable.NAME, null, null, null, null, null, null))) {
            restCursor.moveToFirst();
            while (!restCursor.isAfterLast()) {
                restaurantName = restCursor.getName();

                restaurantList.add(new Restaurant(restaurantName, restCursor.getDrawable(), getMenu(restaurantName)));
                restCursor.moveToNext();
            }
        }

        return restaurantList;
    }

    public void addToOrderHistory(Basket basket, String user)
    {
        ContentValues cv = new ContentValues();
        LocalDateTime now = LocalDateTime.now();
        for (Object bdObj : basket.getMapBasket().values())
        {
            if(bdObj instanceof BasketDish) {
                BasketDish bd = (BasketDish)bdObj;

                cv.put(OrderHistoryTable.Columns.USER, user);
                cv.put(OrderHistoryTable.Columns.DATETIME, now.toString());
                cv.put(OrderHistoryTable.Columns.ITEM, bd.getDishName());
                cv.put(OrderHistoryTable.Columns.QTY, bd.getCount());

                db.insert(OrderHistoryTable.NAME, null, cv);
                cv.clear();
            } else throw new IllegalArgumentException();
        }
    }

    public ArrayList<Order> getOrders(String user)
    {
        ArrayList<Order> orderList = new ArrayList<>();
        String date, curDate = "";
        Order curOrder = null;
        Dish dish;

        try (OrderHistoryCursor cursor = new OrderHistoryCursor(db.query(OrderHistoryTable.NAME, null,
                OrderHistoryTable.Columns.USER + " = ?", new String[]{user}, null, null,
                OrderHistoryTable.Columns.DATETIME + " ASC"))) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {//here  while (!cursor.isAfterLast())
                date = cursor.getDateTime();
                /* If the date being read is different to the current date
                    value stored, pop the current order onto the list and start
                    a new one */
                if (!curDate.equals(date)) {
                    if (!curDate.equals("")) {
                        orderList.add(curOrder);
                    }

                    curDate = date;
                    curOrder = new Order(curDate, user, findRestaurant(cursor.getDishName()));
                }

                dish = findDish(cursor.getDishName());
                curOrder.addDish(dish, cursor.getQty());

                cursor.moveToNext();
            }
        }

        return orderList;
    }

    private String findRestaurant(String dishName)
    {
        String rest;
        MenuCursor cursor = new MenuCursor(db.query(MenuTable.NAME, null,
                MenuTable.Columns.ITEM + " = ?",
                new String[]{dishName}, null, null, null));

        try
        {
            cursor.moveToFirst();
            rest = cursor.getRestaurant();
        }
        finally
        {
            cursor.close();
        }

        return rest;
    }

    private Dish findDish(String dishName)
    {
        Dish dish;
        MenuCursor cursor = new MenuCursor(db.query(MenuTable.NAME, null,
                MenuTable.Columns.ITEM + " = ?",
                new String[]{dishName}, null, null, null));

        try
        {
            cursor.moveToFirst();
            dish = cursor.getDish();
        }
        finally
        {
            cursor.close();
        }

        return dish;
    }

    /**
     * Retrieves a menu for a given restaurant from the DB
     *
     * @param menuName  (String) Name of the restaurant
     * @return menu     (Menu) The menu associated with that restaurant
     */
    private Menu getMenu(String menuName)
    {
        MenuCursor menuCursor = new MenuCursor(db.query(MenuTable.NAME, null, MenuTable.Columns.REST + " = ?",
                new String[]{menuName}, null, null, null));
        Menu menu = new Menu();

        try
        {
            menuCursor.moveToFirst();

            while(!menuCursor.isAfterLast())
            {
                menu.addDish(menuCursor.getDish());
                menuCursor.moveToNext();
            }
        }
        finally
        {
            menuCursor.close();
        }

        return menu;
    }
    
    /**
     * Hashes a given password with SHA-512
     *
     * @param passwd    (String) The clear text password to be hashed
     * @return          (String) The hashed password
     */
    private String hashPasswd(String passwd)
    {
        String hashedPasswd;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            hashedPasswd = new String(md.digest(passwd.getBytes(StandardCharsets.UTF_8)));
        }
        catch (NoSuchAlgorithmException e) {hashedPasswd = null;}
        return hashedPasswd;
    }
}
