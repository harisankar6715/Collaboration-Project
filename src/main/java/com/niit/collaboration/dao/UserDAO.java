package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	void saveOrUpdateUser_Details(User user);
	void deleteUser(String Id);
	public User getUser(String Id);
	List<User> listUser();

}
