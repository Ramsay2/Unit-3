package com.example.dynamicfragments;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseDTO implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("subTitle")
	private String subTitle;

	@SerializedName("title")
	private String title;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setSubTitle(String subTitle){
		this.subTitle = subTitle;
	}

	public String getSubTitle(){
		return subTitle;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"image = '" + image + '\'' + 
			",subTitle = '" + subTitle + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}