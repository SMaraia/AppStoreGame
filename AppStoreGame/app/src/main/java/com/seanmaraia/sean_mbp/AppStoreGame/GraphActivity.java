package com.seanmaraia.sean_mbp.AppStoreGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/*
    This uses the MPAndroidChart library to create a line graph of calories consumed.
    The library can be found here: https://github.com/PhilJay/MPAndroidChart
    Documentation for the library can be found here: https://github.com/PhilJay/MPAndroidChart/wiki
 */

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
