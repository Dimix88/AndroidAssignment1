package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateAct extends AppCompatActivity {
    EditText b1;
    EditText b2;
    EditText h;
    int bs1;
    int bs2;
    int hgt;
    double area;
    TextView ans;
    Button calcBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        b1 = findViewById(R.id.base1);
        b2 = findViewById(R.id.base2);
        h = findViewById(R. id.height);
        ans = findViewById(R.id.answer);
        calcBack = findViewById(R.id.calcBack);

    }

    public void backToMenu(View v){
        Intent backMenu = new Intent(CalculateAct.this,MenuAct.class);
        startActivity(backMenu);
    }
    public void calcAnswer(View v){
        bs1 = Integer.parseInt(b1.getText().toString());
        bs2 = Integer.parseInt(b2.getText().toString());
        hgt = Integer.parseInt(h.getText().toString());

        area = ((bs1+bs2)/2)*hgt;
        ans.setText(String.valueOf(area));
        ans.setBackgroundColor(Color.GREEN);
    }

}
