package com.example.heshammostafa.login.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.heshammostafa.login.Model.usernameAndPassword;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeshamMostafa on 8/9/2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Matchdatabase";
    private static final String TABLE_MATHC="match";
    private static final String MATCH_ID="id";
    private static final String USERNAME="username";
    private static final String PASSWORD="password";
    private static final String SQL_CREATE_MATCH =
                   "CREATE TABLE " +
                    TABLE_MATHC+ " (" +
                    MATCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USERNAME + " TEXT, "+
                    PASSWORD+" TEXT); ";
    private static final String[] MATCH_VALUE_FIELDS ={USERNAME,PASSWORD};

    private static final String TAG = "Guinness/Database";

    public Database(Context context) {
        super(context,DATABASE_NAME,null ,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MATCH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_MATHC);
        onCreate(db);
    }
    // Adding new contact
    public void addContact(usernameAndPassword data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(USERNAME,data.get_username());
        values.put(PASSWORD,data.get_password());
        db.insert(TABLE_MATHC,null,values);
        db.close();
    }

    // Getting single contact
    public usernameAndPassword getContact(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(
                TABLE_MATHC,
                new String[]{MATCH_ID,USERNAME,PASSWORD},
                MATCH_ID+"=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }

        usernameAndPassword data=
                new usernameAndPassword(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2));
        return data;
    }
//
//     Getting All Contacts
    public List<usernameAndPassword> getAllContacts()
    {
        List<usernameAndPassword> DataList = new ArrayList<usernameAndPassword>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_MATHC;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                usernameAndPassword contact = new usernameAndPassword();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_username(cursor.getString(1));
                contact.set_password(cursor.getString(2));
                // Adding contact to list
                DataList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return DataList;
    }

//     Getting contacts Count
    public int getContactsCount()
    {
        String countQuery = "SELECT  * FROM " + TABLE_MATHC;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
//     Updating single data
    public int updateContact(usernameAndPassword data)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERNAME, data.get_username());
        values.put(PASSWORD, data.get_password());

        // updating row
        return db.update(TABLE_MATHC, values, MATCH_ID + " = ?",
                new String[] { String.valueOf(data.get_id()) });
    }
//
//     Deleting single data
    public void deleteContact(usernameAndPassword data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MATHC, MATCH_ID + " = ?",
                new String[] { String.valueOf(data.get_id()) });
        db.close();
    }
}
