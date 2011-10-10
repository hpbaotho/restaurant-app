package com.android.InterfaceTPV;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

public class InterfaceTPV extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent MainIntent = new Intent(this.getApplicationContext(), LoginScreen.class);
        setContentView(R.layout.main);
        
        try{
        	startActivity(MainIntent);
        }
        catch (Exception e){
    		AlertDialog.Builder b=new AlertDialog.Builder(this);
    		b.setMessage(e.toString());
    		b.show();
        }
    }
}