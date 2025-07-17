package com.aurionpro.model;

public class Player {
	private String name;

	private CharType charType;

	public Player(String name, CharType charType) {
		super();
		this.name = name;
		
		this.charType = charType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public CharType getCharType() {
		return charType;
	}

	


}
