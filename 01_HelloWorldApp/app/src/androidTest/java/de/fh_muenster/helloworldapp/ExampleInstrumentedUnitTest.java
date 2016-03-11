package de.fh_muenster.helloworldapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.fh_muenster.helloworldapp.MainActivity;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedUnitTest  {

    private static final String TEST_NAME = "Sebastian Thoene";

    //The following rule launches the MainActivity before each test case:
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * This unit test case checks if method computeHelloText() of class MainActivity works.
     */
    @Test
    public void testCase() {

        //Via the Instrumentation-API you have access to the target context of your application.
        //The target context is useful, e.g., in order to get the SharedPreferences.
        Context targetContext = InstrumentationRegistry.getTargetContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(targetContext);

        //The ActivityTestRule has launched the MainActivity. With getActivity() we can access it.
        MainActivity testObject = mActivityRule.getActivity();
        String result = testObject.computeHelloText(TEST_NAME, prefs);

        assertEquals("Hello " + TEST_NAME +"!", result);
    }

}