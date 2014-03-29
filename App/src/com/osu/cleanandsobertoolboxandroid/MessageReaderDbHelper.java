package com.osu.cleanandsobertoolboxandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.osu.cleanandsobertoolboxandroid.MessageDbContract.*;

public class MessageReaderDbHelper extends SQLiteOpenHelper {
	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MessageReader.db";
    
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    
    private static final String SQL_CREATE_STRUCTURE = 
		"CREATE TABLE " + StructureEntry.TABLE_NAME + " (" +
			StructureEntry._ID + " INTEGER PRIMARY KEY," +
			StructureEntry.COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + COMMA_SEP +
			StructureEntry.COLUMN_NAME_PARENT_ID + INTEGER_TYPE + COMMA_SEP +
	        StructureEntry.COLUMN_NAME_TYPE + TEXT_TYPE + COMMA_SEP +
	        StructureEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
	        " )";
    
    private static final String SQL_CREATE_MESSAGES = 
    	"CREATE TABLE " + MessageEntry.TABLE_NAME + " (" +
	    	MessageEntry._ID + " INTEGER PRIMARY KEY," +
	    	MessageEntry.COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + COMMA_SEP +
	    	MessageEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
	    	MessageEntry.COLUMN_NAME_MESSAGE + TEXT_TYPE + COMMA_SEP +
	    	MessageEntry.COLUMN_NAME_TODO + TEXT_TYPE + 
	    	" )";
    
    private static final String SQL_DELETE_STRUCTURE =
    		"DROP TABLE IF EXISTS " + StructureEntry.TABLE_NAME;
    
    private static final String SQL_DELETE_MESSAGES =
    		"DROP TABLE IF EXISTS " + MessageEntry.TABLE_NAME;

    
    public MessageReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	db.execSQL(SQL_CREATE_STRUCTURE);
        db.execSQL(SQL_CREATE_MESSAGES);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_STRUCTURE);
    	db.execSQL(SQL_DELETE_MESSAGES);
    	onCreate(db);
	}
	
	
}
