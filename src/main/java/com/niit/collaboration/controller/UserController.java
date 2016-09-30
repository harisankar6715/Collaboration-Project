package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UserController {

	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/user/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> listOfUsers = userDAO.listUser();
		if (listOfUsers.isEmpty()) {
			return new ResponseEntity <List<User>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < User >> (listOfUsers, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {

		System.out.println("Fetching user  with id " + id);
		user = userDAO.getUser(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/user/")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		userDAO.saveOrUpdate(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> delete(@PathVariable String id) {

		if (userDAO.getUser(id) == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userDAO.delete(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {

		if (userDAO.getUser(id) == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userDAO.saveOrUpdate(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
