package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NavigationMessageFragment extends Fragment{
	final static int disclaimer = 1; //position
	final static int psychology = 3;
	final static String DISCLAIMER = "disclaimer";
	int curPosition = -1;

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
        article.setText(Data.NavigationMessage[position]);
        curPosition = position;
            
    }
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(DISCLAIMER, curPosition);
    }
    
}