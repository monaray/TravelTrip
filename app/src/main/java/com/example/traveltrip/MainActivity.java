package com.example.traveltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TourOpersSelect(View view) {
        switch (view.getId()) {
            case R.id.button4:
                Intent intent = new Intent (this, TourOpersSelect.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void CreateOrder(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, CreateOrder.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


   public void ToursSelect(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Intent intent = new Intent(this, ToursSelect.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
