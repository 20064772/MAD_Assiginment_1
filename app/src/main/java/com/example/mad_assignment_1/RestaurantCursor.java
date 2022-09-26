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
 */
public class RestaurantCursor extends CursorWrapper {
    public RestaurantCursor(Cursor cursor) {
        super(cursor);
    }
    
    public String getName()
    {
        return getString(getColumnIndex(RestaurantTable.Columns.REST));
    }

    public int getDrawable()
    {
        return getInt(getColumnIndex(RestaurantTable.Columns.LOGO));
    }
}
