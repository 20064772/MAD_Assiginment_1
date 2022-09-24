package com.example.mad_assignment_1;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * User Cursor Class
 *
 * @class           UserCursor
 * @extends         android.database.CursorWrapper
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   24/09/2022 21:41
 */
public class UserCursor extends CursorWrapper {
    public UserCursor(Cursor cursor) {
        super(cursor);
    }
}
