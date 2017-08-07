package com.swipe.matcher.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial4j.core.distance.DistanceUtils;
import com.swipe.matcher.bean.Job;
import com.swipe.matcher.bean.Location;
import com.swipe.matcher.bean.SearchLocation;
import com.swipe.matcher.bean.Worker;


@Service
public class MatcherService {
	

	@Autowired
	private RestClient restClient;
	
	
	public List<Job> findMatch(long workerId) {
		List<Worker> workers = restClient.getWorkersData("http://test.swipejobs.com/api/workers");
		List<Job> jobs = restClient.getJobsData("http://test.swipejobs.com/api/jobs");
		
	    Map<Long, Worker> workerMap = workers.stream().collect(Collectors.toMap(Worker::getUserId, Function.identity())); 
		Worker worker = workerMap.get(workerId);
		
		return jobs.stream().filter((job) -> 
			job.isDriverLicenseRequired() ? worker.isHasDriversLicense() : true && 
			job.getWorkersRequired() > 1 &&
			isInSearchArea(job.getLocation(), worker.getJobSearchAddress()) &&
			hasRequiredCertificates(worker, job.getRequiredCertificates()))
			.limit(3).collect(Collectors.toList());
	}
	
	private boolean isInSearchArea(Location loc, SearchLocation searchLoc) {
		double distance = DistanceUtils.distLawOfCosinesRAD(loc.getLatitude(),
				loc.getLongitude(), searchLoc.getLatitude(),
				searchLoc.getLongitude())
				* DistanceUtils.DEG_TO_KM;
		return distance < (double) searchLoc.getMaxJobDistance();
	}

	private boolean hasRequiredCertificates(Worker worker,
			List<String> requiredCerts) {
		return requiredCerts.stream()
				.filter(worker.getCertificates()::contains).count() == 0;
	}

}
