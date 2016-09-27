package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	void saveOrUpdate(User user);
	void delete(String Id);
	public User getUser(String Id);
	List<User> listUser();

}
