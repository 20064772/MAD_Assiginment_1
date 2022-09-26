package com.example.mad_assignment_1;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.DBSchema.OrderHistoryTable;

/**
 * Menu Cursor Class
 *
 * @class           MenuCursor
 * @extends         android.database.CursorWrapper
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   25/09/2022 11:08
 */
//TODO: Figure this cursor out
public class OrderHistoryCursor extends CursorWrapper {
    public OrderHistoryCursor(Cursor cursor) {
        super(cursor);
    }

    public String getDishName()
    {
        return getString(getColumnIndex(OrderHistoryTable.Columns.ITEM));
    }

    public String getDateTime()
    {
        return getString(getColumnIndex(OrderHistoryTable.Columns.DATETIME));
    }

    public int getQty()
    {
        return getInt(getColumnIndex(OrderHistoryTable.Columns.QTY));
    }
}
