package com.osu.cleanandsobertoolboxandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;

public class CoinFragment extends Fragment {
	
	SharedPreferences prefs = null;
    final String DAYS_SOBER = "DAYS_SOBER";
    final static int position = 5;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
		//Get sharedprefs to check days
		prefs = this.getActivity().getSharedPreferences("com.osu.cleanandsobertoolboxaround",0);
		int days = prefs.getInt(DAYS_SOBER, 1);
		int layout = 0;
		
		//Check how many days it has been, display correct coin
		if((days >= 7) && (days < 30))
		{
			layout = R.layout.sevendayscoin_view;
		}
		else if ((days >= 30) && (days < 60))
		{
			layout = R.layout.thirtydayscoin_view;
		}
		else if ((days >= 60) && (days < 90))
		{
			layout = R.layout.sixtydayscoin_view;
		}
		else if ((days >= 90) && (days < 180))
		{
			layout = R.layout.ninetydayscoin_view;
		}
		//Can't really check what months they are, just do 180 days for 6 months
		else if ((days >= 180) && (days < 274)){
			layout = R.layout.sixmonthscoin_view;
		}
		//274 days is about 9 months
		else if ((days >= 274) && (days < 365))
		{
			layout = R.layout.ninemonthscoin_view;
		}
		else if (days >= 365)
		{
			layout = R.layout.yearcoin_view;
		}
		// Inflate the layout for this fragment with whichever coin is correct
        return inflater.inflate(layout, container, false);
		
	}


}
