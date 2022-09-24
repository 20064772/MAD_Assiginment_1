package com.example.mad_assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mad_assignment_1.DBSchema.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Database Model Class - Facilitates database table manipulation
 *
 * @class           DBModel
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   22/09/2022
 */
public class DBModel
{
    private SQLiteDatabase db;

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DBModel(Context context)
    {
        this.db = new DBHelper(context.getApplicationContext()).getWritableDatabase();
    }

    /**
     * Adds a user with a given email and password which is SHA-512 hashed
     *
     * @param email     (String) Email address of user to be added
     * @param passwd    (String) Plain-text password of the user to be added
     * @throws IllegalArgumentException if the user already exists
     */
    public void addUser(String email, String passwd) throws IllegalArgumentException
    {
        /* TODO: Method call to check if the email exists goes HERE */

        ContentValues cv = new ContentValues();

        cv.put(UserTable.Columns.EMAIL, email);
        cv.put(UserTable.Columns.PASS, hashPasswd(passwd));

        db.insert(UserTable.NAME, null, cv);
    }

    public boolean findUser(String email, String passwd)
    {
        UserCursor cursor = new UserCursor(db.query(UserTable.NAME, null,
                UserTable.Columns.EMAIL + " = ? AND " + UserTable.Columns.PASS + " = ?",
                new String[]{email, hashPasswd(passwd)}, null, null, "1"));

        if(cursor.getCount() == 0) return false;
        else return true;
    }
    /**
     * Hashes a given password with SHA-512
     *
     * @param passwd    (String) The clear text password to be hashed
     * @return          (String) The hashed password
     */
    private String hashPasswd(String passwd) //throws NoSuchAlgorithmException
    {
        String hashedPasswd = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            hashedPasswd = new String(md.digest(passwd.getBytes(StandardCharsets.UTF_8)));
        }
        catch (NoSuchAlgorithmException e) {};
        return hashedPasswd;
    }
}
