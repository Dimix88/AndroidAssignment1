package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileAct extends AppCompatActivity {
    Button back;
    TextView detailer;
    TextView name;
    TextView email;
    TextView number;
    ImageView myStudent;
    ImageView myEmail;
    ImageView myNumber;
    ImageView myLink;
    ImageView twit;

    String whatsApp = "+27826198495";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = findViewById(R.id.back);
        detailer = findViewById(R.id.details);
        name = findViewById(R.id.myName);
        email = findViewById(R.id.myEmail);
        number = findViewById(R.id.myNumber);

        myStudent = findViewById(R.id.student);
        myEmail = findViewById(R.id.email);
        myNumber = findViewById(R.id.cellphone);
        myLink = findViewById(R.id.linkedIn);
        twit = findViewById(R.id.twitter);

    }

    public void backToMenu(View v){
        Intent backMenu = new Intent(ProfileAct.this,MenuAct.class);
        startActivity(backMenu);
    }
// I dont have a twitter profile
    public void toTwitter(View v){
        Intent twitterIcon = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com"));
        startActivity(twitterIcon);
    }
    public void toLinkedIn(View v){
        Intent toLinked = new Intent(Intent.ACTION_VIEW,Uri.parse("https://linkedin.com/in/dimitri-ferus-6b5720146"));
        startActivity(toLinked);
    }
    //When clicking the whatsapp image Whatsapp is opened
    public void toWhatsApp(View v){
        String url = "https://api.whatsapp.com/send?phone="+whatsApp;
        Intent wApp = new Intent(Intent.ACTION_VIEW);
        wApp.setData(Uri.parse(url));
        startActivity(wApp);
    }
    //When clicking the email image you are redirected to the composing an email menu
    public void toGmail(View v){
        try {
            Intent emailer = new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+"dimitriruzandra1@gmail.com"));
            startActivity(emailer);
        }
        catch (ActivityNotFoundException e){

        }
    }

}
