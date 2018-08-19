package com.mytaxi.android_demo.automation.steps;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import com.mytaxi.android_demo.R;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class Login extends Base {

    private ViewInteraction getViewInteraction(int objId) {
        Matcher<View> viewMatcher = withId(objId);
        return onView(allOf(viewMatcher));
    }


    public ViewInteraction getHeader1() {
        return Espresso.onView(
                Matchers.allOf(ViewMatchers.withText("Login"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.action_bar),
                                        childAtPosition(
                                                ViewMatchers.withId(R.id.action_bar_container),
                                                0)),
                                0),
                        ViewMatchers.isDisplayed()));
    }

    public ViewInteraction getUser() {
        return getViewInteraction(R.id.edt_username);
    }

    public ViewInteraction getPasswd() {
        return getViewInteraction(R.id.edt_password);
    }

    public ViewInteraction getSnackbar() {
        return getViewInteraction(R.id.snackbar_text);
    }


    public void setUser(String user) {
        ViewInteraction editText = getViewInteraction(R.id.edt_username);
        editText.perform(ViewActions.typeText(user));
    }


    public void setPasswd(String passwd) {
        ViewInteraction editText = getViewInteraction(R.id.edt_password);
        editText.perform(ViewActions.typeText(passwd));
    }

    public Base doLogin() {
        ViewInteraction login = getViewInteraction(R.id.btn_login);
        login.perform(ViewActions.click());

        return new Search();
    }


    public ViewInteraction getUserHint() {
        int id = R.id.edt_username;
        return getTextInputLayoutViewInteraction(id);
    }

    public ViewInteraction getPasswdHint() {
        return getTextInputLayoutViewInteraction(R.id.edt_password);
    }

    private ViewInteraction getTextInputLayoutViewInteraction(int id) {
        return onView(allOf(
                ViewMatchers.hasDescendant(withId(id)),
                ViewMatchers.withClassName(endsWith("TextInputLayout"))));
    }

}
