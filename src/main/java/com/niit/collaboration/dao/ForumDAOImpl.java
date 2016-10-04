package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaboration.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);

	}

	@Transactional
	public void delete(String forumId) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(forumToDelete);
	}

	@Transactional
	public Forum getForum(String forumId) {
		String hql = "from Forum where forumId=:forumId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumId", forumId);
		List<Forum> gotForum = (List<Forum>)query.list();
		if (gotForum != null && !gotForum.isEmpty())
			return gotForum.get(0);
		return null;
	}

	@Transactional
	public List<Forum> listOfForums() {
		String hql = "from Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listOfForums = (List<Forum>)query.list();
		return listOfForums;
	}

}
