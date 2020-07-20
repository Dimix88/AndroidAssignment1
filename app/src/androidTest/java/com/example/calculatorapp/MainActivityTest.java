package com.example.calculatorapp;

import android.app.Instrumentation;

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
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityTest {

    String textSend;
    @Rule
    public ActivityTestRule<MainActivity>activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    public IntentsTestRule<MainActivity>intentsTestRule = new IntentsTestRule<>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        textSend =  "Dimitri";
    }
    @Test
    public void sendMessage(){
        //type the text to be sent
        onView(withId(R.id.userInput))
                .perform(typeText(textSend), closeSoftKeyboard());
        //press the next button
        onView(withId(R.id.nextMain)).perform(click());

        Assert.assertNotNull(MenuAct.class);
    }
    @Test
    //check that expected intent was sent without starting the activity
    public void checkIntent(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(MenuAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.nextMain)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }
}