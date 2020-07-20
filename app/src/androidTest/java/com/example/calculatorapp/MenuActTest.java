package com.example.calculatorapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.view.Menu;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.anyIntent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
@MediumTest
public class MenuActTest {

    @Rule
    public ActivityTestRule<MenuAct>actActivityTestRule = new ActivityTestRule<>(MenuAct.class);
    public ActivityTestRule<MainActivity>activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    public IntentsTestRule<MenuAct>intentsTestRule = new IntentsTestRule<>(MenuAct.class);
    @Before
    public void setUp() throws Exception {
    }

    @Test
    //check that expected intent was sent without starting the activity
    public void checkHome(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(MainActivity.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.homeButton)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }
    @Test
    //check that expected intent was sent without starting the activity
    public void checkGoToCalc(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(CalculateAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.calcButton)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }
    @Test
    //check that expected intent was sent without starting the activity
    public void checkToAboutMe(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(AboutMeAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.aboutButton)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }
    @Test
    //check that expected intent was sent without starting the activity
    public void checkToProfile(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(ProfileAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.devProfileButton)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }
    
}