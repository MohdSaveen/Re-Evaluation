package com.example.evaluation.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("sizes")
	private List<SizesDTO> sizes;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("year")
	private int year;

	@SerializedName("styleId")
	private String styleId;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("media")
	private MediaDTO media;

	@SerializedName("brand")
	private String brand;

	@SerializedName("retailPrice")
	private int retailPrice;

	@SerializedName("shoe")
	private String shoe;

	@SerializedName("colours")
	private List<ColoursDTO> colours;

	public List<SizesDTO> getSizes(){
		return sizes;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public int getYear(){
		return year;
	}

	public String getStyleId(){
		return styleId;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public MediaDTO getMedia(){
		return media;
	}

	public String getBrand(){
		return brand;
	}

	public int getRetailPrice(){
		return retailPrice;
	}

	public String getShoe(){
		return shoe;
	}

	public List<ColoursDTO> getColours(){
		return colours;
	}
}