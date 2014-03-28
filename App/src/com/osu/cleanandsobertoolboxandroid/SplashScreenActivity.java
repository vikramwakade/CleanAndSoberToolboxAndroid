package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	//Splash screen timer
	private static int SPLASH_TIME_OUT = 5000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run(){
				//Start main app activity
				Intent i = new Intent(SplashScreenActivity.this,MainActivity.class);
				startActivity(i);
				
				//Close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

	

}
