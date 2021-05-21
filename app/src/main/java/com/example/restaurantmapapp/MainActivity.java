package com.example.restaurantmapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.restaurantmapapp.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    Button addPlaceButton, showAllButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addPlaceButton = findViewById(R.id.addPlaceButton);
        showAllButton = findViewById(R.id.showAllButton);

        db = new DatabaseHelper(this);
    }

    public void addPlaceButtonClick(View view)
    {
        Intent addPlaceIntent = new Intent(this, AddRestaurantActivity.class);
        startActivity(addPlaceIntent);
    }

    public void showAllButtonClick(View view)
    {
        if (db.checkData())
        {
            Intent showAllIntent = new Intent(this, RestaurantMapsActivity.class);
            startActivity(showAllIntent);
        }

        else
        {
            Toast.makeText(this, "Please add a location", Toast.LENGTH_SHORT).show();
        }
    }
}