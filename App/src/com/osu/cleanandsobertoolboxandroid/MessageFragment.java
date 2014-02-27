package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {
	final static String TOPIC_POSITION = "tPosition";
	final static String SUBCATEGORY_POSITION = "scPosition";
	final static String CATEGORY_POSITION = "cPosition";
    int tCurrentPosition = -1;
    int scCurrentPosition = -1;
    int cCurrentPosition = -1;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            tCurrentPosition = savedInstanceState.getInt(TOPIC_POSITION);
            scCurrentPosition = savedInstanceState.getInt(SUBCATEGORY_POSITION);
            cCurrentPosition = savedInstanceState.getInt(CATEGORY_POSITION);
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
            updateArticleView(args.getInt(TOPIC_POSITION), args.getInt(SUBCATEGORY_POSITION), args.getInt(CATEGORY_POSITION));
        } else if (tCurrentPosition != -1 && scCurrentPosition != -1 && cCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(tCurrentPosition, scCurrentPosition, cCurrentPosition);
        }
    }

    public void updateArticleView(int tPosition, int scPosition, int cPosition) {
        TextView article = (TextView) getActivity().findViewById(R.id.message);
        article.setMovementMethod(new ScrollingMovementMethod());
        article.setText(Data.Articles[cPosition][scPosition][tPosition]);
        tCurrentPosition = tPosition;
        scCurrentPosition = scPosition;
        cCurrentPosition = cPosition;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(TOPIC_POSITION, tCurrentPosition);
        outState.putInt(SUBCATEGORY_POSITION, scCurrentPosition);
        outState.putInt(CATEGORY_POSITION, cCurrentPosition);
    }
}
