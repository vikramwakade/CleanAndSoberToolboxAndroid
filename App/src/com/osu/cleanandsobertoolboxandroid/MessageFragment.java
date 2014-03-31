package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {
	final static String CONTENT_ID = "contentId";

    int currentContentId = -1;
    MessageDataSource ds;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
        	currentContentId = savedInstanceState.getInt(CONTENT_ID);
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
            updateArticleView(args.getInt(CONTENT_ID));
        } else if (currentContentId != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(currentContentId);
        }
    }

    // TODO: Need some styling to display the content
    public void updateArticleView(int contentId) {
        TextView article = (TextView) getActivity().findViewById(R.id.message);
        article.setMovementMethod(new ScrollingMovementMethod());
        
        ds = new MessageDataSource(getActivity());
        ds.open();
        
        String content = ds.getMessage(getActivity(), contentId);  
        
        ds.close();
        
        article.setText(Html.fromHtml(content));
        currentContentId = contentId;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(CONTENT_ID, currentContentId);
    }
}