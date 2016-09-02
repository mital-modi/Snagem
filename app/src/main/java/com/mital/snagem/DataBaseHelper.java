package com.mital.snagem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Snagem.db";
    private static final String TABLE_NAME = "users";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "password";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_SCHOOL = "school";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_TAGS = "tags";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
        + TABLE_NAME + "(" +
            COLUMN_ID + " integer primary key not null, " +
            COLUMN_NAME + " text not null, " +
            COLUMN_GENDER + " text not null, " +
            COLUMN_EMAIL + " text not null, " +
            COLUMN_PASS + " text not null, " +
            COLUMN_CLASS + " text not null, " +
            COLUMN_SCHOOL + " text not null, " +
            COLUMN_TAGS + " text" + ")";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertUser(User user) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from users";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_GENDER, user.getGender());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASS, user.getPassword());
        values.put(COLUMN_CLASS, user.getClassification());
        values.put(COLUMN_SCHOOL, user.getSchool());
        db.insert(TABLE_NAME, null, values);


    }

    public String searchPass(String email) {
        db = this.getReadableDatabase();
        String query = "select email, password from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String temp_email, temp_pass;
        temp_pass = "not found";

        if(cursor.moveToFirst()){
            do{
                temp_email = cursor.getString(0);
                if(temp_email.equals(email)){
                    temp_pass = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return temp_pass;
    }
}