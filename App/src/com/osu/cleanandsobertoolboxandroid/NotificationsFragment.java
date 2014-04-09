package com.osu.cleanandsobertoolboxandroid;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
	
	
}
