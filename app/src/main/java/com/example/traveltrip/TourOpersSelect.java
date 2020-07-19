package com.example.traveltrip;

import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class TourOpersSelect extends Activity implements OnClickListener {

    Spinner sp;
    DBHelper dbHelper;
    SQLiteDatabase database;
    Button btnDel, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_opers_select);

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

        sp=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<ForDBSpinner> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, FromDB);
        sp.setAdapter(adapter);


        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

    }


   @Override
    public void onClick(View view) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String value = sp.getSelectedItem().toString();
        switch (view.getId()) {
            case R.id.btnDel:
                int delCount = db.delete("TourOperators","nameoftouroper = '" + value + "'", null);
                break;
            case R.id.btnClear:
                int clearCount = db.delete("TourOperators", null, null);
                break;
            case R.id.btnRead:
                Intent intent = new Intent(this, TourOpers.class);
                startActivity(intent);
                break;
            case R.id.btnAdd:
                Intent intent2 = new Intent(this, AddTourOpers.class);
                startActivity(intent2);
                break;
        }
        dbHelper.close();
    }

    public void TourOpers(View view) {
        switch (view.getId()) {
            case R.id.btnRead:
                Intent intent = new Intent(this, TourOpers.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void AddTourOpers(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                Intent intent = new Intent(this, AddTourOpers.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}