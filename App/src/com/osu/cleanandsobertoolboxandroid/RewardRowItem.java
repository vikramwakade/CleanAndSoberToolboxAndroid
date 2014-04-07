package com.osu.cleanandsobertoolboxandroid;

//This class is to hold row items for the rewards menu
public class RewardRowItem {
	private int imageId;
	private String text;
	
	public RewardRowItem(int imageId, String text){
		this.imageId = imageId;
		this.text = text;
	}

	public int getImageId(){
		return imageId;
	}
	public void setImageId(int imageId){
		this.imageId = imageId;
	}
	public String getText(){
		return text;
	}
	public void setText(String text){
		this.text = text;
	}
	@Override
	public String toString(){
		return text;
	}
}
