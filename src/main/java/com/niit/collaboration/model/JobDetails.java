package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class JobDetails {
	
	@Id
	private String JobDetailsId;
	private String content;
	private Date DateTime;
	public String getJobDetailsId() {
		return JobDetailsId;
	}
	public void setJobDetailsId(String jobDetailsId) {
		JobDetailsId = jobDetailsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	

}
