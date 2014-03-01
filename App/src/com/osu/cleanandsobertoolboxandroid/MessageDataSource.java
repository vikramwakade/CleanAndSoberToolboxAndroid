package com.osu.cleanandsobertoolboxandroid;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.osu.cleanandsobertoolboxandroid.MessageDbContract.*;

public class MessageDataSource {
	private SQLiteDatabase database;
	private MessageReaderDbHelper mDbHelper;
	private Context context;
	
	public MessageDataSource(Context context) {
		this.context = context;
		mDbHelper = new MessageReaderDbHelper(context);
	}
	
	public void open() throws SQLException {
	    database = mDbHelper.getWritableDatabase();
	}

	public void close() {
		mDbHelper.close();
	}
	
	// Read the JSON file and return its string representation
	public String ProcessJSONFile(int fileId) {
		InputStream is = null;
		String result = null;
	    try {
	    	is = context.getResources().openRawResource(fileId);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
	        StringBuilder sb = new StringBuilder();

	        String line = null;
	        while ((line = reader.readLine()) != null)
	        {
	            sb.append(line + "\n");
	        }
	        result = sb.toString();
	        reader.close();
	    } catch (Exception e) { 
	    	e.printStackTrace();
	    }
	    finally {
	        try{if(is != null) is.close();} catch(Exception squish){}
	    }
	    
	    return result;
	}
	
	// Populate the database from the JSON passed as string
	public void PopulateDbFromJSON(String result) {
	    try {
	    	JSONObject jObject = new JSONObject(result);
	    	
		    JSONArray messages = jObject.getJSONArray("messages");
		    for (int i = 0; i < messages.length(); i++)
		    {
		    	ContentValues values = new ContentValues();
		    	JSONObject message = messages.getJSONObject(i);
		    	values.put(MessageEntry.COLUMN_NAME_ENTRY_ID, 
		    			message.getInt("identifier"));
		    	values.put(MessageEntry.COLUMN_NAME_TITLE,
		    			message.getString("title"));
		    	values.put(MessageEntry.COLUMN_NAME_MESSAGE,
		    			message.getString("message"));
		    	values.put(MessageEntry.COLUMN_NAME_TODO,
		    			message.getString("todo"));
		    	
		    	// Insert the new row, returning the primary key value of the new row
			    database.insert(
			    		MessageEntry.TABLE_NAME,
			    		null,
			    		values);
		    }
		    
		    JSONObject structure = jObject.getJSONObject("structure");
		    JSONArray categories = structure.getJSONArray("list");
		    System.out.println("Total categories = " + categories.length());
		    for(int i = 0; i < categories.length(); i++)
		    {
		    	ContentValues values = new ContentValues();
		    	JSONObject category = categories.getJSONObject(i);
		    	values.put(CategoryEntry.COLUMN_NAME_ENTRY_ID,
		    			category.getInt("identifier"));
		    	values.put(CategoryEntry.COLUMN_NAME_TITLE,
		    			category.getString("title"));
		    	
		    	database.insert(CategoryEntry.TABLE_NAME, null, values);
		    	
		    	JSONArray subcategories = category.getJSONArray("list");
		    	for(int j = 0; j < subcategories.length(); j++)
		    	{
		    		values = new ContentValues();
		    		JSONObject subcategory = subcategories.getJSONObject(j);
		    		values.put(SubCategoryEntry.COLUMN_NAME_CATEGORY_ID,
		    				category.getInt("identifier"));
		    		values.put(SubCategoryEntry.COLUMN_NAME_ENTRY_ID,
		    				subcategory.getInt("identifier"));
		    		values.put(SubCategoryEntry.COLUMN_NAME_TITLE,
		    				subcategory.getString("title"));
		    		
		    		database.insert(SubCategoryEntry.TABLE_NAME, null, values);
		    		
		    		JSONArray contents = subcategory.getJSONArray("list");
		    		for(int k = 0; k < contents.length(); k++)
		    		{
		    			values = new ContentValues();
		    			JSONObject content = contents.getJSONObject(k);
		    			values.put(ContentEntry.COLUMN_NAME_SUBCATEGORY_ID,
		    					subcategory.getInt("identifier"));
		    			values.put(ContentEntry.COLUMN_NAME_ENTRY_ID,
		    					content.getInt("identifier"));
		    			
		    			database.insert(ContentEntry.TABLE_NAME, null, values);
		    		}
		    	}
		    }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Empty the entire database
	public void EmptyDb() {
		String deleteCategories = "DELETE FROM " + CategoryEntry.TABLE_NAME;
		String deleteSubCategories = "DELETE FROM " + SubCategoryEntry.TABLE_NAME;
		String deleteContents = "DELETE FROM " + ContentEntry.TABLE_NAME;
		String deleteMessages = "DELETE FROM " + MessageEntry.TABLE_NAME;
		
		database.execSQL(deleteCategories);
		database.execSQL(deleteSubCategories);
		database.execSQL(deleteContents);
		database.execSQL(deleteMessages);
	}
	
	public static boolean databaseExist(Context context, String dbName) {
	    File dbFile=context.getDatabasePath(dbName);
	    return dbFile.exists();
	}
	
	// Get all the top level category names
	public List<String> getAllCategories(Context context) {
		List<String> categories = new ArrayList<String>();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
				CategoryEntry.COLUMN_NAME_TITLE
				};
        
		Cursor c = database.query( CategoryEntry.TABLE_NAME, projection,
				null, null, null, null, null );
		 
		if (c.moveToFirst()) {
			do {
				categories.add(c.getString(0));
			} while(c.moveToNext());
		}
		 
		return categories;
	}
	
	// Get the id of a particular category
	public int getCategoryId(Context context, String category) {
		String[] projection = {
				CategoryEntry.COLUMN_NAME_ENTRY_ID
		};
		
		String selection = CategoryEntry.COLUMN_NAME_TITLE + "=?";
		String[] selectionArgs = {
				category
		};
		
		Cursor c = database.query( CategoryEntry.TABLE_NAME, projection, 
				selection, selectionArgs, null, null, null );
		
		c.moveToFirst();
		
		return c.getInt(0);
	}
	
	// Get all the subcategories of a particular top level category
	public List<String> getSubCategories(Context context, int categoryId) {
		List<String> subCategories = new ArrayList<String>();
		
		String[] projection = {
				SubCategoryEntry.COLUMN_NAME_TITLE
		};
		
		String selection = SubCategoryEntry.COLUMN_NAME_CATEGORY_ID + "=?";
		String[] selectionArgs = {
				Integer.toString(categoryId)
		};
				
		Cursor c = database.query( SubCategoryEntry.TABLE_NAME, projection, 
				selection, selectionArgs, null, null, null );
		
		if (c.moveToFirst()) {
			do {
				subCategories.add(c.getString(0));
			} while(c.moveToNext());
		}
		
		return subCategories;
	}
	
	// Get the id of a particular sub category
	public int getSubCategoryId(Context context, String subCategory) {
		String[] projection = {
				SubCategoryEntry.COLUMN_NAME_ENTRY_ID
		};
		
		String selection = SubCategoryEntry.COLUMN_NAME_TITLE + "=?";
		String[] selectionArgs = {
				subCategory
		};
		
		Cursor c = database.query( SubCategoryEntry.TABLE_NAME, projection,
				selection, selectionArgs, null, null, null );
		
		c.moveToFirst();
		
		return c.getInt(0);
	}
	
	// Get all the contents in a particular sub category by querying all the 
	// contentIds in message table
	public List<Content> getContents(Context context, int subCategoryId) {
		List<Content> contents = new ArrayList<Content>();
		
		String[] projection = {
				ContentEntry.COLUMN_NAME_ENTRY_ID
		};
		
		String selection = ContentEntry.COLUMN_NAME_SUBCATEGORY_ID + "=?";
		String[] selectionArgs = {
				Integer.toString(subCategoryId)
		};
				
		Cursor c = database.query( ContentEntry.TABLE_NAME, projection,
				selection, selectionArgs, null, null, null );
		
		if (c.moveToFirst()) {
			do {
				String[] mprojection = {
						MessageEntry.COLUMN_NAME_ENTRY_ID,
						MessageEntry.COLUMN_NAME_TITLE,
						MessageEntry.COLUMN_NAME_MESSAGE,
						MessageEntry.COLUMN_NAME_TODO
				};
				String mselection = MessageEntry.COLUMN_NAME_ENTRY_ID + "=?";
				String[] mselectionArgs = {
						Integer.toString(c.getInt(0))
				};
				Cursor message_cursor = database.query( MessageEntry.TABLE_NAME, mprojection,
						mselection, mselectionArgs, null, null, null );
				
				Content content = new Content();
				
				if (message_cursor.moveToFirst())
				{	
					content.setIdentifier(message_cursor.getInt(0));
					content.setTitle(message_cursor.getString(1));
					content.setMessage(message_cursor.getString(2));
					content.setTodo(message_cursor.getString(3));
				}
				
				contents.add(content);
			} while(c.moveToNext());
		}
		
		return contents;
	}
}
