package com.swipe.matcher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swipe.matcher.bean.Job;
import com.swipe.matcher.bean.Worker;

public class RestClient {

	@Autowired
	private ObjectMapper mapper;

	
	public List<Worker> getWorkersData(String url) {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<List<Worker>> entity = rest.exchange(url, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Worker>>() {});
		return entity.getBody();
	}
	
	public List<Job> getJobsData(String url) {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<List<Job>> entity = rest.exchange(url, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Job>>() {});
		return entity.getBody();
	}

}
