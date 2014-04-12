package com.osu.cleanandsobertoolboxandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchFragment extends ListFragment {
	final static String QUERY = "query";
	
	MessageDataSource ds;
	List<Category> CategoryList;
	
	onSearchResultSelectedListener mCallback;
	
	public interface onSearchResultSelectedListener {
		public void onSearchResultSelected(int position, String type);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        
        if (savedInstanceState != null) {
            return;
        }
        
        ds = new MessageDataSource(getActivity());
        ds.open();
        
        Bundle args = getArguments();
        CategoryList = ds.getQueryMatches(args.getString(QUERY));
        
        ds.close();
        
        List<String> results = new ArrayList<String>();
        for (Category c : CategoryList) {
        	results.add(c.getTitle());
        }
        Toast.makeText(getActivity(),  "Results: "+ results.size(), Toast.LENGTH_LONG).show();
        
        // Create an array adapter for the list view
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_list_layout, results));
    }
	
	@Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem search  = menu.findItem(R.id.search);
        if( search != null)
        	search.setVisible(false);
    }
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		mCallback = (onSearchResultSelectedListener) activity;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		int itemId = CategoryList.get(position).getId();
		String type = CategoryList.get(position).getType();
		
		mCallback.onSearchResultSelected(itemId, type);
	}
}
