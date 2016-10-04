package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ForumPostComment;

public interface ForumPostCommentDAO {
	
	void saveOrUpdate(ForumPostComment forumPostComment);
	void delete(String forumPostCommentId);
	public ForumPostComment getForumPostComment(String forumPostCommentId);
	List<ForumPostComment> listOfForumPostComments();


}
