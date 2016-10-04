package com.niit.collaboration.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumPostCommentDAO;
import com.niit.collaboration.model.ForumPostComment;

public class ForumPostCommentTest {
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumPostCommentDAO forumpostCommentDAO = (ForumPostCommentDAO) context.getBean("forumpostcommentDAO");
		ForumPostComment forumpostComment = (ForumPostComment) context.getBean("forumPostComment");
		
		forumpostComment.setForumPostCommentId("FPC1");
		forumpostComment.setForumPostId("FP1");
		forumpostComment.setForumId("F1");
		forumpostComment.setUserId("U1");
		forumpostComment.setForumPostCommentContent("This is the content for frompostcomment");
		forumpostComment.setDateTime(new Date(System.currentTimeMillis()));
		
		forumpostCommentDAO.saveOrUpdate(forumpostComment);
		
		if(forumpostCommentDAO.getForumPostComment("FPC1")== null)
		{
			System.out.println("forum post comment does not exist");
		}
		else
		{
			System.out.println("forum post comment exists..");
			System.out.println();
		} 
	}


}
