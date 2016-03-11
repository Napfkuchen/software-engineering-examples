package de.fh_muenster.helloworldapp;

import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.fh_muenster.helloworldapp.MainActivity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Mock
    private SharedPreferences mockPrefs;

    @Before
    public void prepareMocks() {
        when(mockPrefs.getString("salutation", "Hello")).thenReturn("Hello (Mock)");
    }

    @Test
    public void testCase() {
        MainActivity testObject = new MainActivity();
        String result = testObject.computeHelloText("World", mockPrefs);
        assertEquals("Hello (Mock) World!", result);
    }
}