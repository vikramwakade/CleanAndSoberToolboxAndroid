package com.osu.cleanandsobertoolboxandroid;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity 
	implements TopicsFragment.OnTopicSelectedListener,
			   SubCategoryFragment.OnSubCategorySelectedListener,
			   CategoryFragment.OnCategorySelectedListner {


    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    
    /** The view to show the ad. */
    //private AdView adView;
 
    /* Your ad unit id. Replace with your actual ad unit id. */
    //private static final String AD_UNIT_ID = "INSERT_YOUR_AD_UNIT_ID_HERE";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_categories);
		
		mTitle = mDrawerTitle = getTitle();
		//Log.i("INFO",mPlanetTitles[0]);
		// Creating an ArrayAdapter to add items to the listview mDrawerList
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
		        R.layout.drawer_list_item, getResources().getStringArray(R.array.drawer_array));
		
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.drawer_list);
		
		//mDrawerList.setAdapter(new ArrayAdapter<String>(this,
        //        R.layout.drawer_list_item, mPlanetTitles));
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
                getActionBar().setTitle(mDrawerTitle);
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
	        ds.EmptyDb();
	        String result = ds.ProcessJSONFile(R.raw.finalized_json);
	        ds.PopulateDbFromJSON(result);
	        ds.close();
        }
        
		CategoryFragment firstFragment = new CategoryFragment();

        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        firstFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, firstFragment).commit();
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
	public void onCategorySelected(int categoryId) {
		// TODO Auto-generated method stub
		
		SubCategoryFragment secondFragment = new SubCategoryFragment();
		//secondFragment.setArguments(getIntent().getExtras());
		Bundle args = new Bundle();
        args.putInt(SubCategoryFragment.CATEGORY_ID, categoryId);
        secondFragment.setArguments(args);
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.content_frame, secondFragment);
        transaction.addToBackStack(null);
        
        // Commit the transaction
        transaction.commit();
	}

	@Override
	public void onSubCategorySelected(int categoryId, int subCategoryId) {
		// TODO Auto-generated method stub
		
		TopicsFragment thirdFragment = new TopicsFragment();
		//thirdFragment.setArguments(getIntent().getExtras());
		Bundle args = new Bundle();
        args.putInt(TopicsFragment.CATEGORY_ID, categoryId);
        args.putInt(TopicsFragment.SUBCATEGORY_ID, subCategoryId);
        
        thirdFragment.setArguments(args);
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.content_frame, thirdFragment);
        transaction.addToBackStack(null);
        
        // Commit the transaction
        transaction.commit();
	}

	@Override
	public void onTopicSelected(int position) {
		// TODO Auto-generated method stub
		
		MessageFragment messageFragment = new MessageFragment();
		Bundle args = new Bundle();
        args.putInt(MessageFragment.CONTENT_POSITION, position);
        messageFragment.setArguments(args);
        
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.content_frame, messageFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
	}
	
}
