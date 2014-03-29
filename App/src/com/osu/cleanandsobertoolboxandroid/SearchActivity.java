package com.osu.cleanandsobertoolboxandroid;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SearchActivity extends ListActivity{

	MessageDataSource db = new MessageDataSource(this);

	/**
	 * Activity to search database
	 */
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		handleIntent(getIntent());
	}

	public void onNewIntent(Intent intent){
		setIntent(intent);
		handleIntent(intent);
	}
	
	public void onListItemClick(ListView list, View v, int position, long id){
		//Call activity for clicked entry
	}
	
	public void handleIntent(Intent intent){
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			search(query);
		}
	}
	
	private void search(String query){
		//Do actual searching
		Cursor c = db.getWordMatches(query, null);
		
		
	}
}
