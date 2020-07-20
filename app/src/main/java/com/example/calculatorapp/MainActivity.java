package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView studentName;
    TextView visitor;
    EditText userName;
    Button nextBtn;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentName = findViewById(R.id.studentName);
        visitor = findViewById(R.id.visitor);
        userName = findViewById(R.id.userInput);
        nextBtn = findViewById(R.id.nextMain);

        /*nextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenu = new Intent(MainActivity.this,MenuAct.class);
                name = userName.getText().toString();
                toMenu.putExtra("NameToMenu",name);
                startActivity(toMenu);
            }
        }));
        */
    }
    public void textPersonName(View v){

        Intent toMenu = new Intent(MainActivity.this,MenuAct.class);
        name = userName.getText().toString();
        toMenu.putExtra("NameToMenu",name);
        startActivity(toMenu);
    }
}
