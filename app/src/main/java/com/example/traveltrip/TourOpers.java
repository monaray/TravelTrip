package com.example.traveltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class TourOpers extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_opers);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ArrayList<ForDB> FromDB = new ArrayList<>();
        Cursor cursor = database.query(dbHelper.TABLE_TOUROPER,null,null, null, null, null,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_NAMEOFTOUROPER));
            String mail = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_MAIL));
            String number = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_NUMBER));
            String site = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_SITE));

            ForDB fff = new ForDB(name, mail, number, site);
            FromDB.add(fff);

        }
        cursor.close();

        lv=(ListView)findViewById(R.id.listView);
        ArrayAdapter<ForDB> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, FromDB);
        lv.setAdapter(adapter);
    }
}