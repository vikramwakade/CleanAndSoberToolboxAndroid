package com.osu.cleanandsobertoolboxandroid;

import java.util.List;

public class Content {
	private int identifier;
	private String title;
	private String message;
	private String todo;
	
	// List of all the contents within a subcategory
	public static List<Content> Contents;
	
	public int getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTodo() {
		return todo;
	}
	
	public void setTodo(String todo) {
		this.todo = todo;
	}
}
