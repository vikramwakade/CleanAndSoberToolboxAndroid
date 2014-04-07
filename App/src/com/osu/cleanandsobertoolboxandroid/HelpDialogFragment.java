package com.osu.cleanandsobertoolboxandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class HelpDialogFragment extends DialogFragment{
	
	String message = "";
	public static HelpDialogFragment newInstance(int num) {
		HelpDialogFragment f = new HelpDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		int num = getArguments().getInt("num");
		message = Data.helpMessages[num];
		
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
               .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
