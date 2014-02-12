package com.example.cleanandsobertoolboxandroid;





import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;

public class FirstScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_screen);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_screen, menu);
		return true;
	}

}
