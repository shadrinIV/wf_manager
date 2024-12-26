package com.shadrin.wf_manager.entity;
import java.math.BigInteger;
public interface Story {
	 BigInteger getId();
	 void setId(BigInteger id);
	 String getName();
	 void setName(String name);
	 String getDescription();
	 void setDescription(String description);
}
