package com.niit.collaboration.test;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

public class BlogTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");

		Blog blog = (Blog) context.getBean("blog");
		
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);


		blog.setId("B15");
		blog.setDescription("This is the First Blog");
		blog.setTitle("First Blog");
		blog.setStatus('A');
		blog.setCreatedate(timestamp);
		blogDAO.saveOrUpdate(blog);

		System.out.println("\n***********\n"+blogDAO.list()+"\n***********\n");
		if (blogDAO.get("B1") == null) {
			System.out.println("blog does not exist");
		} else {
			System.out.println("blog exists..");
		}
	}

}
