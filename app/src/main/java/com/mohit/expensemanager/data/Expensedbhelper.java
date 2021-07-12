package com.mohit.expensemanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Expensedbhelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = Expensedbhelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "shelter.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link Expensedbhelper}.
     *
     * @param context of the app
     */
    public Expensedbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
            String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + ExpenseContract.ExpenseEntry.TABLE_NAME + " ("
                + ExpenseContract.ExpenseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ExpenseContract.ExpenseEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + ExpenseContract.ExpenseEntry.COLUMN_PET_BREED + " TEXT, "
                + ExpenseContract.ExpenseEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + ExpenseContract.ExpenseEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}

