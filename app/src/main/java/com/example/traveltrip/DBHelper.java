package com.example.traveltrip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TravelTrip";

    public static final String TABLE_TOUROPER = "TourOperators";
    public static final String KEY_IDOFTOUROPER = "_id";
    public static final String KEY_NAMEOFTOUROPER = "nameoftouroper";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_NUMBER = "number";
    public static final String KEY_SITE = "site";

    public static final String TABLE_TOURS = "Tours";
    public static final String KEY_IDOFTOURS = "_id";
    public static final String KEY_NAMEOFTOURS = "nameoftours";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_CITY = "city";
    public static final String KEY_DATE = "date";
    public static final String KEY_DAYS = "days";
    public static final String KEY_PEOPLE = "people";
    public static final String KEY_STARS = "stars";
    public static final String KEY_PRICE = "price";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TOUROPER + "(" + KEY_IDOFTOUROPER
        + " integer primary key," + KEY_NAMEOFTOUROPER + " text," + KEY_MAIL + " text," + KEY_NUMBER + " text," + KEY_SITE + " text" + ")");

        db.execSQL("create table " + TABLE_TOURS + "(" + KEY_IDOFTOURS
        + " integer primary key," + KEY_NAMEOFTOURS + " text," + KEY_NAMEOFTOUROPER + " text," + KEY_COUNTRY + " text," + KEY_CITY
        + " text," + KEY_DATE + " text," + KEY_DAYS + " text," + KEY_PEOPLE + " text," + KEY_STARS + " text," + KEY_PRICE + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_TOUROPER);
        db.execSQL("drop table if exists " + TABLE_TOURS);

        onCreate(db);

    }
}
