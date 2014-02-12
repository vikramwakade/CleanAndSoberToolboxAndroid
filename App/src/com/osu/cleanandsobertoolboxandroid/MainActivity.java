package com.osu.cleanandsobertoolboxandroid;

import com.example.cleanandsobertoolboxandroid.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class MainActivity extends FragmentActivity 
	implements TopicsFragment.OnTopicSelectedListener,
			   SubCategoryFragment.OnSubCategorySelectedListener,
			   CategoryFragment.OnCategorySelectedListner {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_categories);
		
		CategoryFragment firstFragment = new CategoryFragment();

        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        firstFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCategorySelected(int cPosition) {
		// TODO Auto-generated method stub
		
		SubCategoryFragment secondFragment = new SubCategoryFragment();
		//secondFragment.setArguments(getIntent().getExtras());
		Bundle args = new Bundle();
        args.putInt(SubCategoryFragment.CATEGORY_POSITION, cPosition);
        secondFragment.setArguments(args);
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, secondFragment);
        transaction.addToBackStack(null);
        
        // Commit the transaction
        transaction.commit();
	}

	@Override
	public void onSubCategorySelected(int cPosition, int scPosition) {
		// TODO Auto-generated method stub
		
		TopicsFragment thirdFragment = new TopicsFragment();
		//thirdFragment.setArguments(getIntent().getExtras());
		Bundle args = new Bundle();
        args.putInt(TopicsFragment.CATEGORY_POSITION, cPosition);
        args.putInt(TopicsFragment.SUBCATEGORY_POSITION, scPosition);
        
        thirdFragment.setArguments(args);
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, thirdFragment);
        transaction.addToBackStack(null);
        
        // Commit the transaction
        transaction.commit();
	}

	@Override
	public void onTopicSelected(int cPosition, int scPosition, int tPosition) {
		// TODO Auto-generated method stub
		
		MessageFragment messageFragment = new MessageFragment();
		Bundle args = new Bundle();
		args.putInt(MessageFragment.C_POSITION, cPosition);
		args.putInt(MessageFragment.SC_POSITION, scPosition);
        args.putInt(MessageFragment.T_POSITION, tPosition);
        messageFragment.setArguments(args);
        
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, messageFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
	}
	
}
