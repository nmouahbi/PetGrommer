package com.example.petgrommer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        EditText userName = (EditText) findViewById(R.id.regUserName);
        EditText password = (EditText) findViewById(R.id.regPassword);
        EditText email = (EditText) findViewById(R.id.regEmail);
        Button registerButton = (Button) findViewById(R.id.buttonNewReg);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPreferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String newUserName = userName.getText() .toString();
                String newPassword = password.getText() .toString();
                String newEmail = email.getText() .toString();

                SharedPreferences.Editor editor = myPreferences.edit();


                if (TextUtils.isEmpty(newUserName) || TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(newEmail)) {

                    Toast.makeText(Registration.this, "Missing Information!! Try again", Toast.LENGTH_SHORT).show();

                } else {
                    editor.putString(newUserName + newPassword + "data", newUserName + "\n");
                    editor.commit();

                    Intent loginScreen = new Intent(Registration.this, MainActivity.class);
                    startActivity(loginScreen);
                }
            }
        });
    }
}