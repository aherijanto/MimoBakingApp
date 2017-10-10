package com.example.ary.mimobakingapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class StepsClicked {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void stepsClicked() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv_page_1), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.my_recycler_view), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(5, click()));

    }

}
