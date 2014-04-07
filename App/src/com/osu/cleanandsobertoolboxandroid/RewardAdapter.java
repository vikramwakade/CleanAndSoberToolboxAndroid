package com.osu.cleanandsobertoolboxandroid;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RewardAdapter extends ArrayAdapter<RewardRowItem>{
	
	Context context;
	private List<RewardRowItem> items;
	SharedPreferences prefs = null;
	
	
	public RewardAdapter(Context context, int resourceId, List<RewardRowItem> items){
		super(context, resourceId, items);
		this.context = context;
		this.items = items;
	}
	//Private view holder class
	private class ViewHolder{
		ImageView imageView;
		TextView text;
	}
	
	public boolean areAllItemsEnabled() {
        return false;
    }

	@Override
    public boolean isEnabled(int position) {
    	prefs = context.getSharedPreferences("com.osu.cleanandsobertoolboxandroid", 0);
    	//Get days sober from prefs
    	int days = prefs.getInt("DAYS_SOBER",1);
    	
    	//Decide which items to block out
    	switch (position){
    	//Seven days
    	case 0:
    		if (days >= 7)
    		{
    			return true;
    		}
    		break;
    		//Thirty days (1 month)
    	case 1:
    		if (days >= 30)
    		{
    			return true;
    		}
    		break;
    		//Sixty days
    	case 2:
    		if (days >= 60)
    		{
    			return true;
    		}
    		break;
    		//Ninety days
    	case 3:
    		if (days >= 90)
    		{
    			return true;
    		}
    		break;
    		//6 Months
    	case 4:
    		if (days >= 180)
    		{
    			return true;
    		}
    		break;
    		//Nine months
    	case 5:
    		if (days >= 274)
    		{
    			return true;
    		}
    		break;
    		//One year
    	case 6:
    		if (days >= 365)
    		{
    			return true;
    		}
    		break;
    		//Certificate
    	case 7:
    		if (days >= 365)
    		{
    			return true;
    		}
    		break;
    	}
    	return false;
    	
    }
	
	//Get actual view
	public View getView(int position, View convertView, ViewGroup parent){
		ViewHolder holder = new ViewHolder();
		RewardRowItem rowItem = getItem(position);
		
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null){
			convertView = mInflater.inflate(R.layout.rewards_list_item, parent, false);
			holder.text = (TextView) convertView.findViewById(R.id.rewardtext);
			holder.imageView = (ImageView) convertView.findViewById(R.id.rewardicon);
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
			final RewardRowItem item = items.get(position);
			if(item != null){
				holder.text.setText(rowItem.getText());
				holder.imageView.setImageResource(rowItem.getImageId());
			}
		
			if (this.isEnabled(position) == false){
				//convertView.setAlpha(75); 
				//convertView.setBackgroundColor(Color.GRAY);
				//Set text and image to grey and opaque
				TextView text = (TextView)convertView.findViewById(R.id.rewardtext);
				ImageView image = (ImageView)convertView.findViewById(R.id.rewardicon);
				
				text.setTextColor(Color.GRAY);
				image.setAlpha(128);
			}
			else if (this.isEnabled(position) == true){
				//convertView.setAlpha(255);
				//convertView.setBackgroundColor(Color.WHITE);
				//Set text and image to black and normal
				TextView text = (TextView)convertView.findViewById(R.id.rewardtext);
				ImageView image = (ImageView)convertView.findViewById(R.id.rewardicon);
				
				text.setTextColor(Color.BLACK);
				image.setAlpha(255);
			}
		return convertView;
	}

}
