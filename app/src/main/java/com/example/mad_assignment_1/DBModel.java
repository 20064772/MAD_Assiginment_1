package com.example.mad_assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mad_assignment_1.DBSchema.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Database Model Class - Facilitates database table manipulation
 *
 * @class           DBModel
 * @author          Tristan S. Tutungis
 * @date_created    22/09/2022
 * @last_modified   24/09/2022 22:02
 */
public class DBModel
{
    private SQLiteDatabase db; //The database
    
    /**
     * Creates a new object containing a writeable database
     *
     * @param context   (Context)
     */
     
     
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
        
        if(!findUser(email, passwd))
        {
            ContentValues cv = new ContentValues();
    
            cv.put(UserTable.Columns.EMAIL, email);
            cv.put(UserTable.Columns.PASS, hashPasswd(passwd));
    
            db.insert(UserTable.NAME, null, cv);
        } else throw new IllegalArgumentException("User already exists");
    }
    
    /**
     * Finds whether a user with a given email exists
     *
     * @param email     (String) Email address of user to be added
     * @param passwd    (String) Plain-text password of the user to be added
     * @return          (boolean) true if the user exists, false otherwise
     */
    public boolean findUser(String email, String passwd)
    {
        boolean userExists;
        UserCursor cursor = new UserCursor(db.query(UserTable.NAME, null,
                UserTable.Columns.EMAIL + " = ? AND " + UserTable.Columns.PASS + " = ?",
                new String[]{email, hashPasswd(passwd)}, null, null, "1"));
        
        try
        {
            if (cursor.getCount() == 0) userExists = false;
            else userExists = true;
        }
        finally { cursor.close(); }
        
        return userExists;
    }
    
    public List<Restaurant> getRestaurants()
    {
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();
        
        
    }
    
    /**
     * Hashes a given password with SHA-512
     *
     * @param passwd    (String) The clear text password to be hashed
     * @return          (String) The hashed password
     */
    private String hashPasswd(String passwd)
    {
        String hashedPasswd = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            hashedPasswd = new String(md.digest(passwd.getBytes(StandardCharsets.UTF_8)));
        }
        catch (NoSuchAlgorithmException e) {}
        return hashedPasswd;
    }
}
