package com.osu.cleanandsobertoolboxandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoryFragment extends ListFragment {
	final static String PARENT_ID = "parentId";
	
	int currentParentId = -1;
	MessageDataSource ds;
	List<Category> CategoryList; 
	
	onCategorySelectedListener mCallback;
	
	public interface onCategorySelectedListener {
		public void onCategorySelected(int position, String type);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        
        // If we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            return;
        }
        
        ds = new MessageDataSource(getActivity());
        ds.open();
        
        Bundle args = getArguments();
        currentParentId = args.getInt(PARENT_ID);
        CategoryList = ds.getAllChildren(getActivity(), currentParentId);
        
        ds.close();
        
        List<String> categories = new ArrayList<String>();
        for (Category c : CategoryList) {
        	categories.add(c.getTitle());
        }
        
        if (!categories.isEmpty()) {
	        String type = CategoryList.get(0).getType();
	        if(type.equals("content")) {
	        	MainActivity.help_message_index.edit().putInt(MainActivity.HELP_INDEX, 2).commit();
	        } else if( type.equals("category")) {
	        	MainActivity.help_message_index.edit().putInt(MainActivity.HELP_INDEX, 1).commit();
	        }
	        
	        if(currentParentId == -1){
	        	MainActivity.help_message_index.edit().putInt(MainActivity.HELP_INDEX, 0).commit();
	        }
	        
	        // Create an array adapter for the list view
        	setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_list_layout, categories));
        }
    }
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		//Make list have dividers
		ListView list = this.getListView();
        list.setDivider(new ColorDrawable(0xFF000000));
        list.setDividerHeight(1);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		mCallback = (onCategorySelectedListener) activity;
	}

	@Override
	public void onStart() {
		
		super.onStart();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		int itemId = CategoryList.get(position).getId();
		String type = CategoryList.get(position).getType();
		mCallback.onCategorySelected(itemId, type);
	}
	@Override
	public void onResume() {
		super.onResume();
		if (CategoryList != null) {
			if (!CategoryList.isEmpty()) {
				String type = CategoryList.get(0).getType();
		        if(type.equals("content")) {
		        	MainActivity.help_message_index.edit().putInt(MainActivity.HELP_INDEX, 2).commit();
		        } else if( type.equals("category")) {
		        	MainActivity.help_message_index.edit().putInt(MainActivity.HELP_INDEX, 1).commit();
		        }
		        
		        if(currentParentId == -1){
		        	MainActivity.help_message_index.edit().putInt(MainActivity.HELP_INDEX, 0).commit();
		        }
			}
		}
	}
	
	@Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        
        MenuItem searchItem = menu.findItem(R.id.search);
        if (searchItem != null)
        	searchItem.setVisible(false);
    }
}
