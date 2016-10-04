package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.ForumPostComment;

@Repository("forumpostcommentDAO")
public class ForumPostCommentDAOImpl implements ForumPostCommentDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public ForumPostCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(ForumPostComment forumPostComment) {
		sessionFactory.getCurrentSession().saveOrUpdate(forumPostComment);

	}

	@Transactional
	public void delete(String forumPostCommentId) {
		ForumPostComment forumPostCommentTodelete = new ForumPostComment();
		forumPostCommentTodelete.setForumPostCommentId(forumPostCommentId);
		sessionFactory.getCurrentSession().delete(forumPostCommentTodelete);
	}

	@Transactional
	public ForumPostComment getForumPostComment(String forumPostCommentId) {
		String hql = "from ForumPostComment where forumPostCommentId=:forumPostCommentId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumPostCommentId",
				forumPostCommentId);
		List<ForumPostComment> gotForumPostComment = (List<ForumPostComment>)query.list();
		if (gotForumPostComment != null && !gotForumPostComment.isEmpty())
			return gotForumPostComment.get(0);
		return null;
	}

	@Transactional
	public List<ForumPostComment> listOfForumPostComments() {
		String hql = "from ForumPostComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPostComment> listOfForumPostComments = (List<ForumPostComment>)query.list();
		return listOfForumPostComments;
	}


}
