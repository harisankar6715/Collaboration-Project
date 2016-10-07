package com.niit.collaboration.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDetailsDAO;

public class JUnitJobDetailsTest {
	
	@Autowired
	JobDetailsDAO jobDetailsDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDetailsDAO = (JobDetailsDAO) context.getBean("jobDetailsDAO");
	}

	@Test
	public void test() {
		int size = jobDetailsDAO.listOfJobDetails().size();
		assertEquals("job oppertunity test case ", 1, size);
	}

}
