package com.swipe.config.config;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.swipe.matcher.service.RestClient;


@Profile("test")
@TestConfiguration
public class TestConfig {
    @Bean
    @Primary
	public RestClient restClient() {
		return Mockito.mock(RestClient.class);
    }
}
