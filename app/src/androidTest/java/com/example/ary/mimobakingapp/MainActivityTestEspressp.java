package com.example.ary.mimobakingapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.ary.mimobakingapp.TestUtils.withRecyclerView;

/**
 * Created by ary on 9/27/17.
 */

public class MainActivityTestEspressp extends ActivityInstrumentationTestCase2<MainActivity>{

    public MainActivityTestEspressp() {
        super(MainActivity.class);
    }

    @Override protected void setUp() throws Exception {

        getActivity();
    }

    public void testItemClick() {

        onView(withRecyclerView(R.id.rv_page_1).atPosition(3)).perform(click());

        onView(withId(R.id.recipename)).check(matches(isDisplayed()));

    }


}
