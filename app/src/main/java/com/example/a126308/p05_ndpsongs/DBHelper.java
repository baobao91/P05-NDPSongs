package com.example.a126308.p05_ndpsongs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by 126308 on 19/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "songs.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGERS = "singers";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_STARS = "stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT," + COLUMN_SINGERS + "TEXT," + COLUMN_YEAR + "INTEGER," + COLUMN_STARS + "INTEGERS" + ")";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");


        for (int i = 0; i< 4; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_YEAR, + i);
            values.put(COLUMN_TITLE, + i);
            values.put(COLUMN_SINGERS, + i);
            db.insert(TABLE_SONG, null, values);
        }
        Log.i("info", "dummy records inserted");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        onCreate(db);

    }

    public long insertSongTitle(String title, String singers, int year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_SINGERS, singers);
//        values.put(COLUMN_STARS, stars);
        values.put(COLUMN_YEAR, year);
        long result = db.insert(TABLE_SONG, null, values);
        db.close();

        Log.d("SQL Insert" ," " + result); //id returned, shouldn’t be -1
        return result;
    }





}