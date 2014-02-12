package com.example.cleanandsobertoolboxandroid;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopicsFragment extends ListFragment {
	final static String CATEGORY_POSITION = "cPosition";
	final static String SUBCATEGORY_POSITION = "scPosition";
	int cCurrentPosition = -1;
	int scCurrentPosition = -1;
	
	OnTopicSelectedListener mCallback;
	
	public interface OnTopicSelectedListener {
		public void onTopicSelected(int cPosition, int scPosition ,int tPosition);
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Create an array adapter for the list view, using the Ipsum headlines array
        Bundle args = getArguments();
        cCurrentPosition = args.getInt(CATEGORY_POSITION);
        scCurrentPosition = args.getInt(SUBCATEGORY_POSITION);
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Data.Headlines[cCurrentPosition][scCurrentPosition]));
    }

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		mCallback = (OnTopicSelectedListener) activity;
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
		
		mCallback.onTopicSelected(cCurrentPosition, scCurrentPosition, position);
	}

}
