package com.osu.cleanandsobertoolboxandroid;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubCategoryFragment extends ListFragment {
	final static String CATEGORY_POSITION = "cPosition";
	int cCurrentPosition = -1;
	
	OnSubCategorySelectedListener mCallback;

	public interface OnSubCategorySelectedListener {
		public void onSubCategorySelected(int cPosition, int scPosition);
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

        // Create an array adapter for the list view, using the Ipsum headlines array
        Bundle args = getArguments();
        cCurrentPosition = args.getInt(CATEGORY_POSITION);
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Data.SubCategories[cCurrentPosition]));
    }

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		mCallback = (OnSubCategorySelectedListener) activity;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		mCallback.onSubCategorySelected(cCurrentPosition, position);
	}

}
