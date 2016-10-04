package com.niit.collaboration.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumPostDAO;
import com.niit.collaboration.model.ForumPost;

public class ForumPostTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumPostDAO forumpostDAO = (ForumPostDAO) context.getBean("forumpostDAO");
		ForumPost forumpost = (ForumPost) context.getBean("forumPost");
		
		forumpost.setForumPostId("FP1");
		forumpost.setForumId("F1");
		forumpost.setUserId("U1");
		forumpost.setForumPostContent("This is the content");
		forumpost.setDateTime(new Date(System.currentTimeMillis()));
		forumpostDAO.saveOrUpdate(forumpost);
		
		if(forumpostDAO.getForumPost("FP1")== null)
		{
			System.out.println("forum post does not exist");
		}
		else
		{
			System.out.println("forum post exists..");
			System.out.println();
		} 
		
		

	}

}
