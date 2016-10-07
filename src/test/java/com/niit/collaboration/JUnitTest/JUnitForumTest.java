package com.niit.collaboration.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumDAO;

public class JUnitForumTest {
	
	@Autowired
	ForumDAO forumDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void test() {
		int size = forumDAO.listOfForums().size();
		assertEquals("forum test case ", 1, size);
	}

}
