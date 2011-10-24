package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Dishes extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishes);	
        
        // Get the title -> New Order - Table X
        
        TextView title = (TextView)findViewById(R.id.TypeTitle);
        title.setText(getIntent().getStringExtra("Type"));
        
        String titleStr = title.getText().toString();
        
        // Preparing the GridView
        GridView gridview = (GridView) findViewById(R.id.gridview);

        
        //TODO: Load contain from the database
        
        if(titleStr.equals("Dishes".toString()))
        {
        	// Load DISH data
        	DIA = new DishesImageAdapter(this);
            gridview.setAdapter(DIA);
            //title.setText("HOLA");
        }
        else if(titleStr.equals("Beverages".toString()))
        {
        	// Load Beverage data
        	BIA = new BeveragesImageAdapter(this);
        	gridview.setAdapter(BIA);
        }
        else if(titleStr.equals("Extras".toString()))
        {
        	// Load Extra data
        	EIA = new ExtrasImageAdapter(this);
        	gridview.setAdapter(EIA);
        }
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // TEST ON CLICK: Toast.makeText(Dishes.this, "" + position, Toast.LENGTH_SHORT).show();
                Intent DishDetailsIntent = new Intent(v.getContext(), DishesDetails.class);
                DishDetailsIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                TextView tv= (TextView) v.findViewById(R.id.textpart);
                String DishName = tv.getText().toString();
                DishDetailsIntent.putExtra("DishName", DishName);
                startActivity(DishDetailsIntent);
            }
        });
        
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
        
        SelectBtn = (Button) findViewById(R.id.bSelect);
        SelectBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent SelectIntent = new Intent(view.getContext(), DishesDetails.class);
                SelectIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(SelectIntent);
            }

        });
        
        CancelBtn = (Button) findViewById(R.id.bCancel);
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent CancelIntent = new Intent(view.getContext(), DetailsOfOrder.class);
                CancelIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(CancelIntent);
            }

        });
    }
	
    private Button CancelBtn, SelectBtn;
    private DishesImageAdapter DIA;
    private BeveragesImageAdapter BIA;
    private ExtrasImageAdapter EIA;
}
