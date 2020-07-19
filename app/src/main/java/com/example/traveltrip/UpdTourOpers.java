package com.example.traveltrip;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdTourOpers extends Activity implements OnClickListener {

    DBHelper dbHelper;
    SQLiteDatabase database;
    TextView textView;
    EditText edname, edEmaile, edPhone, edsite;
    Button btnUpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd_tour_opers);

        dbHelper = new DBHelper(this);

        textView = (TextView) findViewById(R.id.textView23);
        edname = (EditText) findViewById(R.id.sptouropers);
        edEmaile = (EditText) findViewById(R.id.edEmail);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edsite = (EditText) findViewById(R.id.edsite);

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");

        textView.setText(value);
    }

    @Override
    public void onClick(View view) {

    /*    SQLiteDatabase db = dbHelper.getWritableDatabase();
        ForDB cv = new ForDB();
        switch (view.getId()) {
            case R.id.btnUpd:
                // подготовим значения для обновления
                if(!edEmaile.equals(""))
                    cv.put("name", name);

                // обновляем по id
                int updCount = db.update("mytable", cv, "id = ?",
                        new String[] { id });
                break;
        }
        dbHelper.close();*/
    }
}