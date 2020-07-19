package com.example.traveltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Tours extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ArrayList<ForDBTours> FromDB = new ArrayList<>();
        Cursor cursor = database.query(dbHelper.TABLE_TOURS,null,null, null, null, null,null);
        while (cursor.moveToNext()) {
            String nameoftours = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_NAMEOFTOURS));
            String nameoftouroper = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_NAMEOFTOUROPER));
            String country = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_COUNTRY));
            String city = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_CITY));
            String date = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_DATE));
            String days = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_DAYS));
            String people = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_PEOPLE));
            String stars = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_STARS));
            String price = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_PRICE));


            ForDBTours fff = new ForDBTours(nameoftours,nameoftouroper, country, city, date, days, people, stars, price);
            FromDB.add(fff);

        }
        cursor.close();

        lv=(ListView)findViewById(R.id.listView);
        ArrayAdapter<ForDBTours> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, FromDB);
        lv.setAdapter(adapter);
    }
}