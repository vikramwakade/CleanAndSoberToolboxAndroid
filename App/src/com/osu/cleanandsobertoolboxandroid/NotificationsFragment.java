package com.osu.cleanandsobertoolboxandroid;


import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

public class NotificationsFragment extends Fragment {
	int curPosition = -1;
	final static int POSITION = 4;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setHasOptionsMenu(true);
    	
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.notifications_layout, container, false);

	}
	
	@Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem helpItem  = menu.findItem(R.id.help);
        if (helpItem != null)
        	helpItem.setVisible(false);
        
        MenuItem searchItem  = menu.findItem(R.id.search);
        if (searchItem != null)
        	searchItem.setVisible(false);
    }

    public void onActivityCreated (Bundle savedInstanceState){
    	super.onActivityCreated(savedInstanceState);
    	
    	//Set toggle button based on shared prefs
    	SharedPreferences prefs = getActivity().getSharedPreferences("com.osu.cleanandsobertoolboxandroid", 0);
    	
    	boolean first = prefs.getBoolean("firstrunnotes", true);
    	
    	ToggleButton button = (ToggleButton)getView().findViewById(R.id.toggleButton1);
    	
    	//If app is on for first time, go ahead and switch button on to set alarm for notifications.
    	if (first == true)
    	{
    		button.setChecked(true);
    		prefs.edit().putBoolean("firstrunnotes", false).commit();
    		
    		//Go ahead and schedule the notifications initially
    		
    		Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			calendar.add(Calendar.HOUR, 24);
			
			//Retrieve AlarmManager from system
			AlarmManager alarmManager = (AlarmManager)getActivity().getApplicationContext().getSystemService(getActivity().getBaseContext().ALARM_SERVICE);
			
			//Create intent and pending intent
			//Create alarm id
			int id = (int) System.currentTimeMillis();
			
			//Need to save this id in sharedprefs so alarm can be deleted
			prefs.edit().putInt("DailyId", id).commit();
					
			//Prepare intent
			Intent intent = new Intent(this.getActivity(), AlarmReceiver.class);
					
			//Set mode of notification
			intent.putExtra("NotificationType", 1);
					
			//Create pending intent (Need to do it here because we have to have the intent to cancel it too)
			PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getApplicationContext(),id, intent, 0);
			
			//Save toggle state in shared prefs
			prefs.edit().putBoolean("Toggle", true).commit();
			
			//Save alarm time in shared prefs for recovery
			prefs.edit().putLong("DailyNoteTime", calendar.getTimeInMillis()).commit();
			
    		//Register alarm in system
			alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    	}
    	
    	else {
    	
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
	
}
