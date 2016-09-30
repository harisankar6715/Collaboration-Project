package com.niit.collaboration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@RestController
public class BlogController {

	Map<String, Blog> blogData = new HashMap<String, Blog>();

	@Autowired
	private BlogDAO blogDAO;

	@Autowired
	private Blog blog;

	@GetMapping("/blog/")
	public ResponseEntity<List<Blog>> getBlogs() {

		List<Blog> list = blogDAO.list();
		
		
		if (list.isEmpty()) {
			
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
	}

	@GetMapping("/blogs/{id}")
	public ResponseEntity<Blog> getBlog(@PathVariable("id") String id) {

		System.out.println("Fetching blog  with id " + id);
		blog = blogDAO.get(id);
		if (blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@PostMapping(value = "/blog/")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {

		blogDAO.saveOrUpdate(blog);

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@DeleteMapping("/blog/{id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable String id) {

		if (blogDAO.get(id) == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		blogDAO.delete(id);

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@PutMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable String id, @RequestBody Blog blog) {

		if (blogDAO.get(id) == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		blogDAO.saveOrUpdate(blog);

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
}
