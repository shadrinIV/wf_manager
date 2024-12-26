package com.shadrin.wf_manager.service;

import java.util.List;
import java.math.BigInteger;

import com.shadrin.wf_manager.dao.StoryDao;
import com.shadrin.wf_manager.entity.Story;
public interface StoryService {
	List<Story> getStories(int offset, int limit);
	
	Story getStory(BigInteger id);

	void setStoryDao(StoryDao storyDao);

	Story createStory(Story story);
}
