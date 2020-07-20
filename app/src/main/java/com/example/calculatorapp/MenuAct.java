package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuAct extends AppCompatActivity {
    TextView greeting;
    Button home;
    Button calc;
    Button about;
    Button profile;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        greeting = findViewById(R.id.greeting);
        home = findViewById(R.id.homeButton);
        calc = findViewById(R.id.calcButton);
        about= findViewById(R.id.aboutButton);
        profile = findViewById(R.id.devProfileButton);
        name = getIntent().getStringExtra("NameToMenu");
        greeting.setText("Dear "+name+"\nWelcome to my code space");
    }

    public void homer(View v){
        Intent home = new Intent(MenuAct.this,MainActivity.class);
        startActivity(home);
    }

    public void goToCalc(View v){
        Intent toCalc = new Intent(MenuAct.this,CalculateAct.class);
        startActivity(toCalc);
    }

    public void toAboutMe(View v){
        Intent toAbout = new Intent(MenuAct.this, AboutMeAct.class);
        startActivity(toAbout);
    }

    public void toProfile(View v){
        Intent toDevProfile = new Intent(MenuAct.this, ProfileAct.class);
        startActivity(toDevProfile);
    }

    
}
