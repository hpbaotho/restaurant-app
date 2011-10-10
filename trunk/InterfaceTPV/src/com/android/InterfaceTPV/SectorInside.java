package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SectorInside extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectorinside);
        
        // Get title -> Sector X
        title = (TextView)findViewById(R.id.SectorInsideTitle);
        title.setText(getIntent().getStringExtra("SectorNum"));
        
        // Waiters
        Spinner s = (Spinner) findViewById(R.id.swaiter1);
        Spinner s2 = (Spinner) findViewById(R.id.swaiter2);
        Spinner s3 = (Spinner) findViewById(R.id.swaiter3);
        Spinner s4 = (Spinner) findViewById(R.id.swaiter4);
        Spinner s5 = (Spinner) findViewById(R.id.swaiter5);
        Spinner s6 = (Spinner) findViewById(R.id.swaiter6);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.Waiters, android.R.layout.simple_spinner_item);
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s2.setAdapter(adapter);
        s3.setAdapter(adapter);
        s4.setAdapter(adapter);
        s5.setAdapter(adapter);
        s6.setAdapter(adapter);
        
        // TODO: Update the current status of the tables according to the database.
        	// TODO: Obtain the data
        	// 
        
        // Process Table 1 Button
		table1 = (Button) findViewById(R.id.stable1);
		table1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ProcessButtonInput(table1, 1, view);
			}
		});
		
        // Process Table 2 Button
		table2 = (Button) findViewById(R.id.stable2);
		table2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ProcessButtonInput(table2, 2, view);
			}
		});
		
        // Process Table 3 Button
		table3 = (Button) findViewById(R.id.stable3);
		table3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ProcessButtonInput(table3, 3, view);
			}
		});
		
        // Process Table 4 Button
		table4 = (Button) findViewById(R.id.stable4);
		table4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ProcessButtonInput(table4, 4, view);
			}
		});
		
        // Process Table 5 Button
		table5 = (Button) findViewById(R.id.stable5);
		table5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ProcessButtonInput(table5, 5, view);
			}
		});
		
        // Process Table 6 Button
		table6 = (Button) findViewById(R.id.stable6);
		table6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ProcessButtonInput(table6, 6, view);
			}
		});
		
        // Process Back Button
        backSec = (Button) findViewById(R.id.BackSectorInside);
        backSec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent IntentSectors = new Intent(view.getContext(), Sectors.class);
                startActivity(IntentSectors);
            }

        });
    }
    
    // Returns -1 if the mainString doesn't contain the subString
    private int CheckSubString(String mainString, String subString)
    {
    	return mainString.indexOf(subString);
    }
    
    
    private void ProcessButtonInput(Button b, int numTable, View v)
    {
		if((CheckSubString(b.getText().toString(), "Available")) != -1)
		{
			b.setText(numTable + " - Occupied");
            Intent tableNO = new Intent(v.getContext(), NewOrder.class);
            tableNO.putExtra("SectorNum", title.getText().toString());
            tableNO.putExtra("TableNum", "Table "+numTable);
            startActivity(tableNO);
		}
		else if(CheckSubString(b.getText().toString(), "Occupied") != -1)
		{
			Intent tableOD = new Intent(v.getContext(), LoginScreen.class);
			startActivity(tableOD);
		}
		else if(CheckSubString(b.getText().toString(), "Reserved") != -1)
		{
			b.setText(numTable + " - Available");
		}
    }
    
    private Button table1, table2, table3, table4, table5, table6, backSec;
    private TextView title;
}
