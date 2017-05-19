package com.example.a126308.p05_ndpsongs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

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
                + COLUMN_TITLE + " TEXT," + COLUMN_SINGERS + " TEXT," + COLUMN_YEAR + " INTEGER," + COLUMN_STARS + " INTEGERS" + ")";
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

    public long insertSongTitle(String title, String singers, int year, int stars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_SINGERS, singers);
        values.put(COLUMN_STARS, stars);
        values.put(COLUMN_YEAR, year);
        long result = db.insert(TABLE_SONG, null, values);
        db.close();

        Log.d("SQL Insert" ," " + result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<String>  getAllSongTitle() {
        ArrayList<String> songs = new ArrayList<String>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_TITLE + " FROM " + TABLE_SONG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String content = cursor.getString(1);
                songs.add("ID:" + id + ", " + content);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }

    //To perform UPDATE
    public int updateSong(Song data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TITLE, data.getTitle());
        values.put(COLUMN_SINGERS, data.getSingers());
        values.put(COLUMN_YEAR, data.getYears());
        values.put(COLUMN_STARS, data.getStars());


        //Substituted by a String
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        //To check if a record is updated successfully.
        int result = db.update(TABLE_SONG, values, condition, args);
        db.close();
        return result;
    }

    //To perform DELETE
    public int deleteSong(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_SONG, condition, args);
        db.close();
        return result;
    }















}
