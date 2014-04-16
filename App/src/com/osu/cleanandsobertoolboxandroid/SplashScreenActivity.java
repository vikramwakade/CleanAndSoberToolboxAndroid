package com.osu.cleanandsobertoolboxandroid;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class SplashScreenActivity extends Activity {

	//Splash screen timer
	private static int SPLASH_TIME_OUT = 1000;
	String url = "http://www.cleanandsobertoolbox.com/";
	String version = "version";
	String stringURLArray[] = {"disclaimer.json", "about.json", "categories.json", "messages.json", "help.json"};
	
	public static SharedPreferences navigationMessages = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		navigationMessages = getSharedPreferences("com.osu.cleanandsobertoolboxandroid", MODE_PRIVATE);
		
        ConnectivityManager connMgr = (ConnectivityManager) 
            getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
        	new DownloadFileTask().execute(url + version);
        } else {
        	Toast.makeText(this, "No network connection available.", Toast.LENGTH_LONG).show();
        }
        
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run(){
				//Start main app activity
				Intent i = new Intent(SplashScreenActivity.this,MainActivity.class);
				startActivity(i);
				
				//Close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

	// AnyncTask to download the JSON from the server
	private class DownloadFileTask extends AsyncTask<String, Void, String> {
		
    	@Override
		protected String doInBackground(String... urls) {
    		// params comes from the execute() call: params[0] is the url.
			try {
				return downloadUrl(urls[0]);
		    } catch (IOException e) {
		    	return "Unable to retrieve web page. URL may be invalid.";
		    }
    	}
    	
    	@Override
    	protected void onPostExecute(String data) {
    		if (data.startsWith(url + version)) {
     			int urlLength = (url + version).length();
     			String appVersion = navigationMessages.getString(version, "-1");
     			String serverVersion = data.substring(urlLength);
     			if (!appVersion.equals(serverVersion)) {
     				for(int i = 0; i<stringURLArray.length; ++i) {
     					new DownloadFileTask().execute(url + stringURLArray[i]);
            		}
     				navigationMessages.edit().putString(version, data.substring(urlLength)).commit();
     			}
     		}
    		else {
    			updateData(data);
    		}
    	}
    }
    
    // Given a URL, establishes an HttpUrlConnection and retrieves
 	// the web page content as a InputStream, which it returns as
 	// a string.
 	private String downloadUrl(String myurl) throws IOException {
 	    InputStream is = null;
 	    
 	    // Buffer size of 1KB
 		int len = 1024;
 	  
 		try {
 			URL url = new URL(myurl);
 			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
 			conn.setReadTimeout(10000 /* milliseconds */);
 			conn.setConnectTimeout(15000 /* milliseconds */);
 			conn.setRequestMethod("GET");
 			conn.setDoInput(true);
 			// Starts the query
 			conn.connect();
 			int response = conn.getResponseCode();
 			System.out.println(response);
 			is = conn.getInputStream();
 			// Convert the InputStream into a string
 			String contentAsString = readIt(is, len);
 			return (myurl+contentAsString);
 		    // Makes sure that the InputStream is closed after the app is
 		    // finished using it.
 	     } finally {
 	    	 if (is != null) {
 	    		 is.close();
 	         } 
 	     }
 	}
 	
 	// Reads an InputStream and converts it to a String.
 	public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
 		final char[] buffer = new char[len];
 		final StringBuilder out = new StringBuilder();
 		
 	    Reader reader = new InputStreamReader(stream, "UTF-8");        
 	    for (;;) {
 	    	int rsz = reader.read(buffer, 0, buffer.length);
 	    	if (rsz < 0)
 	           break;
 	    	out.append(buffer, 0, rsz);
 	    }
 	    return new String(out.toString());
 	}
 	
 	public void updateData(String text) {
 		if (text.startsWith(url+stringURLArray[0])) {  //Disclaimer
 			int urlLength = (url+stringURLArray[0]).length();
 			navigationMessages.edit().putString(NavigationMessageFragment.KEY+'0', text.substring(urlLength)).commit();
 		} else if (text.startsWith(url+stringURLArray[1])) {   // Psychology
 			int urlLength = (url+stringURLArray[1]).length();
 			navigationMessages.edit().putString(NavigationMessageFragment.KEY+'1', text.substring(urlLength)).commit();
 		} else if (text.startsWith(url+stringURLArray[2])) {	// Categories
 			int urlLength = (url+stringURLArray[2]).length();
 			navigationMessages.edit().putString("categories", text.substring(urlLength)).commit();
 			navigationMessages.edit().putBoolean("updateCategories", true).commit();
 			// update database only if messages have been downloaded 
 			if (navigationMessages.getBoolean("updateMessages", false))
 				navigationMessages.edit().putBoolean("updateDb", true).commit();
 		} else if (text.startsWith(url+stringURLArray[3])) {	// Messages
 			int urlLength = (url+stringURLArray[3]).length();
 			navigationMessages.edit().putString("messages", text.substring(urlLength)).commit();
 			navigationMessages.edit().putBoolean("updateMessages", true).commit();
 			// update database only if categories have been downloaded
 			// one of the two will be set before the other, so updateDb 
 			// will be set only once!
 			if (navigationMessages.getBoolean("updateCategories", false))
 				navigationMessages.edit().putBoolean("updateDb", true).commit();
 		} else if (text.startsWith(url+stringURLArray[4])) {  //Help
 			int urlLength = (url+stringURLArray[4]).length();
 			String helpJson = text.substring(urlLength);
 			try {
	 			JSONTokener tokener = new JSONTokener(helpJson);
	            JSONObject root = new JSONObject(tokener);
	            String response_help1 = root.getString("help1");
	            String response_help2 = root.getString("help2");
	            String response_help3 = root.getString("help3");
	            
	            navigationMessages.edit().putString(HelpDialogFragment.HELP+'0', response_help1).commit();
	            navigationMessages.edit().putString(HelpDialogFragment.HELP+'1', response_help2).commit();
	            navigationMessages.edit().putString(HelpDialogFragment.HELP+'2', response_help3).commit();
	            
	            
 			} catch (JSONException e) {
 				 Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
 			}
 			//navigationMessages.edit().putString(NavigationMessageFragment.KEY+'0', text.substring(urlLength)).commit();
 		}
 	}

}
