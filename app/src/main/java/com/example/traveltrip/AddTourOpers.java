package com.example.traveltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTourOpers extends AppCompatActivity implements View.OnClickListener {

    Button btnsave;
    EditText edname, edEmail, edPhone, edsite;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tour_opers);

        btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(this);

        edname = (EditText) findViewById(R.id.sptouropers);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edsite = (EditText) findViewById(R.id.edsite);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        String name = edname.getText().toString();
        String email = edEmail.getText().toString();
        String phone = edPhone.getText().toString();
        String site = edsite.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (view.getId()) {

            case R.id.btnsave:
                contentValues.put(DBHelper.KEY_NAMEOFTOUROPER, name);
                contentValues.put(DBHelper.KEY_MAIL, email);
                contentValues.put(DBHelper.KEY_NUMBER, phone);
                contentValues.put(DBHelper.KEY_SITE, site);

                database.insert(DBHelper.TABLE_TOUROPER, null, contentValues);
                break;
        }
        dbHelper.close();
    }
}