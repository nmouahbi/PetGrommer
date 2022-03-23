package com.example.petgrommer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences myPreferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        String display = myPreferences.getString("display", "");


        TextView displayProfile = (TextView)  findViewById(R.id.profilePage);
        displayProfile.setText("Welcome,"+display);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Profile.this, NewPet.class);
            startActivity(intent);
        });
    }
}