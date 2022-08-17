package com.astralife.rest.persistence.enums;

public enum GenderEnum {

	FEMALE("F"),
	MALE("M");
	
	
	private String name;
	
	GenderEnum(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
}
