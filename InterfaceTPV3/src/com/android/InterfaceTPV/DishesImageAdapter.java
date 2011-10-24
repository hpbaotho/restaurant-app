package com.android.InterfaceTPV;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class DishesImageAdapter extends BaseAdapter {
    private Context mContext;

    public DishesImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }
    
    public String getName(int position) {
    	if(position > 0 && position >= mThumbsNames.length)
    	{
    		return mThumbsNames[position];
    	}
        return null;
    }

    public long getItemId(int position) {
        return 0;
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
    
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.dtortilla, R.drawable.deggs,
            R.drawable.djam, R.drawable.dlasagna,
            R.drawable.drice, R.drawable.dmeatballs,
            R.drawable.dsalad, R.drawable.dtourkeysoup,
            R.drawable.dish_1, R.drawable.dish_1,
            R.drawable.dish_1, R.drawable.dish_1,
            R.drawable.dish_1, R.drawable.dish_1,
            R.drawable.dish_1, R.drawable.dish_1,
            R.drawable.dish_1, R.drawable.dish_1,
            R.drawable.dish_1, R.drawable.dish_1,
            R.drawable.dish_1, R.drawable.dish_1
    };
    static String[] mThumbsNames = {
            "Omelette", "Fried egg",
            "Ham", "Lasagna",
            "Rice", "Meat Balls",
            "Salad", "Soup",
            "Omelette", "Omelette",
            "Omelette", "Omelette",
            "Omelette", "Omelette",
            "Omelette", "Omelette",
            "Omelette", "Omelette",
            "Omelette", "Omelette",
            "Omelette", "Omelette"
    };
    

}