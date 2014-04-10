package com.osu.cleanandsobertoolboxandroid;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

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
	private static int SPLASH_TIME_OUT = 3000;
	String url = "http://www.cleanandsobertoolbox.com/";
	String stringURLArray[] = {"disclaimer.json", "psychology.json", "categories.json", "messages.json"};
	
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
        	for(int i = 0; i<stringURLArray.length; ++i) {
        		Log.i("SPLASH+INFO", url + stringURLArray[i]);
        		new DownloadFileTask().execute(url + stringURLArray[i]);
        	}
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

	// TODO: Use this AnyncTask to download the JSON from the server
	// when it is ready.
	private class DownloadFileTask extends AsyncTask<String, Void, String> {
    	MessageDataSource ds = new MessageDataSource(getApplicationContext());
    	
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
    		updateData(data);
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
 			navigationMessages.edit().putBoolean("updateDb", true).commit();
 		} else if (text.startsWith(url+stringURLArray[3])) {	// Messages
 			int urlLength = (url+stringURLArray[3]).length();
 			navigationMessages.edit().putString("messages", text.substring(urlLength)).commit();
 			navigationMessages.edit().putBoolean("updateDb", true).commit();
 		}
 	}

}
