package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;


/**
 * Created by Ramesh on 11/2/2016.
 */

public final class HabitContract {

    //Empty constructor to prevent accidental instantiation of the contract class
    private HabitContract() {}

    //Inner class that defines the tables contents
    public static abstract class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        //public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_DATE = "date";//Date
        public static final String COLUMN_HABIT_DAY = "day";//Day of the week
        public static final String COLUMN_HABIT_EXERCISE = "exercise";
        public static final String COLUMN_HABIT_MUSIC = "music";
        public static final String COLUMN_HABIT_STUDY = "study";
        public static final String COLUMN_HABIT_TV = "tv";//Time Spent watchig TV
        public static final String COLUMN_HABIT_SOCIAL = "social";//Time Spent on Social Media
        public static final String COLUMN_HABIT_VEG = "veg";//Ate Vegetables or not

    //Define create table SQLite cmd
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +
                HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HabitEntry.COLUMN_HABIT_DATE + " LONG NOT NULL , " +
                HabitEntry.COLUMN_HABIT_DAY + " TEXT NOT NULL , " +
                HabitEntry.COLUMN_HABIT_EXERCISE + " INTEGER NOT NULL DEFAULT 0, " +
                HabitEntry.COLUMN_HABIT_MUSIC + " INTEGER, " +
                HabitEntry.COLUMN_HABIT_STUDY + " INTEGER NOT NULL DEFAULT 0, " +
                HabitEntry.COLUMN_HABIT_TV + " INTEGER, " +
                HabitEntry.COLUMN_HABIT_SOCIAL + " INTEGER, " +
                HabitEntry.COLUMN_HABIT_VEG + " INTEGER NOT NULL " + ");";

     //Define delete table SQLite cmd
        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME + ";";

    }
}
