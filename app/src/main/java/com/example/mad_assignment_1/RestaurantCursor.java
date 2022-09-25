package com.example.mad_assignment_1;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.DBSchema.RestaurantTable;
/**
 * Menu Cursor Class
 *
 * @class           RestaurantCursor
 * @extends         android.database.CursorWrapper
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   25/09/2022 10:57
 */public class RestaurantCursor extends CursorWrapper {
    public RestaurantCursor(Cursor cursor) {
        super(cursor);
    }
    
    public Restaurant getRestaurant(Menu menu)
    {
        return new Restaurant(
                getString(getColumnIndex(RestaurantTable.Columns.REST)),
                getInt(getColumnIndex(RestaurantTable.Columns.LOGO)),
                menu);
    }
}
