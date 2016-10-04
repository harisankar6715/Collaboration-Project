package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Forum;

public interface ForumDAO {
	
	void saveOrUpdate(Forum forum);
	void delete(String forumId);
	public Forum getForum(String forumId);
	List<Forum> listOfForums();


}
