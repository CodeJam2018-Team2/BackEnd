package com.pfg.codejam.team2.controller;

public enum Tag {

	DELAWARE("Delaware"),
	CHICAGO("Chicago");

	private String name;

	Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
