package com.example.evaluation.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MediaDTO implements Serializable {

	@SerializedName("imageUrl")
	private String imageUrl;

	public String getImageUrl(){
		return imageUrl;
	}
}