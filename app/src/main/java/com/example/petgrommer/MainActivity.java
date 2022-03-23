package com.example.petgrommer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText)  findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.passoword);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button regButton = (Button) findViewById(R.id.registerButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences myPreferences = getSharedPreferences("MYPREF",MODE_PRIVATE);

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();

                    Intent main = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(main);
                }else {

                    String userDetails = myPreferences.getString(user + pass + "data", "\n \nSorry!!\nInformarion Entered are incorrect");
                    SharedPreferences.Editor editor = myPreferences.edit();
                    editor.putString("display", userDetails);
                    editor.commit();

                    Intent loginPge = new Intent(MainActivity.this, Profile.class);
                    startActivity(loginPge);




                }
            }
        });


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerPage = new Intent(MainActivity.this,Registration.class);
                startActivity(registerPage);
            }
        });

    }
}