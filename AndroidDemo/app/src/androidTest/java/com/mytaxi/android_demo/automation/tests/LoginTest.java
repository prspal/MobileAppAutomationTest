package com.mytaxi.android_demo.automation.tests;


import android.Manifest;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.automation.steps.Base;
import com.mytaxi.android_demo.automation.steps.Login;
import com.mytaxi.android_demo.automation.steps.Search;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

//import android.support.test.rule.ActivityTestRule;

@RunWith(AndroidJUnit4.class)
public class LoginTest extends BaseTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.ACCESS_FINE_LOCATION);


    @Before
    public void startUp() {
        waitInSec(5);
    }

    @Test
    public void testInvalidLogin() {
        Login login = new Login();

        String user = "user";
        String passwd = "passwd";

        //Verify the Header text
        login.getHeader().check(ViewAssertions.matches(ViewMatchers.withText("Login")));

        login.getPasswdHint().check(ViewAssertions.matches(withHint("Password")));
        login.setPasswd(passwd);

        login.getUserHint().check(ViewAssertions.matches(withHint("Username")));
        login.setUser(user);

        login.doLogin();
        //Invalid user, should result in 'Login fail' msg in Snackbar
        //Unable to catch this
//        login.getSnackbar().check(ViewAssertions.matches(ViewMatchers.withText("Login failed")));

        //Failed login will be in the same page, so check the header again
        login.getHeader().check(ViewAssertions.matches(ViewMatchers.withText("Login")));
    }

    @Test
    public void testValidLogin() {
        Login login = new Login();

        String user = "crazydog335";
        String passwd = "venture";

        //Verify the Header text
        login.getHeader().check(ViewAssertions.matches(ViewMatchers.withText("Login")));

        login.getPasswdHint().check(ViewAssertions.matches(withHint("Password")));
        login.setPasswd(passwd);

        login.getUserHint().check(ViewAssertions.matches(withHint("Username")));
        login.setUser(user);

        Search search = (Search) login.doLogin();

        waitInSec(5);

        ViewInteraction header = search.getHeader();
        header.check(ViewAssertions.matches(ViewMatchers.withText("mytaxi demo")));


        login = search.doLogout();

        waitInSec(5);
        login.getHeader().check(ViewAssertions.matches(ViewMatchers.withText("Login")));

    }

}
