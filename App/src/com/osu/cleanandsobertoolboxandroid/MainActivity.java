package com.osu.cleanandsobertoolboxandroid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.osu.cleanandsobertoolboxandroid.CategoryFragment.onCategorySelectedListener;

public class MainActivity extends FragmentActivity 
	implements onCategorySelectedListener ,RewardsFragment.onArticleSelectedListener {

	public final static String EXTRA_MESSAGE = "com.example.cbt.DONATION";
	public final static String HELP_MESSAGE = "com.example.cbt.HELP";
	public final static String DAYS_SOBER = "DAYS_SOBER";

	SharedPreferences prefs = null;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    public int days = 1;
    
    /** The view to show the ad. */
    private AdView adView;
 
    /* Your ad unit id. Replace with your actual ad unit id. */
    private static final String AD_UNIT_ID = "INSERT_YOUR_AD_UNIT_ID_HERE";
    public static final String HELP_INDEX = "INDEX";
    public static SharedPreferences help_message_index = null;
    
    public static SharedPreferences navigationMessages = null;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.all_categories);

		help_message_index = getSharedPreferences("com.osu.cleanandsobertoolboxandroid", MODE_PRIVATE);
		help_message_index.edit().putInt(MainActivity.HELP_INDEX, 0).commit();
		
		navigationMessages= getSharedPreferences("com.osu.cleanandsobertoolboxandroid", MODE_PRIVATE);
		
		// Create an ad.
	    adView = new AdView(this);
	    adView.setAdSize(AdSize.BANNER);
	    adView.setAdUnitId("0445b7141d9d4e1b");

	    // Add the AdView to the view hierarchy. The view will have no size
	    // until the ad is loaded.
	    LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
	    layout.addView(adView);

	    final TelephonyManager tm =(TelephonyManager)getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

	    String deviceid = tm.getDeviceId();

	    // Create an ad request. Check logcat output for the hashed device ID to
	    // get test ads on a physical device.
	    AdRequest adRequest = new AdRequest.Builder()
	        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
	        .addTestDevice(deviceid)
	        .build();

	    // Start loading the ad in the background.
	    adView.loadAd(adRequest);

		mTitle = mDrawerTitle = getTitle();
		//Log.i("INFO",mPlanetTitles[0]);
		// Creating an ArrayAdapter to add items to the listview mDrawerList
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
		        R.layout.drawer_list_item, getResources().getStringArray(R.array.drawer_array));


		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.drawer_list);

		mDrawerList.setAdapter(adapter);
		// Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());		
 
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle("Days Sober: " + days);//(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
       
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        // Code to create the database when run for the first time
        // and then populate the tables with data read from json file
        if (!MessageDataSource.databaseExist(this, MessageReaderDbHelper.DATABASE_NAME)) {
	        MessageDataSource ds = new MessageDataSource(this);
	        ds.open();
	        //ds.EmptyDb();
	        String result = ds.ProcessJSONFile(R.raw.newest_cleaned_data2);
	        ds.PopulateDbFromJSON(result);
	        ds.close();
        }
        
        CategoryFragment firstFragment = new CategoryFragment();
        
        // This is the top level fragment, so pass -1 as the parent
        // id, since it has no parent category
        Bundle args = new Bundle();
        args.putInt(CategoryFragment.PARENT_ID, -1);
        firstFragment.setArguments(args);

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, firstFragment).commit();
	}

	@Override
	public void onResume() {
		super.onResume();
		if (adView != null) {
			adView.resume();
		}
		
		//Get prefs
		prefs = getSharedPreferences("com.osu.cleanandsobertoolboxandroid", MODE_PRIVATE);

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
		
		
		days = prefs.getInt(DAYS_SOBER, 1);
		//Check if this is the first time the app is run
		if (prefs.getBoolean("firstrun", true) == true) {
			
			// Get the date today using Calendar object.
			Date today = Calendar.getInstance().getTime();  
			
			String todaysDate = df.format(today);

			//Set prefs for this being first date app is used
			prefs.edit().putString("LAST_USED", todaysDate).commit();
			prefs.edit().putBoolean("firstrun", false).commit();
			prefs.edit().putInt(DAYS_SOBER, 1).commit();
		} else {
			//Check how many days it has been since last use

			//Get pref value
			String lastDate = prefs.getString("LAST_USED", "This shouldn't happen");
			//Find today's date
			Date today = Calendar.getInstance().getTime();  
			//Convert to a string
			String todaysDate = df.format(today);

			Date last_date=Calendar.getInstance().getTime(), today_date=Calendar.getInstance().getTime();
			try {
				last_date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US).parse(lastDate);
				today_date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US).parse(todaysDate);
			} catch (Exception e) {
				
			}
			
			long diff = today_date.getTime() - last_date.getTime();
		    long diffHours= diff / (60 * 60 * 1000);
		    
		    
		    if (diffHours >= 24){
		    	//Different day, add a day to user's time
				days++;
		
				//Change date for prefs
				prefs.edit().putString("LAST_USED", todaysDate).commit();
				prefs.edit().putInt(DAYS_SOBER, days).commit();
		    }
		}
		
		//Check if app is starting from a notification - open up a message or open up rewards menu
		int prefstart = prefs.getInt("FromNotification", 0);
		if (prefstart == 1)
		{
			//App is launching from a rewards notification - open the Reward menu fragment
			
			//Create RewardsMenu fragment
    		RewardsFragment rewardfrag = new RewardsFragment();
    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		
    		// Replace whatever is in the fragment_container view with this fragment,
	        // and add the transaction to the back stack so the user can navigate back
    		//transaction.replace(R.id.content_frame, rewardfrag);
    		transaction.replace(R.id.content_frame, rewardfrag);
    		transaction.addToBackStack(null);
    		
    		//Replace prefstart in prefs so that it doesn't repeat this
    		prefs.edit().putInt("FromNotification", 0).commit();
    		
    		//Commit transaction
    		transaction.commit();
		}
		
		else if (prefstart == 2)
		{
			//App is launching from a daily message notification - need to display a random message
			MessageFragment messageFragment = new MessageFragment();
    		
    		Bundle args = new Bundle();
    		
    		//Get random entry from database
    		MessageDataSource ds = new MessageDataSource(this);
            ds.open();
            
            //Get random index from db
            int index = ds.getRandomIndex();
            
            ds.close();
            
            //Use the index we just got to open up a random message
    		args.putInt(MessageFragment.CONTENT_ID, index );
    		messageFragment.setArguments(args);

    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		transaction.replace(R.id.content_frame, messageFragment);
    		transaction.addToBackStack(null);

    		//Replace prefstart in prefs so that it doesn't repeat this
    		prefs.edit().putInt("FromNotification", 0).commit();
    		
    		// Commit the transaction
    		transaction.commit();
		}
		
		//Check if a notification needs to be sent out telling user to come back to the app and get a new coin or the certificate
		if ((days == 6)||(days == 29) || (days == 59) || (days == 89) || (days == 179) || (days == 273) || (days == 364))
		{
			//Construct and schedule notification for next day
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			calendar.add(Calendar.HOUR, 24);

			//Start by creating alarm that will start activity to create a notification

			//Set sharedpref so that alarm manager can know to recreate alarm when device boots off
			prefs.edit().putLong("CoinAlarmTime", calendar.getTimeInMillis() ).commit();
			
			//Retrieve AlarmManager from system
			AlarmManager alarmManager = (AlarmManager)getApplicationContext().getSystemService(getBaseContext().ALARM_SERVICE);
			
			//Create alarm id
			int id = (int) System.currentTimeMillis();
			
			//Prepare intent
			Intent intent = new Intent(this, AlarmReceiver.class);
			
			intent.putExtra("NotificationType", 0);
			intent.putExtra("Days", days);
			
			//Prepare PendingIntent
			PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
			
			//Register alarm in system, it will be sent in roughly a day
			alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
		}
		
		
	}

	@Override
	public void onPause() {
		if (adView != null) {
			adView.pause();
		}
		super.onPause();
	}


	/** Called before the activity is destroyed. */
	@Override
	public void onDestroy() {
		// Destroy the AdView.
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content view
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
        
		//Associate searchable configuration with Searchview
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

		return super.onCreateOptionsMenu(menu);
	}

	/* The click listener for ListView in the navigation drawer */
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
	}

    private void selectItem(int position) {
    	//Toast.makeText(this,  " selected", Toast.LENGTH_LONG).show();
    	//Log.i("Info", ""+position);
    	if (position == NavigationMessageFragment.disclaimer || position == NavigationMessageFragment.psychology) {
    		NavigationMessageFragment frag = new NavigationMessageFragment();
    		Bundle args = new Bundle();
    		
    		switch(position) {
    		case NavigationMessageFragment.disclaimer:
    			args.putInt(NavigationMessageFragment.DISCLAIMER, 0);
    			break;
    		case NavigationMessageFragment.psychology:
    			args.putInt(NavigationMessageFragment.DISCLAIMER, 1);
    			break;
    		default:
    			break;
    		}

	    	frag.setArguments(args);

	        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

	        // Replace whatever is in the fragment_container view with this fragment,
	        // and add the transaction to the back stack so the user can navigate back
	        transaction.replace(R.id.content_frame, frag);
	        transaction.addToBackStack(null);

	        // Commit the transaction
	        transaction.commit();
    	}
    	//Notifications menu
    	else if(position == NotificationsFragment.POSITION)
    	{
    		NotificationsFragment frag = new NotificationsFragment();
    		
    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		
	        // Replace whatever is in the fragment_container view with this fragment,
	        // and add the transaction to the back stack so the user can navigate back
	        transaction.replace(R.id.content_frame, frag);
	        transaction.addToBackStack(null);

	        // Commit the transaction
	        transaction.commit();
    	} 
    	//PayPal
    	else if (position == 1){		// Donation Position in Navigation Drawer
    		Toast.makeText(this,  " selected", Toast.LENGTH_LONG).show();
    		Log.i("Info", ""+position);
    		Intent intent = new Intent(this, PaypalDonation.class);
    		String message = "No message";
    		intent.putExtra(EXTRA_MESSAGE, message);
    		startActivity(intent);
    	}
    	//Rewards Menu
    	else if (position == RewardsFragment.position)
    	{
    		//Create RewardsMenu fragment
    		RewardsFragment rewardfrag = new RewardsFragment();
    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		
    		// Replace whatever is in the fragment_container view with this fragment,
	        // and add the transaction to the back stack so the user can navigate back
    		//transaction.replace(R.id.content_frame, rewardfrag);
    		transaction.replace(R.id.content_frame, rewardfrag);
    		transaction.addToBackStack(null);
    		
    		//Commit transaction
    		transaction.commit();
    		
    	}
    	
    	mDrawerLayout.closeDrawer(mDrawerList);
    }

    public void onArticleSelected(int position)
    {
    	//Given position from rewards menu, create the proper coin fragment or certificate fragment. 
    	//If coin fragment, pass int for choice of coin layout.
    	
    	//User has picked a coin
    	if (position < CertificateFragment.POSITION)
    	{
    		//Create coin fragment and put it in content
    		CoinFragment coinfrag = new CoinFragment();
    		Bundle args = new Bundle();
    		args.putInt("coinchoice", position);
    		coinfrag.setArguments(args);
    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		
    		//Replace and add to back stack
    		transaction.replace(R.id.content_frame, coinfrag);
    		transaction.addToBackStack(null);
    		
    		transaction.commit();
    	}
    	
    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
    	switch(item.getItemId()) {
    		case R.id.help:
    			//Toast.makeText(this,  " Help Selected", Toast.LENGTH_LONG).show();
    			DialogFragment diaFragment = HelpDialogFragment.newInstance(help_message_index.getInt(HELP_INDEX, 1));
    			diaFragment.show(getFragmentManager(), HELP_MESSAGE);
    			return true;
    		//break;
    		default:
    			if (mDrawerToggle.onOptionsItemSelected(item)) {
    		          return true;
    		        }
    		        // Handle your other action bar items...
    			return super.onOptionsItemSelected(item);
    	}
        
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
    
    //Handle toggle button on Notifications Fragment
    public void onToggleClicked (View view)
	{
    	//Check if toggle is on
		boolean on = ((ToggleButton) view).isChecked();

		
		//Need to set alarm only if button is toggled and button hasn't been toggled already
		if ((on) && (prefs.getBoolean("Toggle", false) == false))
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			calendar.add(Calendar.HOUR, 24);
			
			//Retrieve AlarmManager from system
			AlarmManager alarmManager = (AlarmManager)getApplicationContext().getSystemService(getBaseContext().ALARM_SERVICE);
			
			//Create intent and pending intent
			//Create alarm id
			int id = (int) System.currentTimeMillis();
			
			//Need to save this id in sharedprefs so alarm can be deleted
			prefs.edit().putInt("DailyId", id).commit();
					
			//Prepare intent
			Intent intent = new Intent(this, AlarmReceiver.class);
					
			//Set mode of notification
			intent.putExtra("NotificationType", 1);
					
			//Create pending intent (Need to do it here because we have to have the intent to cancel it too)
			PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),id, intent, 0);
			
			//Save toggle state in shared prefs
			prefs.edit().putBoolean("Toggle", true).commit();
			
			//Save alarm time in shared prefs for recovery
			prefs.edit().putLong("DailyNoteTime", calendar.getTimeInMillis()).commit();
			
    		//Register alarm in system
			alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    		
		}
		
		//If button is off  and the button was previously toggled true (an alarm was set)
		// We need to cancel the alarm
		else if ((on == false)  && (prefs.getBoolean("Toggle", false) == true))
		{
			//Save toggle state in shared prefs
			//Save toggle state
			prefs.edit().putBoolean("Toggle", false).commit();
			
			//Delete alarm
			//Retrieve AlarmManager from system
			AlarmManager alarmManager = (AlarmManager)getApplicationContext().getSystemService(getBaseContext().ALARM_SERVICE);
			
			//Get id from sharedprefs
			int id = prefs.getInt("DailyId", 0);
			
			//Prepare intent
			Intent intent = new Intent(this, AlarmReceiver.class);
					
			//Set mode of notification
			intent.putExtra("NotificationType", 1);
					
			//Create pending intent (Need to do it here because we have to have the intent to cancel it too)
			PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),id, intent, 0);
			
			//Cancel intent
			pendingIntent.cancel();
			
			//Cancel alarm
			alarmManager.cancel(pendingIntent);

			//Destroy alarm time int for id
			prefs.edit().remove("DailyId").commit();
			//Change alarm time in shared prefs for recovery to 0
			prefs.edit().putLong("DailyNoteTime", 0).commit();
		}
	}
    
    public void setActionBarTitle(String title){
    	getActionBar().setTitle(title);
    }    
    
}
