package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DishesDetails extends Activity {
	// Variables for add and rest quantities
	private TextView finalQuantity;
	private EditText actualQuantity;
	private double result;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishesdetails);
        
        // Assign the objects
        this.actualQuantity = (EditText) findViewById(R.id.tQuantityDish);
        this.finalQuantity = (TextView) findViewById(R.id.tQuantityDish);
        
        // Get the title
        TextView title = (TextView)findViewById(R.id.SectorInsideTitle);
        title.setText(getIntent().getStringExtra("DishName"));
        
       // Write default name
        EditText etName = (EditText)findViewById(R.id.tNameDish);
        etName.setText(getIntent().getStringExtra("DishName"));
        
        //TODO: Load contain from the database
        /*
        if(titleStr == "Dish Details")
        {
        	
        }
        else if(titleStr == "Beverage Details")
        {
        	
        }
        else if(titleStr == "Extra Details")
        {
        	
        }*/
        
        Spinner s = (Spinner) findViewById(R.id.sSizeDish);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.Sizes, android.R.layout.simple_spinner_item);
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        
        //TextView title_DO = (TextView)findViewById(R.id.DetailsOfOrderTitle);
        //String title = title_DO.getText().toString();
        //title = title + " - " + getIntent().getStringExtra("TableNum");
        //title_DO.setText(title);
        
        /*DishBtn = (Button) findViewById(R.id.bDishes);
        DishBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent CancelIntent = new Intent(view.getContext(), DishesDetails.class);
                CancelIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(CancelIntent);
            }

        });*/
        
        CancelBtn = (Button) findViewById(R.id.bBack);
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent CancelIntent = new Intent(view.getContext(), DetailsOfOrder.class);
                CancelIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(CancelIntent);
            }

        });
    }
	
	public void cAdd(View view) {
		if(this.actualQuantity.getText().toString().length() >= 0)
		{
			this.result = Integer.parseInt(this.actualQuantity.getText().toString());
			this.finalQuantity.setText(Integer.toString((int) (this.result+1)));
		}
	}
	
	public void cRest(View view) {
		if(this.actualQuantity.getText().toString().length() >= 0)
		{
			this.result = Integer.parseInt(this.actualQuantity.getText().toString());
			this.finalQuantity.setText(Integer.toString((int)(this.result-1)));
		}
	}
	
    private Button CancelBtn, DishBtn;
}