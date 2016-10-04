package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.JobDetails;

public interface JobDetailsDAO {

	void saveOrUpdate(JobDetails jobDetails);
	void delete(String jobDetailsId);
	public JobDetails getJobDetails(String jobDetailsId);
	List<JobDetails> listOfJobDetails();
	
}
