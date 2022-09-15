package com.example.mad_assignment_1;

/**
 * Database Schema Class - Contains inner classes for each table and the columns in those tables
 *
 * @author          Tristan S. Tutungis
 * @date_created    15/09/2022
 * @last_modified   15/09/2022 15:51
 */
public class DBSchema
{
    public static class UserTable
    {
        public static final String NAME = "users";
        public static class Columns
        {
            public static final String EMAIL = "email"; //Email address
            public static final String USER = "username"; //Username
            public static final String PASS = "password"; //Password
        }
    }

    public static class OrderHistoryTable
    {
        public static final String NAME = "order_history";
        public static class Columns
        {
            public static final String USER = "username";
            public static final String DATE = "date";
            public static final String ITEM = "item";
            public static final String PRICE = "price";
        }
    }

    public static class MenuTable
    {
        public static final String NAME = "menu";
        public static class Columns
        {
            public static final String ITEM = "item";
            public static final String IMG = "image";
            public static final String DESC = "description";
            public static final String PRICE = "price";
        }
    }
}
