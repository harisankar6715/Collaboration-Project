package com.niit.collaboration.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;

public class JUnitBlogTest {
	
	@Autowired
	BlogDAO blogDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void test() {
		int size = blogDAO.list().size();
		assertEquals("blog list test case ", 2, size);
	}

}
