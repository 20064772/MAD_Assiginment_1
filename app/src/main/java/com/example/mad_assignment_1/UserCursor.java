package com.example.mad_assignment_1;

import android.database.Cursor;
import android.database.CursorWrapper;

public class UserCursor extends CursorWrapper {
    public UserCursor(Cursor cursor) {
        super(cursor);
    }
}
