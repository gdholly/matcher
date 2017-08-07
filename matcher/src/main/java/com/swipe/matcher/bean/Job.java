package com.swipe.matcher.bean;


import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class Job {
	
	private boolean driverLicenseRequired;
	private List<String> requiredCertificates;
	private Location location;
	private String billRate;  //$6.18
	private int workersRequired;
	@JsonIgnore
	private ZonedDateTime startDate; 
	private String about;
	private String jobTitle;
	private String company;
	private String guid;
	private long jobId;
	
	public boolean isDriverLicenseRequired() {
		return driverLicenseRequired;
	}
	public void setDriverLicenseRequired(boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}
	public List<String> getRequiredCertificates() {
		return requiredCertificates;
	}
	public void setRequiredCertificates(List<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getBillRate() {
		return billRate;
	}
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}
	public int getWorkersRequired() {
		return workersRequired;
	}
	public void setWorkersRequired(int workersRequired) {
		this.workersRequired = workersRequired;
	}
	public ZonedDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
		

	
	
    
}