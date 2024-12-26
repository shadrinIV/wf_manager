package com.shadrin.wf_manager.entity;

import java.math.BigInteger;

public class StoryImpl implements Story{
	BigInteger id;
	String name;
	String description;
	public StoryImpl(BigInteger id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public BigInteger getId() {
		return this.id;
	}
	@Override
	public void setId(BigInteger id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;		
	}
	
}
