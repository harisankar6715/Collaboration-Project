package com.niit.collaboration.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;

public class JUnitUserTest {
	
	@Autowired
	UserDAO userDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void test() {
		int size = userDAO.listUser().size();
		assertEquals("user list test case ", 1, size);
	}

}
