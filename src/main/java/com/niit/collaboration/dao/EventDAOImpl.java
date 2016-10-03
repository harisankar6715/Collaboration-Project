package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Event;
import com.niit.collaboration.model.User;
@Transactional
@Repository("eventDAO") 
public class EventDAOImpl implements EventDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);

	}

	@Transactional
	public void delete(String Id) {
		Event eventToDelete = new Event();
		eventToDelete.setEventId(Id);
		sessionFactory.getCurrentSession().delete(eventToDelete);
	}

	@Transactional
	public Event getEvent(String Id) {
		String hql = "from Event where eventId=" + "'" + Id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> gotEvent = (List<Event>)query.list();
		if (gotEvent != null && !gotEvent.isEmpty())
			return gotEvent.get(0);
		return null;
	}

	@Transactional
	public List<Event> listEvent() {
		String hql = "from Event";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listOfEvent = (List<Event>)query.list();
		return listOfEvent;
	}

}
