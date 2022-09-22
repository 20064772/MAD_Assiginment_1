package com.example.mad_assignment_1;

import android.database.Cursor;
import android.database.CursorWrapper;
//TODO: Write this cursor
public class OrderHistoryCursor extends CursorWrapper {
    public OrderHistoryCursor(Cursor cursor) {
        super(cursor);
    }
}
