package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NavigationMessageFragment extends Fragment{
	final static int disclaimer = 1; //position
	final static int psychology = 3;
	final static String DISCLAIMER = "disclaimer";
	final static String KEY = "NAVIGATION_MESSAGE";
	int curPosition = -1;
	
	final String[] NavigationMessage = {
		"Unless otherwise indicated, the quotes and sayings in this App have no known specific author and are taken from research, the author's personal experience, training, and 12 step meetings. If anyone believes a quote or saying or any other mark or logo is not in the public domain, please contact the author immediately at the address provided. None of the information herein creates a counselor patient relationship or should substitute for any other forms of therapy. The author is not liable for any misinterpretations or any injuries claimed from the use of this App. This App provides educational information which may or may not benefit the user, and it is offered as one form of advice and not unequivocal instruction. Copyright 2014  by Clean and Sober Toolbox, Inc. All rights reserved. No part of this App shall be reproduced, stored in a retrieval system, or transmitted by any means, electronic, mechanical, photocopying, recording, or otherwise, without written permission from the publisher. No patent, trademark, copyright or other  liability is assumed with respect to the use of the information contained herein. Although every precaution has been taken in the preparation of this App, the publisher and author assume no responsibility for errors or omissions. Neither is any liability assumed for damages resulting from the use of information contained herein. The author and publisher specifically disclaim any responsibility for any liability, loss, or risk, personal or otherwise, which is incurred as a consequence, directly or indirectly, of the use and application of any of the contents of this App. This App has been registered with the United States Copyright Office.",
		"Every addict has two brains: a \"dirty brain\" and a \"clean brain.\" The \"dirty brain\" wants to drink, use, or someway act out which ultimately causes trouble. The \"clean brain\" wants to stay clean and sober and free from trouble. This app causes us to use our \"clean brain\" particularly when our \"dirty brain\" is threatening. It substitutes the threatening thought with a truthful, rescuing thought. It changes our perception of a situation from something distressful to something manageable and even positive. It does this with unprecedented ease and speed. The result of changing messages is feeling better, beating cravings, and staying sober."
	};

	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setHasOptionsMenu(true);
    	((MainActivity) getActivity()).setActionBarTitle("Your title");
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
        	curPosition = savedInstanceState.getInt(DISCLAIMER);
        }

        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.message_view, container, false);
    }
	
	@Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
        	updateMessageView(args.getInt(DISCLAIMER));
        } else if (curPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
        	updateMessageView(curPosition);
        }
	}
    
	public void updateMessageView(int position) {
		TextView article = (TextView) getActivity().findViewById(R.id.message);
        article.setMovementMethod(new ScrollingMovementMethod());
        String message = SplashScreenActivity.navigationMessages.getString(KEY+position, NavigationMessage[position]); 
        //article.setText(Html.fromHtml(Data.NavigationMessage[position]));
        article.setText(Html.fromHtml(message));
        curPosition = position;
            
    }
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(DISCLAIMER, curPosition);
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

	@Override
	public void onResume() {
		super.onResume();
	}
}
