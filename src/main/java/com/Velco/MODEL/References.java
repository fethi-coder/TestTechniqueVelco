package com.Velco.MODEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_References")
public class References{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idReferences;
	
	private Integer numReference;
	private String type;
	private Float price;
	private Integer size;

	public References() {
		super();
	}


	public References(Integer numReference, String type, Float price, Integer size) {
		super();
		this.numReference = numReference;
		this.type = type;
		this.price = price;
		this.size = size;
	}



	

	public Integer getNumReference() {
		return numReference;
	}



	public void setNumReference(Integer numReference) {
		this.numReference = numReference;
	}



	public Integer getSize() {
		return size;
	}



	public void setSize(Integer size) {
		this.size = size;
	}



	public Float getPrice() {
		return price;
	}



	public void setPrice(Float price) {
		this.price = price;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "References [numReference=" + numReference + ", type=" + type + ", price=" + price + ", size=" + size
				+ "]";
	}


}
