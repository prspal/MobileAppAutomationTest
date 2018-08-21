package com.mytaxi.android_demo.automation.steps;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;

import com.mytaxi.android_demo.R;

public class DrvProfile extends Base {

    public ViewInteraction getDrvProfile() {
        return getViewInteraction(R.id.textViewDriverName);
    }

    public void callDriver() {
        getViewInteraction(R.id.fab).perform(ViewActions.click());
    }

}
