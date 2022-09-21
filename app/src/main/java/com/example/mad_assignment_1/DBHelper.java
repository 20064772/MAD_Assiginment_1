package com.example.mad_assignment_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.example.mad_assignment_1.DBSchema.*;
import androidx.annotation.RequiresApi;

/**
 * Database Helper Class - Facilitates database creation and manipulation
 *
 * @class           DBHelper
 * @inherits        android.database.sqlite.SQLiteOpenHelper
 * @author          Tristan S. Tutungis
 * @date_created    15/09/2022
 * @last_modified   16/09/2022 22:10
 */
public class DBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;               //Database version
    private static final String DB_NAME = "Food.db";    //Database name

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DBHelper(Context context)
    {
        super(context, DB_NAME, VERSION, null);
    }

    /**
     * Creates the database schema
     *
     * @param db (SQLiteDatabase) - The database object
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        /* Turns on foreign key constraints */
        db.execSQL("PRAGMA foreign_keys = ON");
    
        /* Creates User Table */
        db.execSQL("CREATE TABLE " + UserTable.NAME + " (" +
                UserTable.Columns.EMAIL + " TEXT PRIMARY KEY, " +
                UserTable.Columns.PASS + " TEXT) "
        );

        /* Creates Restaurant Table */
        db.execSQL("CREATE TABLE " + RestaurantTable.NAME + " (" +
                RestaurantTable.Columns.REST + " TEXT PRIMARY KEY, " +
                RestaurantTable.Columns.LOGO + " TEXT) "
        );

        /* Creates Menu Table */
        db.execSQL("CREATE TABLE " + MenuTable.NAME + " (" +
                MenuTable.Columns.ITEM + " TEXT, " +
                MenuTable.Columns.REST + " TEXT, " +
                MenuTable.Columns.IMG + " TEXT, " +
                MenuTable.Columns.DESC + " TEXT, " +
                MenuTable.Columns.PRICE + " REAL, " +
                "PRIMARY KEY (" +
                        MenuTable.Columns.ITEM + ", " +
                        MenuTable.Columns.REST + "), " +
                "FOREIGN KEY (" + MenuTable.Columns.REST +
                        ") REFERENCES " + RestaurantTable.NAME +
                        " (" + RestaurantTable.Columns.REST +
                        ") ON DELETE CASCADE ON UPDATE NO ACTION )"
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
                        ") ON DELETE CASCADE ON UPDATE NO ACTION, " +
                "FOREIGN KEY (" + OrderHistoryTable.Columns.ITEM +
                        ") REFERENCES " + MenuTable.NAME +
                        " (" + MenuTable.Columns.ITEM +
                        ") ON DELETE CASCADE ON UPDATE NO ACTION )"
        );

    }
    
    /**
     * Upgrades database schema
     *
     * @param db (SQLiteDatabase) - The database object
     * @param i (int) - Old version number
     * @param i1 (int) - New version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

}
