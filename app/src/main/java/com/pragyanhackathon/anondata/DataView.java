package com.pragyanhackathon.anondata;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pragyanhackathon.anondata.Data.DatabaseAdapter;

import java.util.ArrayList;

/**
 * Created by microsoft on 12-Dec-15.
 */
public class DataView extends ActionBarActivity {
    private DatabaseAdapter dbAdapter;
    private Cursor c;
    private TableLayout tl;
    private TableRow tr;
    public void onCreate(Bundle savedInstanceState){
        dbAdapter=new DatabaseAdapter(this);
        dbAdapter.open();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_layout);
        tl = (TableLayout) findViewById(R.id.maintable);
        tr = new TableRow(this);
        tr.setBackgroundColor(Color.parseColor("#c0c0c0"));
        tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText={"AGE","TEST","VALUE","AREA"};
        for(String c:headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            tr.addView(tv);
        }
        tl.addView(tr);
        try {
            c=dbAdapter.getData();
            if(c.getCount()>0){
                Log.d("Enterredd","looooooooooooooooooop");
                while (c.moveToNext()) {
                    // Read columns data
                    String age= c.getString(c.getColumnIndex("age"));
                    String test= c.getString(c.getColumnIndex("test"));
                    String value= c.getString(c.getColumnIndex("value"));
                    String area= c.getString(c.getColumnIndex("area"));
                    // dara rows
                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                    String[] colText={age,test,value,area};
                    for(String text:colText) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(16);
                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(text);
                        row.addView(tv);
                    }
                    tl.addView(row);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
