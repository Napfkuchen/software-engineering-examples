package de.fh_muenster.helloworldapp;

import android.support.test.espresso.matcher.ViewMatchers;
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

    private String testName = "Sebastian Thoene";

    //The following rule launches the MainActivity before each test case:
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * This unit test case checks if the "show" button in the MainActivity works.
     */
    @Test
    public void testShowButton() {
        // Type text and then press the button.
        onView(ViewMatchers.withId(R.id.editText_name)).perform(typeText(testName), closeSoftKeyboard());
        onView(withId(R.id.bn_show)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textView_helloWorld)).check(matches(withText("Hello " + testName + "!")));
    }
}