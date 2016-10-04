package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaboration.model.ForumPost;

@Repository("forumpostDAO")
public class ForumPostDAOImpl implements ForumPostDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public ForumPostDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(ForumPost forumPost) {
		sessionFactory.getCurrentSession().saveOrUpdate(forumPost);

	}

	@Transactional
	public void delete(String forumPostId) {
		ForumPost forumPostToDelete = new ForumPost();
		forumPostToDelete.setForumPostId(forumPostId);
		sessionFactory.getCurrentSession().delete(forumPostToDelete);
	}

	@Transactional
	public ForumPost getForumPost(String forumPostId) {
		String hql = "from ForumPost where forumPostId=:forumPostId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumPostId",forumPostId);
		List<ForumPost> gotForumPost = (List<ForumPost>)query.list();
		if(gotForumPost!=null&&!gotForumPost.isEmpty())
			return gotForumPost.get(0);
		return null;
	}

	@Transactional
	public List<ForumPost> listOfForumPosts() {
		String hql = "from ForumPost";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPost> listOfForumPosts = (List<ForumPost>)query.list();
		return listOfForumPosts;
	}

}
