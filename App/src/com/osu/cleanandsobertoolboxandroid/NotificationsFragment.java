package com.osu.cleanandsobertoolboxandroid;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

public class NotificationsFragment extends Fragment {
	int curPosition = -1;
	final static int POSITION = 3;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.notifications_layout, container, false);

	}
	
	@Override
    public void onActivityCreated (Bundle savedInstanceState){
    	super.onActivityCreated(savedInstanceState);
    	
    	//Set toggle button based on shared prefs
    	SharedPreferences prefs = getActivity().getSharedPreferences("com.osu.cleanandsobertoolboxandroid", 0);
    	
    	ToggleButton button = (ToggleButton)getView().findViewById(R.id.toggleButton1);
    	
    	//Button should be on
    	if (prefs.getBoolean("Toggle", false) == true)
    	{
    		button.setChecked(true);
    	}
    	
    	//Button should be off
    	else if (prefs.getBoolean("Toggle",false) == false)
    	{
    		button.setChecked(false);
    	}
    	
    }
	
	
}
