package com.android.InterfaceTPV;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsOfOrder extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsoforder);
        
        // Get the title -> New Order - Table X

        //TextView title_DO = (TextView)findViewById(R.id.DetailsOfOrderTitle);
        //String title = title_DO.getText().toString();
        //title = title + " - " + getIntent().getStringExtra("TableNum");
        //title_DO.setText(title);
        
        final TextView item1 = (TextView) findViewById(R.id.Item1);
        item1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent Item1Intent = new Intent(view.getContext(), DishesDetails.class);
                Item1Intent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                Item1Intent.putExtra("DishName", item1.getText().toString());
                startActivity(Item1Intent);
            }

        });
        
        final TextView item2 = (TextView) findViewById(R.id.Item2);
        item2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent Item2Intent = new Intent(view.getContext(), DishesDetails.class);
                Item2Intent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                Item2Intent.putExtra("DishName", item2.getText().toString());
                startActivity(Item2Intent);
            }

        });
        
        final TextView item3 = (TextView) findViewById(R.id.Item3);
        item3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent Item3Intent = new Intent(view.getContext(), DishesDetails.class);
                Item3Intent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                Item3Intent.putExtra("DishName", item3.getText().toString());
                startActivity(Item3Intent);
            }

        });
        
        //TODO: UPDATE ORDER!!!
        
        // Dishes, beverages and extra use the same screen but changing title and data.
        
        DishBtn = (Button) findViewById(R.id.bDishes);
        DishBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent DishIntent = new Intent(view.getContext(), Dishes.class);
                DishIntent.putExtra("Type", "Dishes");
                DishIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(DishIntent);
            }

        });
        
        BeverageBtn = (Button) findViewById(R.id.bBeverages);
        BeverageBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent BeverageIntent = new Intent(view.getContext(), Dishes.class);
                BeverageIntent.putExtra("Type", "Beverages");
                BeverageIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(BeverageIntent);
            }

        });
        
        ExtraBtn = (Button) findViewById(R.id.bExtras);
        ExtraBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ExtraIntent = new Intent(view.getContext(), Dishes.class);
                ExtraIntent.putExtra("Type", "Extras");
                ExtraIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(ExtraIntent);
            }

        });
        
        PaymentBtn = (Button) findViewById(R.id.bPayment);
        PaymentBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	AlertDialog.Builder builder = new AlertDialog.Builder(DetailsOfOrder.this);
            	builder.setMessage("Are you sure you want to exit?")
            	       .setCancelable(false)
            	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            	           public void onClick(DialogInterface dialog, int id) {
            	                DetailsOfOrder.this.finish();
            	           }
            	       })
            	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
            	           public void onClick(DialogInterface dialog, int id) {
            	                dialog.cancel();
            	           }
            	       });
            	AlertDialog alert = builder.create();
            	alert.show();
            }

        });
        
        CancelBtn = (Button) findViewById(R.id.bCancel);
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent CancelIntent = new Intent(view.getContext(), SectorInside.class);
                CancelIntent.putExtra("SectorNum", getIntent().getStringExtra("SectorNum"));
                startActivity(CancelIntent);
            }

        });
        
        /*
        TextBtn = (Button) findViewById(R.id.dDetails);
        TextBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent DishDetailsIntent = new Intent(view.getContext(), DishesDetails.class);
				startActivity(DishDetailsIntent);
				
			}
		});*/
    }
	
	
    private Button CancelBtn, DishBtn, BeverageBtn, ExtraBtn, PaymentBtn;
}
