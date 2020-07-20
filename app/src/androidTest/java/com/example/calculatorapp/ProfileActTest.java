package com.example.calculatorapp;

import android.app.Instrumentation;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
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
public class ProfileActTest {

    @Rule
    public ActivityTestRule<ProfileAct>actActivityTestRule = new ActivityTestRule<>(ProfileAct.class);
    public IntentsTestRule<ProfileAct>intentsTestRule = new IntentsTestRule<>(ProfileAct.class);

    @Before
    public void setUp() throws Exception {
    }


    @Test
    //check that expected intent was sent without starting the activity
    public void backToMenuPro(){
        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor(MenuAct.class.getName(),null,true);
        InstrumentationRegistry.getInstrumentation().addMonitor(am);
        onView(withId(R.id.back)).check(matches(isDisplayed())).perform(click());
        Assert.assertTrue(InstrumentationRegistry.getInstrumentation().checkMonitorHit(am,1));
    }


}