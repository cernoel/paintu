package com.example.paintu;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.AssertionFailedError;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.service.autofill.Validators.not;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testButtonVisible() {
        onView(withId(R.id.bt_tools_chooser)).check(matches(isDisplayed()));
    }

    @Test
    public void bottomSheetVisible() {
        onView(withId(R.id.bt_tools_chooser)).perform(click());

        onView(withId(R.id.bottom_sheet)).check(matches(isDisplayed()));
    }

    @Test
    public void drawingViewVisible() {
        onView(withId(R.id.drawing_view)).check(matches(isDisplayed()));
        assertNotNull(mainActivityTestRule.getActivity().drawingView);
    }

    @Test
    public void bitmapExists() {
        assertNotNull(mainActivityTestRule.getActivity().drawingView.bitmap);
    }

    @Test
    public void canvasExists() {
        assertNotNull(mainActivityTestRule.getActivity().drawingView.canvas);
    }

    @Test
    public void testPointButton() {
        onView(withId(R.id.bt_tools_chooser)).perform(click());
        onView(withId(R.id.tool_point)).perform(click());
        try {
            onView(withId(R.id.drawing_view)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        } catch (AssertionFailedError e) {
            // View not displayed
            assertEquals(mainActivityTestRule.getActivity().drawingView.tool, 1);
        }

    }

    @Test
    public void testLineButton() {
        onView(withId(R.id.bt_tools_chooser)).perform(click());
        onView(withId(R.id.tool_line)).perform(click());
        try {
            onView(withId(R.id.drawing_view)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        } catch (AssertionFailedError e) {
            // View not displayed
            assertEquals(mainActivityTestRule.getActivity().drawingView.tool, 2);

        }

    }

    public void testPathButton() {
        onView(withId(R.id.bt_tools_chooser)).perform(click());
        onView(withId(R.id.tool_path)).perform(click());
        try {
            onView(withId(R.id.drawing_view)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        } catch (AssertionFailedError e) {
            // View not displayed
            assertEquals(mainActivityTestRule.getActivity().drawingView.tool, 3);
        }

    }


}