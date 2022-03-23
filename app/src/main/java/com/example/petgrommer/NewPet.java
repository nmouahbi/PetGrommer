package com.example.petgrommer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class NewPet extends AppCompatActivity {
    EditText petName, petWeight, petBreed, specInstr;
    Button button, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pet);

        petName = findViewById(R.id.petName);
        petWeight = findViewById(R.id.petWeight);
        petBreed = findViewById(R.id.petBreed);
        specInstr = findViewById(R.id.specInstr);
        button = findViewById(R.id.button);
        view = findViewById(R.id.view);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject petObj = new JSONObject();
                String getPetName = petName.getText().toString();
                String getPetWeight = petWeight.getText().toString();
                String getPetBreed = petBreed.getText().toString();
                String getSpecInstr = specInstr.getText().toString();
                if (getPetName.equals("") || getPetWeight.equals("") || getPetBreed.equals("") || getSpecInstr.equals("")){
                    Toast.makeText(getApplicationContext(), "All field are required!!", Toast.LENGTH_LONG).show();
                }else{
                    try {
                        petObj.put("name", getPetName);
                        petObj.put("weight", getPetWeight);
                        petObj.put("breed", getPetBreed);
                        petObj.put("instructions", getSpecInstr);

                        String dataString = petObj.toString();

                        SharedPreferences.Editor sharedPreferences = getSharedPreferences("petData", MODE_PRIVATE).edit();
                        sharedPreferences.putString("petData", dataString);
                        sharedPreferences.apply();

                        Toast.makeText(getApplicationContext(), "Data saved successfully!!", Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("petData", MODE_PRIVATE);
                String data = sharedPreferences.getString("petData", "");
                if (!data.equals("")){
                    Intent viewData = new Intent(NewPet.this,ViewData.class);
                    startActivity(viewData);

                }else{
                    Toast.makeText(getApplicationContext(), "No data found!!. Save data first", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}