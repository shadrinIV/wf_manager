package com.shadrin.wf_manager.entity;

import java.math.BigInteger;

public interface Task {
	BigInteger getId();
	String getName();
	void setName(String name);
	Value[] getValues();
	void setValue(Value[] values);
}



