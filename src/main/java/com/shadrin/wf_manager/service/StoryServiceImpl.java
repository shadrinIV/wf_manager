package com.shadrin.wf_manager.service;

import java.util.List;
import java.math.BigInteger;

import com.shadrin.wf_manager.entity.Story;
import com.shadrin.wf_manager.dao.StoryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StoryServiceImpl implements StoryService {

	private StoryDao storyDao;

	@Autowired
	public void setStoryDao(StoryDao storyDao) {
		this.storyDao = storyDao;
	}
	
	@Override
	public List<Story> getStories(int offset, int limit) {
		return storyDao.getStories(offset, limit);
	}
	
	@Override
	public Story getStory(BigInteger id) {
		return storyDao.getStory(id);
	}
	
	@Override
	public Story createStory(Story story) {
		storyDao.createStory(story);
		return storyDao.getStory(story.getId());
	}
}
