package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
        
        Button next = (Button) findViewById(R.id.ButtonLogin);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	// TODO:CHECK LOGIN AND CREATE AN USER SESSION
                Intent LoginIntent= new Intent(view.getContext(), Sectors.class);
                LoginIntent.putExtra("com.android.InterfaceTPV.WaiterName", "Alberto"); //THE VALUE MUST BE CHANGED
                startActivity(LoginIntent);
            }

        });
    }
}
