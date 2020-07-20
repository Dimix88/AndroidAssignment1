package com.example.calculatorapp;

import android.app.Instrumentation;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.anyIntent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class AboutMeActTest {

    String text;
    @Rule
    public ActivityTestRule<AboutMeAct>actActivityTestRule = new ActivityTestRule<>(AboutMeAct.class);
    public IntentsTestRule<AboutMeAct>intentsTestRule = new IntentsTestRule<>(AboutMeAct.class);


    @Before
    public void setUp() throws Exception {
        text = "My name is Dimitri Ferus\nI like coding\n I have skills such as:\nJava Development\nReading\nAcademic Writing" +
                "\nSeamanship\nI am a fun loving, outgoing person.\n" +
                "Hobbies:\nPool,Car Audio, Automobile repairs";
    }

    //validate the text on screen and scroll down through the textview
    @Test
    public void scrollTester(){
        onView(withText(text))                         //check for the word repairs
                .perform(ViewActions.swipeUp())            //scroll down
                .check(ViewAssertions.matches(isDisplayed()));
    }


    @Test
    //check that expected intent was sent without starting the activity
    public void goBackToMenu(){

        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(MenuAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.aboutBack)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }
}