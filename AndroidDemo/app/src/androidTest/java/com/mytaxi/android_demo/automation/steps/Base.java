package com.mytaxi.android_demo.automation.steps;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.mytaxi.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class Base {

    protected ViewInteraction getViewInteraction(int objId) {
        Matcher<View> viewMatcher = withId(objId);
        return onView(allOf(viewMatcher));
    }


    public ViewInteraction getHeader() {

        return onView(allOf(
                ViewMatchers.withClassName(Matchers.endsWith("TextView")),
                Matchers.anyOf(
                        ViewMatchers.withParent(withId(R.id.action_bar)),
                        ViewMatchers.withParent(withId(R.id.toolbar))
                ),

                ViewMatchers.isDisplayed()));
    }


    protected static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
