package com.pragyanhackathon.anondata;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button DataButton;
    private Button ViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls(){
        DataButton = (Button)findViewById(R.id.button2);
        ViewButton = (Button)findViewById(R.id.button3);
        DataButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                StoreData(v);
            }
        });
        ViewButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ViewData(v);
            }
        });
    }

    private void StoreData(View v){
        Intent i = new Intent(getApplicationContext(),DataEntry.class);
        startActivity(i);
        finish();
    }

    private void ViewData(View v){
        Intent i = new Intent(getApplicationContext(),DataAccess.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
