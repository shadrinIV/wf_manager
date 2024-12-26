package com.shadrin.wf_manager.entity;

import java.math.BigInteger;

public class TaskImpl {
	BigInteger id;
	String name;
	Value[] values;
	
	public BigInteger getId() {
		return this.id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Value[] getValues() {
		return this.values;
	}
	
	public void setValue(Value[] values) {
		this.values = values;
	}
}

