package com.example.android.habittrackerapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.data.HabitDbHelper;

/**
 * Created by Ramesh on 11/2/2016.
 */

public class HabitCrudHelper {
    private static HabitDbHelper mDbHelper;

    private HabitCrudHelper() {}

    public static void insert(Context context, ContentValues contentValues) {
        mDbHelper = new HabitDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, contentValues);
        Log.v(context+"HabitCrudHelper:insert", "New row ID=" + newRowId );
    }

    public static Cursor query(Context context, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        mDbHelper = new HabitDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
        return cursor;
    }
}

