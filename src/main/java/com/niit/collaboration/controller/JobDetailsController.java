package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.JobDetailsDAO;
import com.niit.collaboration.model.JobDetails;

@RestController
public class JobDetailsController {
	
	@Autowired
	JobDetails jobDetails;
	
	@Autowired
	JobDetailsDAO jobDetailsDAO;
	
	@GetMapping("/jobs/")
	public ResponseEntity<List<JobDetails>> listAllJobDetails() {
		List<JobDetails> listOfJobDetails = jobDetailsDAO.listOfJobDetails();
		if (listOfJobDetails.isEmpty()) {
			return new ResponseEntity <List<JobDetails>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < JobDetails >> (listOfJobDetails, HttpStatus.OK);
	}
	
	
	@GetMapping("/jobs/{jobDetailsId}")
	public ResponseEntity<JobDetails> getJobDetails(@PathVariable("jobDetailsId") String jobDetailsId) {
		this.jobDetails = jobDetailsDAO.getJobDetails(jobDetailsId);
		if (jobDetails == null) {
			return new ResponseEntity<JobDetails>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<JobDetails>(jobDetails, HttpStatus.OK);

	}
	
	@PostMapping("/jobs/")
	public ResponseEntity<Void> createJobDetails(@RequestBody JobDetails jobDetails,
			UriComponentsBuilder ucBuilder) {
		if (jobDetailsDAO.getJobDetails(jobDetails.getJobDetailsId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		jobDetailsDAO.saveOrUpdate(jobDetails);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/jobs/{jobDetailsId}/").buildAndExpand(jobDetails.getJobDetailsId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	
	@PutMapping("/jobs/{jobDetailsId}")
	public ResponseEntity<JobDetails> updateJobDetails(@PathVariable("jobDetailsId")String jobDetailsId,@RequestBody JobDetails jobDetails){
		
		if(jobDetails==null){
			return new ResponseEntity<JobDetails>(HttpStatus.NOT_FOUND);
		}
		jobDetails.setJobDetailsId(jobDetailsId);
		

		
		jobDetailsDAO.saveOrUpdate(jobDetails);

		return new ResponseEntity<JobDetails>(jobDetails, HttpStatus.OK);

	}
	@DeleteMapping("/jobs/{jobDetailsId}")
	public ResponseEntity<JobDetails> deleteJobDetails(@PathVariable("jobDetailsId")String jobDetailsId){
	this.jobDetails = jobDetailsDAO.getJobDetails(jobDetailsId);
	if(this.jobDetails==null){
		System.out.println("jobDetails not exist to delete");
		return new ResponseEntity<JobDetails>(HttpStatus.NOT_FOUND);
		
	}
	
	jobDetailsDAO.delete(jobDetailsId);
		return new ResponseEntity<JobDetails>(HttpStatus.NO_CONTENT);
	
	}

}
