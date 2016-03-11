package de.fh_muenster.helloworldapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.fh_muenster.mysmallapplication.R;

public class ShowHelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hello_world);

        String text = this.getIntent().getStringExtra(getString(R.string.intentExtra1));

        TextView tv = (TextView) findViewById(R.id.textView_helloWorld);
        tv.setText(text);
    }
}
