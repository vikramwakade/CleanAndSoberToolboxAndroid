package com.osu.cleanandsobertoolboxandroid;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	//Splash screen timer
	private static int SPLASH_TIME_OUT = 3000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
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
	private class DownloadFileTask extends AsyncTask<String, Void, Void> {
    	MessageDataSource ds = new MessageDataSource(getApplicationContext());
    	
    	@Override
		protected Void doInBackground(String... urls) {
    		// params comes from the execute() call: params[0] is the url.
			try {
				String data = downloadUrl(urls[0]);
				
				return null;
		    } catch (IOException e) {
		        // "Unable to retrieve web page. URL may be invalid.";
		    	return null;
		    }
    	}
    	
    	@Override
    	protected void onPostExecute(Void data) {
    		// TODO: start the main app activity here
    	}
    }
    
    // Given a URL, establishes an HttpUrlConnection and retrieves
 	// the web page content as a InputStream, which it returns as
 	// a string.
 	private String downloadUrl(String myurl) throws IOException {
 	    InputStream is = null;
 	    // Only display the first 500 characters of the retrieved
 	    // web page content.
 		int len = 500;
 	  
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
 			return contentAsString;
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

}
