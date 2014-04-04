package com.osu.cleanandsobertoolboxandroid;

import java.util.List;
import com.osu.cleanandsobertoolboxandroid.*;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RewardAdapter extends ArrayAdapter<RewardRowItem>{
	
	Context context;
	private List<RewardRowItem> items;
	
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
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
			final RewardRowItem item = items.get(position);
			if(item != null){
				holder.text.setText(rowItem.getText());
				holder.imageView.setImageResource(rowItem.getImageId());
			}
		
		return convertView;
	}

}
