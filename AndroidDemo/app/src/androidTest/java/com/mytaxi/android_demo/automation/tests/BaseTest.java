package com.mytaxi.android_demo.automation.tests;

import android.support.design.widget.TextInputLayout;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

class BaseTest {
    //Copied code for getting Hint value properly
    public static Matcher<View> withHint(final String expectedHint) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextInputLayout)) {
                    return false;
                }

                String hint = ((TextInputLayout) view).getHint().toString();

                return expectedHint.equals(hint);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    public void waitInSec(int timeInSec) {
        try {
            Thread.sleep(1000 * timeInSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
