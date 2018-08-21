package com.mytaxi.android_demo.automation.tests;


import android.Manifest;
import android.content.Intent;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.automation.steps.Login;
import com.mytaxi.android_demo.automation.steps.Search;
import com.mytaxi.android_demo.automation.steps.DrvProfile;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.Matchers.allOf;

import android.support.test.rule.ActivityTestRule;

@RunWith(AndroidJUnit4.class)
public class SearchTest extends BaseTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.ACCESS_FINE_LOCATION);


//    @Rule
//    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>( MainActivity.class);

    Search search;
/*
    static Search search;

    //Somehow now working
    @BeforeClass
    public static void initSetup() {
        String user = "crazydog335";
        String passwd = "venture";

        Login login = new Login();
        search = login.doLogin(user, passwd);

   }
*/

    @AfterClass
    public static void closeSetup() {
        //  search.doLogout();
    }

    @Before
    public void startUp() {
        waitInSec(5);
    }

    @Test
    public void testSearch() {
        String user = "crazydog335";
        String passwd = "venture";

        Login login = new Login();
        search = login.doLogin(user, passwd);

        search = new Search();

        waitInSec(5);
        search.doSearch("sa");

        String name = "Sarah Scott";
        DrvProfile drvProfile = search.selectName(name);
        //Verify the selected name
        drvProfile.getDrvProfile().check(ViewAssertions.matches(ViewMatchers.withText(name)));

        drvProfile.callDriver();

 /*
        //Unable to capture the dialer
        Intents.init();
        intended(allOf(
                hasAction(Intent.ACTION_DIAL)
                ,
                toPackage("com.google.android.dialer")
        ));
 */
    }


}
