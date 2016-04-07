package de.fh_muenster.xbankandroid;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


@RunWith(AndroidJUnit4.class)
public class ExampleUITest {

    //The following rule launches the MainActivity before each test case:
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * This unit test case checks if the logout button appears after pressing the login button.
     */
    @Test
    public void testLoginButton() {
        onView(withId(R.id.bn_Login)).perform(click());
        onView(withId(R.id.bn_Logout)).check(matches(isDisplayed()));
    }
}