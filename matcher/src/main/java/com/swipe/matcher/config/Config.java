package com.swipe.matcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.swipe.matcher.bean.Job;
import com.swipe.matcher.bean.Worker;
import com.swipe.matcher.service.MatcherService;
import com.swipe.matcher.service.RestClient;

@Configuration
public class Config {

	@Bean
	public RestClient restClient() {
		return new RestClient();
	}


	@Bean
	public MatcherService matcherService() {
		return new MatcherService();
	}

	@Bean
	ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JSR310Module());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper;
	}

}