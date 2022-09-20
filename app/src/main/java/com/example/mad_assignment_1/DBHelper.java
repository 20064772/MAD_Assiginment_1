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
 * @last_modified   15/09/2022 22:21
 */
public class DBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DB_NAME = "Food.db";

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DBHelper(Context context)
    {
        super(context, DB_NAME, VERSION, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + UserTable.NAME + " (" +
                UserTable.Columns.EMAIL + " TEXT PRIMARY KEY, " +
                UserTable.Columns.PASS + " TEXT) ");

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
                        ") ON DELETE CASCADE ON UPDATE NO ACTION )" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
