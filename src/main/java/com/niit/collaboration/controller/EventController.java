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

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;



@RestController
public class EventController { 
	
	Map<String, Event> eventData = new HashMap<String, Event>();

	@Autowired
	private EventDAO eventDAO;

	@Autowired
	private Event event;

	@GetMapping("/event/")
	public ResponseEntity<List<Event>> getEvent() {

		List<Event> list = eventDAO.listEvent();
		
		
		if (list.isEmpty()) {
			
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Event>>(list,HttpStatus.OK);
	}

	@GetMapping("/event/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") String id) {

		System.out.println("Fetching event  with id " + id);
		event = eventDAO.getEvent(id);
		if (event == null) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@PostMapping(value = "/event/")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {

		eventDAO.saveOrUpdate(event);

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@DeleteMapping("/event/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable String id) {

		if (eventDAO.getEvent(id) == null) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		eventDAO.delete(id);

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@PutMapping("/event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable String id, @RequestBody Event event) {

		if (eventDAO.getEvent(id) == null) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		eventDAO.saveOrUpdate(event);

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

}
