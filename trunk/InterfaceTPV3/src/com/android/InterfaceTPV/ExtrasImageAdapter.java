package com.android.InterfaceTPV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ExtrasImageAdapter extends BaseAdapter {
    private Context mContext;

    public ExtrasImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public String getName(int position) {
    	if(position != 0 && position >= mThumbsNames.length)
    	{
    		return mThumbsNames[position];
    	}
        return null;
    }
    
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	View grid;
    	
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	grid = new View(mContext);
        	LayoutInflater inflater=LayoutInflater.from(mContext);
        	grid=inflater.inflate(R.layout.mygrid, parent, false);
        } else {
        	grid = (View)convertView;
        }
        
        ImageView imageView = (ImageView)grid.findViewById(R.id.imagepart);
        TextView textView = (TextView)grid.findViewById(R.id.textpart);
        imageView.setImageResource(mThumbIds[position]);

        textView.setText(mThumbsNames[position]);
        
        return grid;
    }
    
    private Integer[] mThumbIds = {
            R.drawable.extra_1, R.drawable.extra_3,
            R.drawable.extra_4, R.drawable.extra_5,
            R.drawable.extra_6, R.drawable.extra_7,
            R.drawable.extra_0, R.drawable.extra_1,
            R.drawable.extra_2, R.drawable.extra_3,
            R.drawable.extra_4, R.drawable.extra_5,
            R.drawable.extra_6, R.drawable.extra_7,
            R.drawable.extra_0, R.drawable.extra_1,
            R.drawable.extra_2, R.drawable.extra_3,
            R.drawable.extra_4, R.drawable.extra_5,
            R.drawable.extra_6, R.drawable.extra_7
    };
    
    private String[] mThumbsNames = {
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup",
            "Ketchup", "Ketchup"
    };

}