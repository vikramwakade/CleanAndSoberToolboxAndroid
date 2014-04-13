package com.osu.cleanandsobertoolboxandroid;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;



public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent paramIntent)
	{
		
		//Open prefs to add things
		SharedPreferences prefs = context.getSharedPreferences("com.osu.cleanandsobertoolboxandroid", 0);
				
		//Request Notification Manager
		NotificationManager notManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		
		//Get extras from param intent
		int type = paramIntent.getIntExtra("NotificationType", 1);
		int days = paramIntent.getIntExtra("Days", 7);
		
		
		//Create Notification Builder
		NotificationCompat.Builder noti = new NotificationCompat.Builder(context);
	
		
		if (type == 0)
		{

			//This is a notification for the user receiving a new coin/certificate
			noti.setContentTitle("Receive your reward!");
			
			//Add int extra for letting main activity know it's starting from notification
			//intent.putExtra("FromNotification", 1);
			prefs.edit().putInt("FromNotification", 1).commit();
			
			//Send notification with unique id
			//Get current time to generate id
			int id = (int) System.currentTimeMillis();
			
			//Text of notification
			noti.setContentText("Visit the app to receive your reward!");
			
			//Create intent for notification
			Intent intent = new Intent(context, MainActivity.class);
			
			//Create PendingIntent for Notification
			PendingIntent pIntent = PendingIntent.getActivity(context, 0 ,intent, 0);
			
			//Set intent for notification
			noti.setContentIntent(pIntent);

			
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
			
			
			noti.setAutoCancel(true);
			notManager.notify(id,noti.build());
			
		}
		
		else if (type == 1)
		{
			//This is a daily message notification
			noti.setContentTitle("Your daily message");
			
			//Add special check to intent so that main activity knows what to do
			prefs.edit().putInt("FromNotification", 2).commit();
			
			//Get current time to generate id
			int id = (int)System.currentTimeMillis();
			
			//Set text
			noti.setContentText("View your daily message!");
					
			//Create intent for notification
			Intent intent2 = new Intent(context, MainActivity.class);
			
			//Create PendingIntent for Notification
			PendingIntent pIntent2 = PendingIntent.getActivity(context, 0 ,intent2, 0);
			
			//Set intent for notification
			noti.setContentIntent(pIntent2);
			
			//Set an icon
			noti.setSmallIcon(R.drawable.ic_launcher);
			
			noti.setAutoCancel(true);
			notManager.notify(id,noti.build());
		}
	}
	

}
