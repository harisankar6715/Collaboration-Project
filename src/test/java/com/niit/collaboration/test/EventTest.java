package com.niit.collaboration.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

public class EventTest {
	
public static void main(String[] args) {
		
		
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAO");
		Event event = (Event) context.getBean("event");
		
		event.setEventId("E1");
		event.setContent("First event");
		event.setDateTime(new Date(System.currentTimeMillis()));
		eventDAO.saveOrUpdate(event);
		
		if(eventDAO.getEvent("E1")== null)
		{
			System.out.println("event does not exist");
		}
		else
		{
			System.out.println("event exists..");
			System.out.println();
		} 
		
		

	}

}
