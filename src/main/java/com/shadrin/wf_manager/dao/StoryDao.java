package com.shadrin.wf_manager.dao;
import java.math.BigInteger;
import java.util.List;
import com.shadrin.wf_manager.entity.Story;

public interface StoryDao {
	List<Story> getStories(int offset, int limit);
	Story getStory(BigInteger id);
	void createStory(Story story);
}
