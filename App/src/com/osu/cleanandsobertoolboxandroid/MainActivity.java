package com.osu.cleanandsobertoolboxandroid;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends FragmentActivity 
	implements /*TopicsFragment.OnTopicSelectedListener,
			   SubCategoryFragment.OnSubCategorySelectedListener,*/
			   CategoryFragment.OnCategorySelectedListner {


	public final static String EXTRA_MESSAGE = "com.example.cbt.DONATION";
	
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    
    /** The view to show the ad. */
    private AdView adView;
 
    /* Your ad unit id. Replace with your actual ad unit id. */
    private static final String AD_UNIT_ID = "INSERT_YOUR_AD_UNIT_ID_HERE";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_categories);

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
                getActionBar().setTitle("Days Sober 20");//(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
       
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        // Code to create the database when run for the first time
        // and then populate the tables with data read from json file
        if (!MessageDataSource.databaseExist(this, MessageReaderDbHelper.DATABASE_NAME))
        {
	        MessageDataSource ds = new MessageDataSource(this);
	        ds.open();
	        //ds.EmptyDb();
	        String result = ds.ProcessJSONFile(R.raw.newest_cleaned_data);
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
        //update the main content by replacing fragments
        //TODO:
        //mDrawerLayout.closeDrawer(mDrawerList);
    	Toast.makeText(this,  " selected", Toast.LENGTH_LONG).show();
    	Log.i("Info", ""+position);
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
    	} else if (position == 1){
    		Toast.makeText(this,  " selected", Toast.LENGTH_LONG).show();
    		Log.i("Info", ""+position);
    		Intent intent = new Intent(this, PaypalDonation.class);
    		String message = "No message";
    		intent.putExtra(EXTRA_MESSAGE, message);
    		startActivity(intent);
    	}
    	mDrawerLayout.closeDrawer(mDrawerList);
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
        if (mDrawerToggle.onOptionsItemSelected(item)) {
          return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
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
