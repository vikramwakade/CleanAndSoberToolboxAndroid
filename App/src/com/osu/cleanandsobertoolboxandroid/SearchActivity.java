package com.osu.cleanandsobertoolboxandroid;

import com.osu.cleanandsobertoolboxandroid.CategoryFragment.onCategorySelectedListener;
import com.osu.cleanandsobertoolboxandroid.SearchFragment.onSearchResultSelectedListener;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class SearchActivity extends FragmentActivity 
		implements onSearchResultSelectedListener, onCategorySelectedListener {
	/**
	 * Activity to search database
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_categories);
		
		handleIntent(getIntent());
	}
	
	public void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			SearchFragment firstFragment = new SearchFragment();
	        
	        Bundle args = new Bundle();
	        
	        args.putString(SearchFragment.QUERY, query);
	        firstFragment.setArguments(args);

	        // Add the fragment to the 'fragment_container' FrameLayout
	        getSupportFragmentManager().beginTransaction()
	                .add(R.id.content_frame, firstFragment).commit();
		}
	}

	@Override
	public void onSearchResultSelected(int itemId, String type) {
		onCategorySelected(itemId, type);
	}

	@Override
	public void onCategorySelected(int itemId, String type) {
		if(type.equals("category")) {
    		CategoryFragment categoryFragment = new CategoryFragment();

    		Bundle args = new Bundle();
    		args.putInt(CategoryFragment.PARENT_ID, itemId);
    		categoryFragment.setArguments(args);

    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		transaction.replace(R.id.content_frame, categoryFragment);
    		transaction.addToBackStack(null);

    		// Commit the transaction
    		transaction.commit();
    	} else if(type.equals("content")) {
    		MessageFragment messageFragment = new MessageFragment();
    		
    		Bundle args = new Bundle();
    		args.putInt(MessageFragment.CONTENT_ID, itemId);
    		messageFragment.setArguments(args);

    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		transaction.replace(R.id.content_frame, messageFragment);
    		transaction.addToBackStack(null);

    		// Commit the transaction
    		transaction.commit();
    	}
	}
}
