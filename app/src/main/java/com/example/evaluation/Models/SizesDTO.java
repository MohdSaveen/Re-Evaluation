package com.example.evaluation.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SizesDTO implements Serializable {

	@SerializedName("size")
	private int size;

	@SerializedName("id")
	private int id;

	public int getSize(){
		return size;
	}

	public int getId(){
		return id;
	}
}