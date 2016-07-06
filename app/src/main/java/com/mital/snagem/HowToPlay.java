//Simple Android TabHost and TabWidget Example
package com.mital.snagem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class HowToPlay extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        TabHost host = (TabHost)findViewById(android.R.id.tabhost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Instructions");
        spec.setContent(R.id.Instructions);
        spec.setIndicator("Instructions");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("FAQS");
        spec.setContent(R.id.FAQS);
        spec.setIndicator("FAQS");
        host.addTab(spec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}