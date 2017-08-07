package com.swipe.matcher;

import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.swipe.config.config.TestConfig;
import com.swipe.matcher.service.MatcherService;
import com.swipe.matcher.service.RestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Import(TestConfig.class)
public class MatcherApplicationTests {

    @MockBean
    private RestClient restClient;

    @Autowired
    private MatcherService matcherService;

    @Test
    public void testMatcherService() {
    	//given(this.restClient.getJobsData("http://test.swipejobs.com/api/workers")).willReturn(jobsList);
    	//given(this.restClient.getWorkersData("http://test.swipejobs.com/api/workers")).willReturn(workersList);
    }
    
    
	@Test
	public void contextLoads() {
	}

}
