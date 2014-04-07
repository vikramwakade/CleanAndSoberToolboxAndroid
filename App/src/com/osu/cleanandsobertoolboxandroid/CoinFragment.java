package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.SharedPreferences;

public class CoinFragment extends Fragment {

    

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
		
		//Get arguments
		Bundle args = getArguments();
		
		//Grab int
		int coinchoice = args.getInt("coinchoice");
		
		//Initialize layout choice
		int layout = 0;
		
		//Check which coin it should be, display correct coin
		switch(coinchoice){
		case 0:
			layout = R.layout.sevendayscoin_view;
			break;
		case 1:
			layout = R.layout.thirtydayscoin_view;
			break;
		case 2:
			layout = R.layout.sixtydayscoin_view;
			break;
		case 3:
			layout = R.layout.ninetydayscoin_view;
			break;
		case 4:
			layout = R.layout.sixmonthscoin_view;
			break;
		case 5:
			layout = R.layout.ninemonthscoin_view;
			break;
		case 6:
			layout = R.layout.yearcoin_view;
			break;
		default:
			break;
		}
			
		// Inflate the layout for this fragment with whichever coin is correct
        return inflater.inflate(layout, container, false);
		
	}


}
