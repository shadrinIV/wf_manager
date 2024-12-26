package com.shadrin.wf_manager.controller;

import com.shadrin.wf_manager.service.StoryService;
import com.shadrin.wf_manager.entity.Story;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/story")
public class StoryController {
	public StoryService service;
	
	@GetMapping(value ="")
	List<Story> getStories(@RequestParam("page") int page){
		int pageSize = 50;
		return service.getStories(pageSize*page, pageSize);
	}
	
	@GetMapping(value ="/{storyId}")
	Story getStory(@PathVariable String storyId){
		return service.getStory(new BigInteger(storyId));
	}
	
	@PostMapping("")
	Story createStory(@RequestBody Story story){
		return service.createStory(story);
	}
	
	public StoryController(StoryService service) {
		this.service = service;
	}

}
