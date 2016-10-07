package com.niit.collaboration.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumPostDAO;

public class JUnitForumPostTest {
	
	@Autowired
	ForumPostDAO forumpostDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumpostDAO =(ForumPostDAO) context.getBean("forumpostDAO");
	}

	@Test
	public void test() {
		int size = forumpostDAO.listOfForumPosts().size();
		assertEquals("forum post test case ", 1, size);
	}

}
