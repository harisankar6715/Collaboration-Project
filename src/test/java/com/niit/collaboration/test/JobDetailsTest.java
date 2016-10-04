package com.niit.collaboration.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDetailsDAO;
import com.niit.collaboration.model.JobDetails;

public class JobDetailsTest {
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		JobDetailsDAO jobDetailsDAO = (JobDetailsDAO) context.getBean("jobDetailsDAO");
		JobDetails jobDetails = (JobDetails) context.getBean("jobDetails");
		
		jobDetails.setJobDetailsId("JD1");
		jobDetails.setContent("This is the Job Details");
		jobDetails.setDateTime(new Date(System.currentTimeMillis()));
		
		jobDetailsDAO.saveOrUpdate(jobDetails);
		
		if(jobDetailsDAO.getJobDetails("JD1")== null)
		{
			System.out.println("job Details does not exist");
		}
		else
		{
			System.out.println("job Details exists..");
			System.out.println();
		} 
	}

}
