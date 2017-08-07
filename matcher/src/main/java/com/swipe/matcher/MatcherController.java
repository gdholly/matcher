package com.swipe.matcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swipe.matcher.bean.Job;
import com.swipe.matcher.service.MatcherService;

@RestController
public class MatcherController {
	
	@Autowired
	MatcherService matcherService;


    @RequestMapping("/matcher")
    public List<Job> matcher(@RequestParam(value="id", required=true) long id) {
    	return matcherService.findMatch(id);
    }

 
}