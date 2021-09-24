package com.example.evaluation.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ColoursDTO implements Serializable {

	@SerializedName("color")
	private String color;

	@SerializedName("id")
	private int id;

	public String getColor(){
		return color;
	}

	public int getId(){
		return id;
	}
}