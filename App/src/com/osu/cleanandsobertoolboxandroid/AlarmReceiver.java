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
		
		
		//Get extras from param intent
		int type = paramIntent.getIntExtra("NotificationType", 1);
		int days = paramIntent.getIntExtra("Days", 7);
		
		
		//Create Notification Builder
		NotificationCompat.Builder noti = new NotificationCompat.Builder(context);
		
		if (type == 0)
		{
			//Create intent for notification
			Intent intent = new Intent(context, MainActivity.class);
			
			//Add int extra for letting main activity know it's starting from notification
			intent.putExtra("FromNotification", 1);
			
			//Create PendingIntent for Notification
			PendingIntent pIntent = PendingIntent.getActivity(context, 0 ,intent, 0);
			
			//This is a notification for the user receiving a new coin/certificate
			noti.setContentTitle("Receive your reward!");
			
			//Check number of days, use appropriate coin as image
			switch(days)
			{
			case 2:
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
			noti.setContentText("Congratulations, you've received a new reward!");
			
			noti.setContentIntent(pIntent);
			
			//Send notification with unique id
			//Get current time to generate id

			int id = (int) System.currentTimeMillis();
			
			noti.setAutoCancel(true);
			notManager.notify(id,noti.build());
			
		}
		
		else if (type == 1)
		{
			//This is a daily message notification
			noti.setContentTitle("Your daily message");
			noti.setAutoCancel(true);
			
			int id = (int)System.currentTimeMillis();
			
			//Set text
			noti.setContentText("View your daily message!");
			
			//Create intent for notification
			Intent intent2 = new Intent(context, MainActivity.class);
			
			//Add special check to intent so that main activity knows what to do
			intent2.putExtra("FromNotification", 2);
			
			//Create PendingIntent for Notification
			PendingIntent pIntent2 = PendingIntent.getActivity(context, 0 ,intent2, 0);
			
			//Set intent
			noti.setContentIntent(pIntent2);
			
			notManager.notify(id,noti.build());
		}
	}

}
