package de.fh_muenster.helloworldapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_showPrefs :
                startActivity(new Intent(this, MyPreferencesActivity.class));
                break;
        }

        return true;
    }

    /**
     * Diese Methode wird beim Klick auf Button "Show" aufgerufen.
     * @param bn_show
     */
    public void showResult(View bn_show){
        Log.d(TAG, "Method showResult started.");

        String inputName = ((TextView) findViewById(R.id.editText_name)).getText().toString();
        Log.d(TAG, "Input name is: " + inputName);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String helloText = computeHelloText(inputName, prefs);

        Intent i = new Intent(this,ShowHelloWorldActivity.class);
        i.putExtra(getString(R.string.intentExtra1), helloText);
        this.startActivity(i);

        Log.d(TAG, "Method showResult ended.");
    }

    protected String computeHelloText(String name, SharedPreferences prefs) {
        String salutation = prefs.getString("salutation", "Hello");
        return salutation + " " + name + "!";
    }


    public void startComputation (View button) {
        new SumIntsTask().execute(2_000_000);
        findViewById(R.id.label1).setVisibility(View.VISIBLE);
        findViewById(R.id.tv_result).setVisibility(View.INVISIBLE);
    }


    /**
     * This inner class contains a complex computation as async task (background task)
     */
    class SumIntsTask extends AsyncTask<Integer, Integer, Long> {

        @Override
        public Long doInBackground(Integer... max) {
            long result = 0;
            for (int x = 0; x<=max[0]; x++) {
                result += x;
            }
            return new Long(result);
        }

        @Override
        public void onPostExecute(Long result) {
            TextView tvResult = (TextView) findViewById(R.id.tv_result);
            tvResult.setText(result.toString());
            tvResult.setVisibility(View.VISIBLE);
        }

    }

}
