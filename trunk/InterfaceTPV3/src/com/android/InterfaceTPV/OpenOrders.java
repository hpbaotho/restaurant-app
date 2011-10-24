package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenOrders extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openorders);
        
        // Get the title -> New Order - Table X

        //TextView title_DO = (TextView)findViewById(R.id.DetailsOfOrderTitle);
        //String title = title_DO.getText().toString();
        //title = title + " - " + getIntent().getStringExtra("TableNum");
        //title_DO.setText(title);
        
        
        //TODO: UPDATE ORDER!!!
        
        
        BackBtn = (Button) findViewById(R.id.bBack);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent BackIntent = new Intent(view.getContext(), Sectors.class);
                startActivity(BackIntent);
            }

        });
    }
	
    private Button BackBtn;
}
