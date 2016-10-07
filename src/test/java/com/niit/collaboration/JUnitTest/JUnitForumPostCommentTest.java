package com.niit.collaboration.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumPostCommentDAO;

public class JUnitForumPostCommentTest {
	
	@Autowired
	ForumPostCommentDAO forumpostcommentDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumpostcommentDAO = (ForumPostCommentDAO) context.getBean("forumpostcommentDAO");
	}

	@Test
	public void test() {
		int size = forumpostcommentDAO.listOfForumPostComments().size();
		assertEquals("ForumPostComment Test Case ", 1, size);
	}

}
