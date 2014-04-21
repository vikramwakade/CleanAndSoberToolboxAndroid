package com.osu.cleanandsobertoolboxandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

public class HelpDialogFragment extends DialogFragment{
	
	String message = "";
	public static String HELP = "helpMessages";
	
	static String[] helpMessages = {
<<<<<<< HEAD
		"<div style=\"margin: 0px 0px 1.25px; padding: 0px;\"><span dir=\"ltr\"><span style=\"font-size:13px\">Two ways to use:</span></span></div>" +
		"<div style=\"margin: 0px 0px 1.25px; padding: 0px;\"><span dir=\"ltr\"><span style=\"font-size:13px\">1.<strong> BEST WAY</strong>:&nbsp;&nbsp;Touch a question, touch question on new screen, touch a message title, then read your message. Repeat if you need more.</span></span><span dir=\"ltr\" style=\"line-height:1.6\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span><span dir=\"ltr\" style=\"line-height:1.6\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong>OR</strong></span></div>" +
		"<div style=\"margin: 0px 0px 1.25px; padding: 0px;\"><span style=\"line-height:1.6\">2. &nbsp;Type&nbsp;</span><strong style=\"line-height:1.6\">one</strong><span style=\"line-height:1.6\">&nbsp;word that describes your current feelings. Examples of such words might be &quot;angry, fear, lonely, resentful, </span><strong style=\"line-height:1.6\">and many more</strong><span style=\"line-height:1.6\">&hellip;Then&nbsp;touch message title.</span></div>",
		"\u003Cp\u003ETouch a question that may apply. Quickly scroll through the list to find one.\u003C/p\u003E\r\n",
		"\u003Cp\u003ETouch a title that speaks to you. Quickly scroll through the list to find one. After reading the message that appears, if you need more than one message to change your troubled thinking to healing thinking, touch another title for a new message.\u003C/p\u003E\r\n"
	};
=======
    	"\" Two ways to use App:\n\n1. BEST WAY:  Touch the question that applies now. Then touch a question from the list that appears. Finally, touch the title of a message from the list that appears. If the first message does not speak to you, go back and choose another. \n\nOR\n\n2.  \nTouch the toolbox icon in the upper left corner. Touch \"Search.\" Type one word that describes your situation. Words include \"angry, fear, lonely, alone, resentful, anxious, regret, frustrated, gratitude, love, relapse, using, craving, urge, bad, spirituality, change, stress, worry, help\", and many more,…Then touch messages that may apply.",
    	"Touch a question that may apply. Quickly scroll through the list to find one.",
    	"Touch a title that speaks to you. Quickly scroll through the list to find one. After reading the message that appears, if you need more than one message to change your troubled thinking to healing thinking, touch another title for a new message."
    };
>>>>>>> upstream/master
	
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
		message = SplashScreenActivity.navigationMessages.getString(HELP+num, helpMessages[num]);
		//message = helpMessages[num];
		
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(Html.fromHtml(message))
               .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
