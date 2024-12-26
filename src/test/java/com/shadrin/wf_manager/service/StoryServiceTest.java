package com.shadrin.wf_manager.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.shadrin.wf_manager.entity.Story;
import com.shadrin.wf_manager.entity.StoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.shadrin.wf_manager.dao.*;

@ExtendWith(MockitoExtension.class)
public class StoryServiceTest {
	
	@Mock
	private StoryDao storyDao;
	
	
    private StoryService storyService;
	
	@BeforeEach
	public void setUp() {
		storyService = new StoryServiceImpl();
		storyService.setStoryDao(storyDao);
	}
	
	
	@Test
	public void when_no_story_returns_empty() {
		Mockito.when(storyDao.getStories(0, 30)).thenReturn(Collections.emptyList());
		var stories = storyService.getStories(0, 30);
		assertTrue(stories.isEmpty());
	}
	
	@Test
	public void when_one_story_returns() {
		List<Story> storiesList = new ArrayList<Story>();
		storiesList.add(new StoryImpl(new BigInteger("1"), "First story"));
		Mockito.when(storyDao.getStories(0, 30)).thenReturn(storiesList);
		var stories = storyService.getStories(0, 30);
		assertTrue(stories.size()==1);
		assertEquals(stories.get(0).getName(),"First story");
	}
	
}
