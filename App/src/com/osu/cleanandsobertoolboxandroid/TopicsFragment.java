package com.osu.cleanandsobertoolboxandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopicsFragment extends ListFragment {
	final static String CATEGORY_ID = "categoryId";
	final static String SUBCATEGORY_ID = "subCategoryId";
	
	MessageDataSource ds;
	
	OnTopicSelectedListener mCallback;
	
	public interface OnTopicSelectedListener {
		public void onTopicSelected(int position);
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        ds = new MessageDataSource(getActivity());
        ds.open();
        
        // Create an array adapter for the list view, using the Ipsum headlines array
        Bundle args = getArguments();
        Content.Contents = ds.getContents(getActivity(), args.getInt(SUBCATEGORY_ID));
        
        List<String> titles = new ArrayList<String>();
        for(Content c : Content.Contents) {
        	titles.add(c.getTitle());
        }
        
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, titles));
    }

	@Override
	public void onAttach(Activity activity) {
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
		super.onListItemClick(l, v, position, id);
		
		// ToDo
		mCallback.onTopicSelected(position);
	}

}
