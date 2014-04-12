package com.osu.cleanandsobertoolboxandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class HelpDialogFragment extends DialogFragment{
	
	String message = "";
	static String[] helpMessages = {
    	"\" Two ways to use App:\n\n1. BEST WAY:  Touch the question that may apply now. Then touch a question from the list that appears. Finally, touch the title of a message from the list that appears. If the first message does not speak to you, go back and choose another. \n\n\t\t\tOR\n\n2.  Touch the toolbox icon in the upper left corner. Touch \"Search.\" Type one word that describes your situation. Words include \"angry, fear, lonely, alone, resentful, anxious, regret, frustrated, gratitude, love, relapse, using, craving, urge, bad, spirituality, change, stress, worry, help, and many more,…Then touch messages that may apply.\"",
    	"Touch a question that may apply. Quickly scroll through the list to find one.",
    	"Touch a title that speaks to you. Quickly scroll through the list to find one. After reading the message that appears, if you need more than one message to change your troubled thinking to healing thinking, touch another title for a new message."
    };
	
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
		message = helpMessages[num];
		
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
