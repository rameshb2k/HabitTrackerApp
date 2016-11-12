package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.data.HabitDbHelper;
import com.example.android.habittrackerapp.data.HabitCrudHelper;


import java.text.DateFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertHabit();//Call to insert habit row into database
        readHabit();// Call to read the contents of the database
    }//onCreate

    //insert Habit
    public void insertHabit() {

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_DATE,System.currentTimeMillis() );
        values.put(HabitEntry.COLUMN_HABIT_DAY, "Mon");
        values.put(HabitEntry.COLUMN_HABIT_EXERCISE, 30);
        values.put(HabitEntry.COLUMN_HABIT_MUSIC, 15);
        values.put(HabitEntry.COLUMN_HABIT_STUDY, 4);
        values.put(HabitEntry.COLUMN_HABIT_TV, 30);
        values.put(HabitEntry.COLUMN_HABIT_SOCIAL, 60);
        values.put(HabitEntry.COLUMN_HABIT_VEG, 0);

        HabitCrudHelper.insert(this, values);
    }

    // read Habit
     public void readHabit() {

         String[] projection = {HabitEntry._ID,
                 HabitEntry.COLUMN_HABIT_DATE,
                 HabitEntry.COLUMN_HABIT_DAY,
                 HabitEntry.COLUMN_HABIT_EXERCISE,
                 HabitEntry.COLUMN_HABIT_MUSIC,
                 HabitEntry.COLUMN_HABIT_STUDY,
                 HabitEntry.COLUMN_HABIT_TV,
                 HabitEntry.COLUMN_HABIT_SOCIAL,
                 HabitEntry.COLUMN_HABIT_VEG};

         Cursor cursor = HabitCrudHelper.query(this, projection,null,null,null);//Single read method that returns a Cursor object.

         try {
             //get index of each column
             int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
             int dateColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DATE);
             int dayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DAY);
             int exerciseColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_EXERCISE);
             int musicColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_MUSIC);
             int studyColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_STUDY);
             int tvColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TV);
             int socialColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_SOCIAL);
             int vegColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_VEG);

             Log.v("readHabit: ",HabitEntry._ID + " - " +
                     HabitEntry.COLUMN_HABIT_DATE + " - " +
                     HabitEntry.COLUMN_HABIT_DAY + " - " +
                     HabitEntry.COLUMN_HABIT_EXERCISE + " - " +
                     HabitEntry.COLUMN_HABIT_MUSIC + " - " +
                     HabitEntry.COLUMN_HABIT_STUDY + " - " +
                     HabitEntry.COLUMN_HABIT_TV + " - " +
                     HabitEntry.COLUMN_HABIT_SOCIAL + " - " +
                     HabitEntry.COLUMN_HABIT_VEG + "\n");


             while (cursor.moveToNext()) {
                 int currentID = cursor.getInt(idColumnIndex);
                 long currentDate = cursor.getLong(dateColumnIndex);
                 String currentDay = cursor.getString(dayColumnIndex);
                 int currentExercise = cursor.getInt(exerciseColumnIndex);
                 int currentMusic = cursor.getInt(musicColumnIndex);
                 int currentStudy = cursor.getInt(studyColumnIndex);
                 int currentTv = cursor.getInt(tvColumnIndex);
                 int currentSocial = cursor.getInt(socialColumnIndex);
                 int currentVeg = cursor.getInt(vegColumnIndex);

                 String Date = DateFormat.getDateInstance().format(currentDate);

                 Log.v("readHabit: ","\n" + currentID + " - " +
                         Date + " - " +
                         currentDay + " - " +
                         currentExercise + " - " +
                         currentMusic + " - " +
                         currentStudy + " - " +
                         currentTv + " - " +
                         currentSocial + " - " +
                         currentVeg);
             }

         } finally {
             cursor.close();
         }

        }

}//MainActivity
