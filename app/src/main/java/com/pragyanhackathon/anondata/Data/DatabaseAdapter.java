package com.pragyanhackathon.anondata.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by microsoft on 12-Dec-15.
 */
public class DatabaseAdapter {
    public static final String table = "MedicalData";
    public static final String COL_AGE = "age";
    public static final String COL_TEST = "test";
    public static final String COL_VALUE = "value";
    public static final String COL_AREA = "area";

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    /**
     * The Adapter Constructor
     * @param context
     */
    public DatabaseAdapter(Context context){
        this.context = context;
    }
    /**
     * Creates the database helper and throws the exception
     *
     * @return
     * @throws android.database.SQLException
     */
    public DatabaseAdapter open() throws SQLException{
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    /**
     * Closes the database
     */
    public void close() {
        dbHelper.close();
    }
    /**
     * Stores the data in the table
     * @param age
     * @param test
     * @param value
     * @param area
     * @return
     */
    public long insertData(String age, String test,String value,String area){
        ContentValues initialValues = createMedicalDataTableContentValues(age,test,value,area);
        return database.insert(table,null,initialValues);
    }
    /**
     * Creates content values to be stored in the table
     * @param age
     * @param test
     * @param value
     * @param area
     */
    public ContentValues createMedicalDataTableContentValues(String age,String test,String value, String area){
        ContentValues values = new ContentValues();
        values.put(COL_AGE,age);
        values.put(COL_TEST,test);
        values.put(COL_VALUE,value);
        values.put(COL_AREA,area);
        return values;
    }
    public Cursor getData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery("select * from MedicalData",null);
        Log.d("Found", String.valueOf(res.getCount()));
        return res;
    }
}
