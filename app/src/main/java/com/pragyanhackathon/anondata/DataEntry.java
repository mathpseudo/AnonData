package com.pragyanhackathon.anondata;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.pragyanhackathon.anondata.Data.DatabaseAdapter;


public class DataEntry extends ActionBarActivity {
    private EditText theAge;
    private EditText theTest;
    private EditText theValue;
    private EditText theArea;
    private Button storeButton;
    private DatabaseAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        initControls();
    }

    private void initControls(){
        dbAdapter=new DatabaseAdapter(this);
        dbAdapter.open();
        theAge = (EditText)findViewById(R.id.editText);
        theTest = (EditText)findViewById(R.id.editText2);
        theValue = (EditText)findViewById(R.id.editText3);
        theArea = (EditText)findViewById(R.id.editText4);
        storeButton = (Button)findViewById(R.id.button);
        storeButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Store(v);
            }
        });
    }

    private void Store(View v){
        String thisAge = theAge.getText().toString();
        String thisTest = theTest.getText().toString();
        String thisValue = theValue.getText().toString();
        String thisArea = theArea.getText().toString();

        if(thisAge.equals("") || thisTest.equals("") || thisValue.equals("") || thisArea.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
            return;
        }
        dbAdapter.insertData(thisAge, thisTest, thisValue, thisArea);
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
        Log.d("Entered the data",thisAge+thisTest+thisArea+thisValue);
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
