package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.List;
import java.util.ArrayList;

public class RewardsFragment extends ListFragment
{
	onArticleSelectedListener mCallback;
	
	SharedPreferences prefs = null;
    final String DAYS_SOBER = "DAYS_SOBER";
    final static int position = 5; //Position on drawer menu
    
    ListView listView;
    List<RewardRowItem> rowItems = new ArrayList<RewardRowItem>();
    
  //Get icons for rows
    public final Integer[] images = {R.drawable.sevendaysicon, R.drawable.thirtydaysicon, R.drawable.sixtydaysicon,
    		R.drawable.ninetydaysicon,R.drawable.sixmonthsicon, R.drawable.ninemonthsicon,R.drawable.yearicon,R.drawable.certicon};
    
    //Get strings for rows
    public final String[] text = {"Seven Days", "Thirty Days", "Sixty Days", "Ninety Days", "Six Months", "Nine Months", "One Year", "Certificate"};
    
    //onArticleSelectedListener interface (must be implemented in activity)
    public interface onArticleSelectedListener{
    	public void onArticleSelected(int position);
    }
    
    //Override attach to get listener
    @Override
    public void onAttach (Activity activity){
    	super.onAttach(activity);
    	try{
    		mCallback = (onArticleSelectedListener) activity;
    	}catch(ClassCastException e){
    		throw new ClassCastException(activity.toString() + "must implement onArticleSelectedListener");
    	}
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
    	setHasOptionsMenu(true);
    	
    	//Get data
    	int i = 0;
    	//Create rows
    	while (i < text.length){
    		RewardRowItem item = new RewardRowItem (images[i], text[i]);
    		rowItems.add(item);
    		i++;
    	}
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState){
    	View v1 = inflater.inflate(R.layout.reward_list, container, false);
    	return v1;
    }
    
 
    @Override
    public void onActivityCreated (Bundle savedInstanceState){
    	super.onActivityCreated(savedInstanceState);
    	RewardAdapter adapter = new RewardAdapter(getActivity(),R.layout.rewards_list_item,rowItems);
    	setListAdapter(adapter);
    }
    	
    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {
       mCallback.onArticleSelected(position);
    }
   
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem helpItem  = menu.findItem(R.id.help);
        if (helpItem != null)
        	helpItem.setVisible(false);
        
        MenuItem searchItem  = menu.findItem(R.id.search);
        if (searchItem != null)
        	searchItem.setVisible(false);
    }

}
