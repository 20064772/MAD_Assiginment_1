package com.example.mad_assignment_1;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.DBSchema.MenuTable;

/**
 * Menu Cursor Class
 *
 * @class           MenuCursor
 * @extends         android.database.CursorWrapper
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   24/09/2022 22:40
 */
public class MenuCursor extends CursorWrapper {
    public MenuCursor(Cursor cursor) {
        super(cursor);
    }
    
    public Dish getDish()
    {
        return new Dish(
                getInt(getColumnIndex(MenuTable.Columns.IMG)),
                getString(getColumnIndex(MenuTable.Columns.ITEM)),
                getString(getColumnIndex(MenuTable.Columns.DESC)),
                getDouble(getColumnIndex(MenuTable.Columns.PRICE))
        );
    }

    public String getRestaurant()
    {
        return getString(getColumnIndex(MenuTable.Columns.REST));
    }
}
