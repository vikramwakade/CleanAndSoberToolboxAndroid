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
    
    private static final String SQL_CREATE_CATEGORIES =
        "CREATE TABLE " + CategoryEntry.TABLE_NAME + " (" +
        CategoryEntry._ID + " INTEGER PRIMARY KEY," +
        CategoryEntry.COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + COMMA_SEP +
        CategoryEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
        " )";
    
    private static final String SQL_CREATE_SUBCATEGORIES =
        "CREATE TABLE " + SubCategoryEntry.TABLE_NAME + " (" +
        SubCategoryEntry._ID + " INTEGER PRIMARY KEY," +
        SubCategoryEntry.COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + COMMA_SEP +
        SubCategoryEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
        SubCategoryEntry.COLUMN_NAME_CATEGORY_ID + INTEGER_TYPE + 
        " )";
    
    private static final String SQL_CREATE_CONTENTS = 
		"CREATE TABLE " + ContentEntry.TABLE_NAME + " (" +
		ContentEntry._ID + " INTEGER PRIMARY KEY," +
		ContentEntry.COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + COMMA_SEP +
	    ContentEntry.COLUMN_NAME_SUBCATEGORY_ID + INTEGER_TYPE + 
	    " )";
    
    private static final String SQL_CREATE_MESSAGES = 
    	"CREATE TABLE " + MessageEntry.TABLE_NAME + " (" +
    	MessageEntry._ID + " INTEGER PRIMARY KEY," +
    	MessageEntry.COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + COMMA_SEP +
    	MessageEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
    	MessageEntry.COLUMN_NAME_MESSAGE + TEXT_TYPE + COMMA_SEP +
    	MessageEntry.COLUMN_NAME_TODO + TEXT_TYPE + 
    	" )";
    
    private static final String SQL_DELETE_CATEGORIES = 
    		"DROP TABLE IF EXISTS " + CategoryEntry.TABLE_NAME;
    
    private static final String SQL_DELETE_SUBCATEGORIES =
    		"DROP TABLE IF EXISTS " + SubCategoryEntry.TABLE_NAME;
    
    private static final String SQL_DELETE_CONTENTS = 
    		"DROP TABLE IF EXISTS " + ContentEntry.TABLE_NAME;
    
    private static final String SQL_DELETE_MESSAGES =
    		"DROP TABLE IF EXISTS " + MessageEntry.TABLE_NAME;

    
    public MessageReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CATEGORIES);
        db.execSQL(SQL_CREATE_SUBCATEGORIES);
        db.execSQL(SQL_CREATE_CONTENTS);
        db.execSQL(SQL_CREATE_MESSAGES);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_CATEGORIES);
		db.execSQL(SQL_DELETE_SUBCATEGORIES);
    	db.execSQL(SQL_DELETE_CONTENTS);
    	db.execSQL(SQL_DELETE_MESSAGES);
    	onCreate(db);
	}
}
