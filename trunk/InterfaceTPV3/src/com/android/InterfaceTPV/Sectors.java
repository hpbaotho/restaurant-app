package com.android.InterfaceTPV;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sectors extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectors);
        
        //String userStr = getIntent().getStringExtra("WaiterName");

        next1 = (Button) findViewById(R.id.ButtonSector1);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent S1Intent = new Intent(view.getContext(), SectorInside.class);
                S1Intent.putExtra("SectorNum", "Sector 1");
                startActivity(S1Intent);
            }

        });
        
        next2 = (Button) findViewById(R.id.ButtonSector2);
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent S2Intent = new Intent(view.getContext(), SectorInside.class);
                S2Intent.putExtra("SectorNum", "Sector 2");
                startActivity(S2Intent);
            }

        });
        
        next3 = (Button) findViewById(R.id.ButtonSector3);
        next3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent S3Intent = new Intent(view.getContext(), SectorInside.class);
                S3Intent.putExtra("SectorNum", "Sector 3");
                startActivity(S3Intent);
            }

        });
        
        next4 = (Button) findViewById(R.id.ButtonSector4);
        next4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent S4Intent = new Intent(view.getContext(), SectorInside.class);
                S4Intent.putExtra("SectorNum", "Sector 4");
                startActivity(S4Intent);
            }

        });
        
        yourTablesBtn = (Button) findViewById(R.id.ButtonYourTables);
        yourTablesBtn.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
                Intent IntentOpenOrders = new Intent(view.getContext(), OpenOrders.class);
                startActivity(IntentOpenOrders);
			}
		});
        
        backLogin = (Button) findViewById(R.id.ButtonLogout);
        backLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	
            	//TODO:CLOSE SESSION
                Intent IntentLogin = new Intent(view.getContext(), LoginScreen.class);
                startActivity(IntentLogin);
            }

        });
        
        
    }
    private Button next1, next2, next3, next4, backLogin, yourTablesBtn;
}
