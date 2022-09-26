package com.example.mad_assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mad_assignment_1.DBSchema.*;

/**
 * Database Helper Class - Facilitates database creation, upgrading and
 *  preloading with restaurant and menu information
 *
 * @class           DBHelper
 * @inherits        android.database.sqlite.SQLiteOpenHelper
 * @author          Tristan S. Tutungis
 * @date_created    15/09/2022
 * @last_modified   25/09/2022 17:33
 */
public class DBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;               //Database version
    private static final String DB_NAME = "Food.db";    //Database name

    /**
     * Single constructor for the Database Helper Class
     *
     * @param context   (Context)
     */
    public DBHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    /**
     * Configures the database connection - enables foreign-key support
     *
     * @param db    (SQLiteDatabase) - The database object
     */
    @Override
    public void onConfigure(SQLiteDatabase db)
    {
        /* Enables foreign key constraints */
        db.setForeignKeyConstraintsEnabled(true);
    }

    /**
     * Creates the database schema
     *
     * @param db    (SQLiteDatabase) - The database object
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        /* Creates the database schema */
        createTables(db);

        /* Populates restaurant tables with default values */
        fillRestaurantTable(db);
        fillMenuTable(db);
    }

    /**
     * Upgrades database schema
     *
     * @param db    (SQLiteDatabase) - The database object
     * @param i     (int) - Old version number
     * @param i1    (int) - New version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    /**
     * Creates the tables representing the database schema
     *
     * @param db    (SQLiteDatabase) - The database object
     */
    private void createTables(SQLiteDatabase db)
    {
        /* Creates User Table */
        db.execSQL("CREATE TABLE " + UserTable.NAME + " (" +
                UserTable.Columns.EMAIL + " TEXT PRIMARY KEY, " +
                UserTable.Columns.PASS + " TEXT) "
        );

        /* Creates Restaurant Table */
        db.execSQL("CREATE TABLE " + RestaurantTable.NAME + " (" +
                RestaurantTable.Columns.REST + " TEXT PRIMARY KEY, " +
                RestaurantTable.Columns.LOGO + " INTEGER) "
        );

        /* Creates Menu Table */
        db.execSQL("CREATE TABLE " + MenuTable.NAME + " (" +
                MenuTable.Columns.ITEM + " TEXT, " +
                MenuTable.Columns.REST + " TEXT, " +
                MenuTable.Columns.IMG + " INTEGER, " +
                MenuTable.Columns.DESC + " TEXT, " +
                MenuTable.Columns.PRICE + " REAL, " +
                "PRIMARY KEY (" +
                MenuTable.Columns.ITEM + ", " +
                MenuTable.Columns.REST + "), " +
                "FOREIGN KEY (" + MenuTable.Columns.REST +
                ") REFERENCES " + RestaurantTable.NAME +
                " (" + RestaurantTable.Columns.REST +
                "))"
        );

        /* Creates Order History Table */
        db.execSQL("CREATE TABLE " + OrderHistoryTable.NAME + " (" +
                OrderHistoryTable.Columns.USER + " TEXT, " +
                OrderHistoryTable.Columns.DATETIME + " TEXT, " +
                OrderHistoryTable.Columns.ITEM + " TEXT, " +
                OrderHistoryTable.Columns.QTY + " INTEGER, " +
                "PRIMARY KEY (" +
                OrderHistoryTable.Columns.USER + ", " +
                OrderHistoryTable.Columns.DATETIME + ", " +
                OrderHistoryTable.Columns.ITEM + "), " +
                "FOREIGN KEY (" + OrderHistoryTable.Columns.USER +
                ") REFERENCES " + UserTable.NAME +
                " (" + UserTable.Columns.EMAIL +
                "))"
                /*"FOREIGN KEY (" + OrderHistoryTable.Columns.ITEM +
                ") REFERENCES " + MenuTable.NAME +
                " (" + MenuTable.Columns.ITEM +
                "))"*/ /* This doesn't work. Can't figure out why */
        );
    }

    /**
     * Fills the restaurant table with the restaurant names
     *
     * @param db
     */
    private void fillRestaurantTable(SQLiteDatabase db)
    {
        /* Restaurant names */
        final String[] restaurantNames = {
                "Grilld",
                "Hungry Jack's",
                "KFC",
                "McDonald's",
                "Pizza Hut",
                "Red Rooster",
                "Subway",
                "Zambrero"
        };

        /* Integer values representing restaurant logos - must be in the same
            order as the restaurant names */
        final int[] restaurantImgs = {
                R.drawable.grilld_logo,
                R.drawable.hj_logo,
                R.drawable.kfc_logo,
                R.drawable.mcdonalds_logo_1,
                R.drawable.pizzahut_logo,
                R.drawable.redrooster_logo,
                R.drawable.subway_logo,
                R.drawable.zambrero_logo
        };

        ContentValues cv = new ContentValues();

        /* Iterates through the arrays, constructs each tuple and adds them to
            the database */
        for (int i = 0; i < restaurantImgs.length; i++)
        {
            cv.put(RestaurantTable.Columns.REST, restaurantNames[i]);
            cv.put(RestaurantTable.Columns.LOGO, restaurantImgs[i]);

            db.insertOrThrow(RestaurantTable.NAME, null, cv);
            cv.clear();
        }
    }
    /**
     * Fills the menu table with the item details
     *
     * @param db
     */
    private void fillMenuTable(SQLiteDatabase db)
    {
        final String[] restaurantNames = {
                "Grilld",
                "Hungry Jack's",
                "KFC",
                "McDonald's",
                "Pizza Hut",
                "Red Rooster",
                "Subway",
                "Zambrero"
        };

        /* Grilld */
        addDishes(db, restaurantNames[0], new Dish[]{
                new Dish(R.drawable.grilld_chips_snack, "Chips", "Snack sized hot chips", 5.0),
                new Dish(R.drawable.grilld_sweetpotatochips, "Sweet Potato Chips", "Snack sized hot sweet potato chips", 6.0),
                new Dish(R.drawable.grilld_simply_grilld_traditional, "Traditional Grilld", "A simple classic burger", 14.0),
                new Dish(R.drawable.grilld_crispybaconandcheese, "Crispy Bacon & Cheese Burger", "Our famous burger patty with crispy bacon and cheddar cheese", 15.0),
                new Dish(R.drawable.grilld_mustardandpickled, "Mustard & Pickle", "Our famous burger with lots of mustard and pickles", 16.0),
                new Dish(R.drawable.grilld_summersunset, "Summer sunset burger", "Burger with guacamole, grilled pineapple and aioli", 16.0),
                new Dish(R.drawable.grilld_mighty_trad, "Mighty Traditional Burger", "Our famous burger just MIGHTY", 18.0)
        });

        /* Hungry Jack's */
        addDishes(db, restaurantNames[1], new Dish[]{
                new Dish(R.drawable.hj_double_cheeseburger, "Double Cheeseburger", "Flame grilled burger with double beef and double cheese", 10.0),
                new Dish(R.drawable.hj_whopper, "Whopper", "Our famous flame grilled burger", 9.0),
                new Dish(R.drawable.hj_whopper_with_cheese, "Whopper with Cheese", "Our famous flame grilled burger with cheese", 9.50),
                new Dish(R.drawable.hj_ultimate_double_whopper, "Ultimate Whopper", "A whopper with double beef, double cheese and bacon", 12.0),
                new Dish(R.drawable.hj_fried_chicken_classic, "Fried Chicken Classic Burger", "Fried chicken burger", 10.0)
        });

        /* KFC */
        addDishes(db, restaurantNames[2], new Dish[]{
                new Dish(R.drawable.kfc_original_recipe, "Original Recipe Fried Chicken", "Our world famous fried chicken coated in 7 secret herbs and spices", 15.0),
                new Dish(R.drawable.kfc_original_recipe_buger, "Original Recipe Fried Chicken Burger", "Our world famous fried chicken coated in 7 secret herbs and spices in a burger", 12.0),
                new Dish(R.drawable.kfc_zinger_burger, "Zinger Burger", "Spicy fried chicken burger", 12.0),
                new Dish(R.drawable.kfc_twister, "Twister Wrap", "Our world famous fried chicken in a wrap", 12.0),
                new Dish(R.drawable.kfc_popcorn_chicken, "Popcorn Chicken", "small pieces of fried chicken", 10.0),
                new Dish(R.drawable.kfc_potatogravy, "Potato and Gravy", "Smooth mash potato with rich gravy", 8.0)
        });

        /* McDonald's */
        addDishes(db, restaurantNames[3], new Dish[]{
                new Dish(R.drawable.mcdonals_double_cheeseburger,"Double Cheeseburger", "Double beef, double cheese with pickles", 7.50),
                new Dish(R.drawable.mcdonals_quarter_pounder, "Quarter Pounder", "Grilled 1/4lb beef burger with cheese, sauce and pickles", 9.0),
                new Dish(R.drawable.mcdonals_big_mac, "Big Mac", "Double beef burger with special sauce", 10.0),
                new Dish(R.drawable.mcdonals_chicken_mcnuggets_4pc, "4x Chicken Nuggets", "Four chicken nuggets with your choice of sauce", 7.0),
                new Dish(R.drawable.mcdonals_fries, "Medium Fries", "Medium Fries", 4.0),
                new Dish(R.drawable.mcdonals_fudge_sundae, "Hot Fudge Sundae", "Soft serve ice cream with hot chocolate fudge sauce", 5.50),
                new Dish(R.drawable.mcdonals_mcflurry, "McFlurry", "Soft-serve ice cream with your choice of toppings", 4.0)
        });

        /* Pizza Hut */
        addDishes(db, restaurantNames[4], new Dish[]{
                new Dish(R.drawable.pizzahut_cheese_lovers_pizza, "Cheese Lovers", "Just cheese on a tomato base", 10.0),
                new Dish(R.drawable.pizzahut_hawaiian_pizza, "Hawaiian", "Ham and pineapple on a tomato base", 11.50),
                new Dish(R.drawable.pizzahut_pepperoni_pizza, "Pepperoni", "Pepperoni with cheese on a tomato base", 11.0),
                new Dish(R.drawable.pizzahut_bbq_meatlovers_pizza, "BBQ Meat Lovers", "All the meat with a BBQ sauce base", 13.0),
                new Dish(R.drawable.pizzahut_chicken_supreme_pizza, "Chicken Supreme", "Chicken and all the veggies on a tomato base", 12.0),
                new Dish(R.drawable.pizzahut_super_supreme_pizza, "Super Supreme", "Everything on a tomato base", 13.0)
        });

        /* Red Rooster */
        addDishes(db, restaurantNames[5], new Dish[]{
                new Dish(R.drawable.red_chicken_wings, "Chicken Wings", "3 crispy fried chicken wings with BBQ sauce", 8.50),
                new Dish(R.drawable.red_chicken_strip, "Chicken Strips", "3 Fried Chicken tender loins with your choice of sauce", 9.0),
                new Dish(R.drawable.red_bbq_chicken, "Whole BBQ Chicken", "A whole BBQ chicken coated in herbs and spices", 15.0),
                new Dish(R.drawable.red_chicken_roll, "Chicken Roll", "Hot shredded BBQ chicken in a long roll with mayo", 8.0),
                new Dish(R.drawable.red_rippa, "Ripper Roll", "Fried tenderloins in a long roll with lettuce and mayo", 10.0)
        });

        /* Subway */
        addDishes(db, restaurantNames[6], new Dish[]{
                new Dish(R.drawable.subway_tuna_mayo, "Tuna & Mayo Sub", "12 inch sub with tuna pieces and mayo", 10.0),
                new Dish(R.drawable.subway_blt, "BLT Sub", "12 inch sub with Bacon, lettuce and tomato", 12.0),
                new Dish(R.drawable.subway_chicken_teriyak, "Chicken Teriyaki Sub", "12 inch sub with teriyaki chicken", 13.0),
                new Dish(R.drawable.subway_meatball_sub, "Meatball Sub", "12 inch sub with meatballs and red sauce", 13.20),
                new Dish(R.drawable.subway_steak_melt, "Steak Melt sub", "12 inch sub with steak strips and melted cheese", 14.0),
                new Dish(R.drawable.subway_whitechipmacadamianutcookie, "White Chocolate Macadamia Cookie", "Fresh cookie with white chocolate pieces and macadamia nuts", 3.0),
                new Dish(R.drawable.subway_chocolatechipcookie, "Choc Chip Cookie", "Fresh chocolate chip cookie", 3.0)
        });

        /* Zambrero */
        addDishes(db, restaurantNames[7], new Dish[]{
                new Dish(R.drawable.zam_burrito, "Burrito", "Pulled pork, lettuce, corn, rice, beans and cheese in a tortilla", 15.0),
                new Dish(R.drawable.zam_bowl, "Burrito Bowl", "Grilled chicken, lettuce, corn, rice, beans and cheese served in a bowl", 15.0),
                new Dish(R.drawable.zam_dos_capas, "Dos Capas", "Grilled chicken, lettuce, corn, rice, beans and cheese in a hard taco wrapped in a tortilla", 9.0),
                new Dish(R.drawable.zam_quesadillas, "Quesadilla", "Grilled chicken, lettuce, corn, rice, beans and cheese between a toasted flour tortilla", 12.0),
                new Dish(R.drawable.zam_nachos, "Nachos", "Pulled beef, salsa, cheese, guacamole and sour cream over corn chips ", 12.0),
                new Dish(R.drawable.zam_chips, "Chips", "Medium hot chips with Mexican seasoning", 5.0)
        });
    }

    private void addDishes(SQLiteDatabase db, String restaurantName, Dish[] dishes)
    {
        ContentValues cv = new ContentValues();

        /* Iterates through the array of dishes, constructs each tuple and adds
            them to the database */
        for(int i = 0; i < dishes.length; i++)
        {
            cv.put(MenuTable.Columns.ITEM, dishes[i].getName());
            cv.put(MenuTable.Columns.REST, restaurantName);
            cv.put(MenuTable.Columns.IMG, dishes[i].getDrawable());
            cv.put(MenuTable.Columns.DESC, dishes[i].getDescription());
            cv.put(MenuTable.Columns.PRICE, dishes[i].getPrice());

            /* Throws an exception if there is an SQL error - not using
                try-catch as these values are "hard-coded" and therefore an
                exception should not be thrown unless there is a mistake in
                programming */
            db.insertOrThrow(MenuTable.NAME, null, cv);
            cv.clear();
        }
    }
}
