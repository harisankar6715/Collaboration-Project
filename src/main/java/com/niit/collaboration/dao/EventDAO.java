package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Event;

public interface EventDAO {
	
	void saveOrUpdate(Event event);
	void delete(String Id);
	public Event getEvent(String Id);
	List<Event> listEvent();

}
