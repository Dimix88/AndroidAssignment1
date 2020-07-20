package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutMeAct extends AppCompatActivity {
    Button backFromAbout;
    TextView scroller;
    TextView profile;
    ImageView me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        backFromAbout = findViewById(R.id.aboutBack);
        profile = findViewById(R.id.myPro);
        me = findViewById(R.id.dimix);

        scroller = findViewById(R.id.myInfo);
        scroller.setSelected(true);
        scroller.setMovementMethod(new ScrollingMovementMethod());
        String info = "My name is Dimitri Ferus\nI like coding\nI have skills such as:\nJava Development\nReading\nAcademic Writing" +
                "\nSeamanship\nI am a fun loving, outgoing person.\n\n" +
                "Hobbies:\nPool,Car Audio, Automobile repairs";
        scroller.setText(info);
        // I wanted to put the text and picture in one textview using a imagespan but still need to research and practice more
        /*
        SpannableStringBuilder ssb = new SpannableStringBuilder(info);
        ssb.setSpan(new ImageSpan(this,R.drawable.mypic2),0,1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        scroller.setText(ssb,TextView.BufferType.SPANNABLE);
        Drawable dr = getResources().getDrawable(R.drawable.mypic);
        Bitmap bitmap = ((BitmapDrawable)dr).getBitmap();
        Drawable img = new BitmapDrawable(getResources(),Bitmap.createScaledBitmap(bitmap,50, 50, true));
        scroller.setCompoundDrawablesWithIntrinsicBounds(0,0,img,0);

         */
    }
    public void backToMenu(View v){
        Intent backMenu = new Intent(AboutMeAct.this,MenuAct.class);
        startActivity(backMenu);
    }
}
