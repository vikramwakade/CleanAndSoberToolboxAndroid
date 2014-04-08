package com.osu.cleanandsobertoolboxandroid;

import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent paramIntent)
	{
		//Request Notification Manager
		NotificationManager notManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		//Create intent for notification
		Intent intent = new Intent(context, MainActivity.class);
		
		//Create PendingIntent for Notification
		PendingIntent pIntent = PendingIntent.getActivity(context, 0 ,intent, 0);
		
		//Get extras from param intent
		int type = paramIntent.getIntExtra("NotificationType", 1);
		int days = paramIntent.getIntExtra("Days", 7);
		
		//Create taskstackbuilder (need this for daily message)
		TaskStackBuilder taskBuilder = TaskStackBuilder.create(context);
		
		//Create Notification Builder
		NotificationCompat.Builder noti = new NotificationCompat.Builder(context);
		
		if (type == 0)
		{
			//This is a notification for the user receiving a new coin/certificate
			noti.setContentTitle("Receive your reward!");
			
			//Check number of days, use appropriate coin as image
			switch(days)
			{
			case 6:
				noti.setSmallIcon(R.drawable.sevendaysicon);
				break;
			case 29:
				noti.setSmallIcon(R.drawable.thirtydaysicon);
				break;
			case 59:
				noti.setSmallIcon(R.drawable.sixtydaysicon);
				break;
			case 89:
				noti.setSmallIcon(R.drawable.ninetydaysicon);
				break;
			case 179:
				noti.setSmallIcon(R.drawable.sixmonthsicon);
				break;
			case 273:
				noti.setSmallIcon(R.drawable.ninemonthsicon);
				break;
			case 364:
				noti.setSmallIcon(R.drawable.certicon);
				break;
				
			}
			//Text of notification
			noti.setContentText("Congratulations, you've received a new reward! Please visit the app to see your new reward!");
			//noti.addAction(R.drawable.ic_launcher, "View Rewards", pIntent);
			noti.setContentIntent(pIntent);
			
			//Send notification with unique id
			//Get current time to generate id
			//Get calendar
			Calendar calendar = Calendar.getInstance();
			int id = (int) System.currentTimeMillis();
			
			noti.setAutoCancel(true);
			notManager.notify(id,noti.build());
			
		}
		
		else if (type == 1)
		{
			//This is a daily message notification
		}
	}

}
