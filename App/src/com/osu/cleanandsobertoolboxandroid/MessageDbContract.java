package com.osu.cleanandsobertoolboxandroid;

import android.provider.BaseColumns;

public final class MessageDbContract {
	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
	public MessageDbContract() {}
	
	/* Inner class that defines the "structure" table contents */
    public static abstract class StructureEntry implements BaseColumns {
    	public static final String TABLE_NAME = "structure";
        public static final String COLUMN_NAME_ENTRY_ID = "identifier";
        public static final String COLUMN_NAME_PARENT_ID = "parentid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_TYPE = "type";
    }
	
	/* Inner class that defines the "category" table contents */
    public static abstract class CategoryEntry implements BaseColumns {
    	public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME_ENTRY_ID = "identifier";
        public static final String COLUMN_NAME_TITLE = "title";
    }
    
    /* Inner class that defines the "subcategory" table contents */
    public static abstract class SubCategoryEntry implements BaseColumns {
    	public static final String TABLE_NAME = "subcategory";
        public static final String COLUMN_NAME_ENTRY_ID = "identifier";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CATEGORY_ID = "categoryid";   // Foreign key
    }
    
    /* Inner class that defines the "content" table contents */
    public static abstract class ContentEntry implements BaseColumns {
    	public static final String TABLE_NAME = "content";
        public static final String COLUMN_NAME_ENTRY_ID = "identifier";
        public static final String COLUMN_NAME_SUBCATEGORY_ID = "subcategoryid";   // Foreign key
    }
    
    /* Inner class that defines the "messages" table contents */
    public static abstract class MessageEntry implements BaseColumns {
    	public static final String TABLE_NAME = "messages";
    	public static final String COLUMN_NAME_ENTRY_ID = "identifier";
    	public static final String COLUMN_NAME_TITLE = "title";
    	public static final String COLUMN_NAME_MESSAGE = "message";
    	public static final String COLUMN_NAME_TODO = "todo";
    }
}
