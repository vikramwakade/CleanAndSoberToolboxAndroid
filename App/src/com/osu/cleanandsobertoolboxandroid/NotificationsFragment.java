package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class NotificationsFragment extends Fragment {
	int curPosition = -1;
	final static int POSITION = 3;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setHasOptionsMenu(true);
    	
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
        
		((MainActivity) getActivity()).setActionBarTitle("Your title");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.notifications_layout, container, false);

	}
	
	@Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem helpItem  = menu.findItem(R.id.help);
        helpItem.setVisible(false);
        
        MenuItem searchItem  = menu.findItem(R.id.search);
        searchItem.setVisible(false);
    }

}
