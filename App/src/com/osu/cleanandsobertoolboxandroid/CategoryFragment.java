package com.osu.cleanandsobertoolboxandroid;

import java.util.List;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoryFragment extends ListFragment {
	MessageDataSource ds;
	OnCategorySelectedListner mCallback;
	
	public interface OnCategorySelectedListner {
		public void onCategorySelected(int position);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // If we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            return;
        }

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        
        ds = new MessageDataSource(getActivity());
        ds.open();
        List<String> categories = ds.getAllCategories(getActivity());
        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, categories));
    }
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		mCallback = (OnCategorySelectedListner) activity;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String category = (String) getListAdapter().getItem(position);
		
		int categoryId = ds.getCategoryId(getActivity(), category);
		
		mCallback.onCategorySelected(categoryId);
	}
}
