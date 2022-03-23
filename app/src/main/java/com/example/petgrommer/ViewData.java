package com.example.petgrommer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ViewData extends AppCompatActivity {
    TextView name, weight, breed, instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        name = findViewById(R.id.name);
        weight = findViewById(R.id.weight);
        breed = findViewById(R.id.breed);
        instructions = findViewById(R.id.instructions);

        SharedPreferences sharedPreferences = getSharedPreferences("petData", MODE_PRIVATE);
        String data = sharedPreferences.getString("petData", "");

        try {
            JSONObject jsonObject = new JSONObject(data);
            name.setText(jsonObject.getString("name"));
            weight.setText(jsonObject.getString("weight"));
            breed.setText(jsonObject.getString("breed"));
            instructions.setText(jsonObject.getString("instructions"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Button logoutButton = (Button) findViewById(R.id.logout);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(ViewData.this, MainActivity.class);
                startActivity(logout);
            }
        });

        Button addNewPet = (Button) findViewById(R.id.newpet);

        addNewPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(ViewData.this, NewPet.class);
                startActivity(logout);
            }
        });
    }
}