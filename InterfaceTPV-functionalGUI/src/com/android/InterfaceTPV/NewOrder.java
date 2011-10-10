package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewOrder extends Activity {
	   /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neworder);
        
        // Get the title -> New Order - Table X
        TextView title_tv = (TextView)findViewById(R.id.NewOrder_title);
        String title = title_tv.getText().toString();
        title = title + " - " + getIntent().getStringExtra("TableNum");
        title_tv.setText(title);
        
        NewOrderBack = (Button) findViewById(R.id.BackSS);
        NewOrderBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent SIIntent = new Intent(view.getContext(), SectorInside.class);
                SIIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(SIIntent);
            }

        });
    }
    
    private Button NewOrderBack;
}
