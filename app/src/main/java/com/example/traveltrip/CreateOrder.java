package com.example.traveltrip;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;

import java.util.ArrayList;


public class CreateOrder extends Activity implements OnClickListener {

    Button btnSend;
    EditText edFIO;
    Spinner sptours, sptouropers;
    DBHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();

        ArrayList<ForDBSpinner> FromDBTours = new ArrayList<>();
        Cursor cursor2 = database.query(dbHelper.TABLE_TOURS,null,null, null, null, null,null);
        while (cursor2.moveToNext()) {
            String name = cursor2.getString(cursor2.getColumnIndex(dbHelper.KEY_NAMEOFTOURS));

            ForDBSpinner fff = new ForDBSpinner(name);
            FromDBTours.add(fff);

        }
        cursor2.close();
        sptours=(Spinner)findViewById(R.id.sptours);
        ArrayAdapter<ForDBSpinner> adapter2=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, FromDBTours);
        sptours.setAdapter(adapter2);


        ArrayList<ForDBSpinner> FromDB = new ArrayList<>();
        Cursor cursor = database.query(dbHelper.TABLE_TOUROPER,null,null, null, null, null,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(dbHelper.KEY_NAMEOFTOUROPER));

            ForDBSpinner fff = new ForDBSpinner(name);
            FromDB.add(fff);

        }
        cursor.close();
        sptouropers = (Spinner) findViewById(R.id.sptouropers);
        ArrayAdapter<ForDBSpinner> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, FromDB);
        sptouropers.setAdapter(adapter);


        btnSend = (Button) findViewById(R.id.btnUpd);
        btnSend.setOnClickListener(this);
        edFIO = (EditText) findViewById(R.id.edFIO);
    }

    @Override
    public void onClick(View view) {

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        String edname = sptours.getSelectedItem().toString();
        String value = sptouropers.getSelectedItem().toString();

        String selection = "nameoftouroper = ?";
        String [] selectionArgs = new String[] { value };
        String [] colums = new String[] { "mail" };
        String edEmaile = "";
       Cursor c = database.query("TourOperators",colums, selection, selectionArgs, null, null,null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    for (String cn : c.getColumnNames()) {
                        edEmaile = c.getString(c.getColumnIndex(cn));
                    }

                } while (c.moveToNext());
            }
            c.close();
        }
        dbHelper.close();

        Intent emailSelectorIntent = new Intent(Intent.ACTION_SENDTO);
        emailSelectorIntent.setData(Uri.parse("mailto:"));

        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{edEmaile});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, edname);
        emailIntent.putExtra(Intent.EXTRA_TEXT,"ФИО Клиента: " + edFIO.getText().toString());
        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        emailIntent.setSelector( emailSelectorIntent );

       /* Uri attachment = FileProvider.getUriForFile(this, "my_fileprovider", myFile);
        emailIntent.putExtra(Intent.EXTRA_STREAM, attachment);*/

        if( emailIntent.resolveActivity(getPackageManager()) != null )
            startActivity(emailIntent);


    }

}