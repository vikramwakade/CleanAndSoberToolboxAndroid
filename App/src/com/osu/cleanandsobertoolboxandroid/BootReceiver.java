package com.osu.cleanandsobertoolboxandroid;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.Calendar;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive (Context context, Intent paramIntent)
	{
		if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
          //Reset alarms because device booted off and on
			SharedPreferences prefs = context.getSharedPreferences("com.osu.cleanandsobertoolboxandroid", 0);
			
			//Check if a coin alarm is set
			if (prefs.getLong("CoinAlarmTime", 0) > 0)
			{
				long time = prefs.getLong("CoinAlarmTime", 0);
				int days = prefs.getInt("DAYS_SOBER", 0);
				//Reset an alarm for that time
				//Retrieve AlarmManager from system
				AlarmManager alarmManager = (AlarmManager)context.getApplicationContext().getSystemService(context.ALARM_SERVICE);
				
				//Create alarm id
				int id = (int) time;
				
				//Prepare intent
				Intent intent = new Intent(context, AlarmReceiver.class);
				
				intent.putExtra("NotificationType", 0);
				intent.putExtra("Days", days);
				
				//Prepare PendingIntent
				PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(),id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				
				//Register alarm in system, it will be sent in roughly a day
				alarmManager.set(AlarmManager.RTC, time, pendingIntent);
			}
			
			//Check if daily notifications are set
			if (prefs.getLong("DailyNoteTime", 0) > 0)
			{
				long time = prefs.getLong("DailyNoteTime", 0);
				int days = prefs.getInt("DAYS_SOBER", 0);
				
				//Retrieve AlarmManager from system
				AlarmManager alarmManager = (AlarmManager)context.getApplicationContext().getSystemService(context.ALARM_SERVICE);
				
				//Create alarm id
				int id = (int) time;
				
				//Prepare intent
				Intent intent = new Intent(context, AlarmReceiver.class);
				
				intent.putExtra("NotificationType", 0);
				intent.putExtra("Days", days);
				
				//Prepare PendingIntent
				PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(),id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				
				
				//Register alarm in system
				alarmManager.setRepeating(AlarmManager.RTC, time, AlarmManager.INTERVAL_DAY, pendingIntent);
			}
     }
	}
}

