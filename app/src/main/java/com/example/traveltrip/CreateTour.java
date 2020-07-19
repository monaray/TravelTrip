package com.example.traveltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CreateTour extends AppCompatActivity implements View.OnClickListener {

    Button btnsave;
    EditText edname, edcountry, edcity, edstart, edfinish, edpeople, edstars, edprice;
    Spinner sptouropers;

    DBHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();

        ArrayList<ForDBSpinner> FromDB = new ArrayList<>();
        Cursor cursor = database.query(dbHelper.TABLE_TOUROPER,null,null, null, null, null,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_NAMEOFTOUROPER));

            ForDBSpinner fff = new ForDBSpinner(name);
            FromDB.add(fff);

        }
        cursor.close();

        sptouropers=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<ForDBSpinner> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, FromDB);
        sptouropers.setAdapter(adapter);

        btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(this);

        edname = (EditText) findViewById(R.id.edname);
        edcountry = (EditText) findViewById(R.id.edcountry);
        edcity = (EditText) findViewById(R.id.edcity);
        edstart = (EditText) findViewById(R.id.edStart);
        edfinish = (EditText) findViewById(R.id.edFinish);
        edpeople = (EditText) findViewById(R.id.edpeople);
        edstars = (EditText) findViewById(R.id.edstars);
        edprice = (EditText) findViewById(R.id.edprice);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        String value = sptouropers.getSelectedItem().toString();
        String name = edname.getText().toString();
        String country = edcountry.getText().toString();
        String city = edcity.getText().toString();
        String date = edstart.getText().toString();
        String days = edfinish.getText().toString();
        String people = edpeople.getText().toString();
        String stars = edstars.getText().toString();
        String price = edprice.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (view.getId()) {

            case R.id.btnsave:
                contentValues.put(DBHelper.KEY_NAMEOFTOURS, name);
                contentValues.put(DBHelper.KEY_NAMEOFTOUROPER, value);
                contentValues.put(DBHelper.KEY_COUNTRY, country);
                contentValues.put(DBHelper.KEY_CITY, city);
                contentValues.put(DBHelper.KEY_DATE, date);
                contentValues.put(DBHelper.KEY_DAYS, days);
                contentValues.put(DBHelper.KEY_PEOPLE, people);
                contentValues.put(DBHelper.KEY_STARS, stars);
                contentValues.put(DBHelper.KEY_PRICE, price);

                database.insert(DBHelper.TABLE_TOURS, null, contentValues);
                break;
        }
        dbHelper.close();
    }
}