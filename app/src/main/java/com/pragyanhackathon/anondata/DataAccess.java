package com.pragyanhackathon.anondata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by microsoft on 13-Dec-15.
 */
public class DataAccess extends ActionBarActivity {
    private EditText theUsername;
    private EditText thePassword;
    private Button loginButton;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        initControls();
    }
    private void initControls(){
        loginButton=(Button) findViewById(R.id.button4);
        theUsername=(EditText)findViewById(R.id.editText5);
        thePassword=(EditText)findViewById(R.id.editText6);
        loginButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Login(v);
            }
        });
    }
    private void Login(View v){
        String thisUsername=theUsername.getText().toString();
        String thisPassword=thePassword.getText().toString();
        if(thisUsername.equals("abc") && thisPassword.equals("def")){
            Intent i=new Intent(getApplicationContext(),DataView.class);
            startActivity(i);
            finish();
        }
    }
}
