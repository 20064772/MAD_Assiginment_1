package com.example.mad_assignment_1;

/**
 * Database Schema Class - Contains inner classes for each table and the columns in those tables
 *
 * @class           DBSchema
 * @author          Tristan S. Tutungis
 * @date_created    15/09/2022
 * @last_modified   16/09/2022 22:10
 */

public class DBSchema
{

    /**
     * User Table - contains columns for a user's email and password
     */
    public static class UserTable
    {
        public static final String NAME = "users";
        public static class Columns
        {
            public static final String EMAIL = "email";
            public static final String PASS = "password";
        }
    }
    
    /**
     * Order History Table - contains columns for Username (email), date & time,
     * item, and quantity ordered. Generally, items with an equal
     */
    
    public static class OrderHistoryTable
    {
        public static final String NAME = "order_history";
        public static class Columns
        {
            public static final String USER = "user";
            public static final String DATETIME = "date & time";
            public static final String ITEM = MenuTable.Columns.ITEM;
            public static final String QTY = "quantity";
        }
    }

    /**
     * Menu Table - contains columns for Item name, Restaurant, Image, Description, and price.
     */
    public static class MenuTable
    {
        public static final String NAME = "menu";
        public static class Columns
        {
            public static final String ITEM = "item";
            public static final String REST = RestaurantTable.Columns.REST;
            public static final String IMG = "image";
            public static final String DESC = "description";
            public static final String PRICE = "price";
        }
    }

    /**
     * Restaurant Table - contains columns for Restaurant Name and Logo Image
     */
    public static class RestaurantTable
    {
        public static final String NAME = "restaurants";
        public static class Columns
        {
            public static final String REST = "restaurant";
            public static final String LOGO = "logo_image";
        }
    }

}
