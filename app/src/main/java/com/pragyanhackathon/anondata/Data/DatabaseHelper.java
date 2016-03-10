package com.pragyanhackathon.anondata.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by microsoft on 12-Dec-15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //Database name and version
    public static final String DB_NAME = "HealthData";
    public static final int DB_VERSION = 1;
    //Database user table
    public static final String createTable = "create table MedicalData(age integer not null,test varchar not null,value float not null,area varchar not null);";
    /**
     * DatabaseHelper Constructor
     * @param context
     */
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    /**
     * Creates Database Table
     */
    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(createTable);
    }
    /**
     * Handles table version and drop of a table
     * @param database
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(DatabaseHelper.class.getName(),"Upgrading database from version "+ oldVersion + " to " + newVersion + ", which will destroy all data");
        database.execSQL("DROP TABLE IF EXISTS MedicalData");
        onCreate(database);
    }
}
