package com.example.calculatorapp;

import android.app.Instrumentation;
import android.widget.TextView;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
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
public class CalculateActTest {
    String eBase1;
    String eBase2;
    String eHeight;
    double answer;


    @Rule
    public ActivityTestRule<CalculateAct>calculateActActivityTestRule = new ActivityTestRule<>(CalculateAct.class);
    public IntentsTestRule<CalculateAct>calculateActIntentsTestRule = new IntentsTestRule<>(CalculateAct.class);

    @Before
    public void setUp() throws Exception {
        eBase1 = "20";
        eBase2 = "40";
        eHeight = "30";

    }

    @Test
    public void trapazoid(){
        //fill the 3 editText views
        onView(withId(R.id.base1))
                .perform(typeText(eBase1), closeSoftKeyboard());
        onView(withId(R.id.base2))
                .perform(typeText(eBase2), closeSoftKeyboard());
        onView(withId(R.id.height))
                .perform(typeText(eHeight), closeSoftKeyboard());
        //click the calculate button
        onView(withId(R.id.calculate)).perform(click());
        //formula to calculate the area of a Trapezoid
        answer = ((20+40)/2)*30;
        //check if the value in the answer is correct
        onView(withId(R.id.answer)).check(matches(withText(String.valueOf(answer))));
    }

    @Test
    //check that expected intent was sent without starting the activity
    public void backToMenuCalc(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(MenuAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.calcBack)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }

    @After
    public void tearDown() throws Exception {
    }
}