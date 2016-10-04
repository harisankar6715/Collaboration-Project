package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ForumPost;

public interface ForumPostDAO {
	
	void saveOrUpdate(ForumPost forumPost);
	void delete(String forumPostId);
	public ForumPost getForumPost(String forumPostId);
	List<ForumPost> listOfForumPosts();


}
