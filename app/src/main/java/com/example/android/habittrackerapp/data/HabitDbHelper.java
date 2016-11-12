package com.example.android.habittrackerapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import static com.example.android.habittrackerapp.data.HabitContract.HabitEntry.SQL_CREATE_ENTRIES;
import static com.example.android.habittrackerapp.data.HabitContract.HabitEntry.SQL_DELETE_ENTRIES;

/**
 * Created by Ramesh on 11/2/2016.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    //database name and version
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "habit.db";

    //Constructor
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //When the database if first created
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    //upgrade database schema: delete table entries and recreate the database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}