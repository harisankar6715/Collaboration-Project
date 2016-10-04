package com.niit.collaboration.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

public class ForumTest {
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		Forum forum = (Forum) context.getBean("forum");
		
		forum.setForumId("F1");
		forum.setUserId("U1");
		forum.setTitle("first forum");
		forum.setDescription("This is the first forum");
		forum.setNoOfPosts('1');
		forum.setStatus('A');
		forum.setDateTime(new Date(System.currentTimeMillis()));
		forumDAO.saveOrUpdate(forum);
		
		if(forumDAO.getForum("F1")== null)
		{
			System.out.println("forum does not exist");
		}
		else
		{
			System.out.println("forum exists..");
			System.out.println();
		} 
		}
}
