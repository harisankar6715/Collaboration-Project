package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateUser_Details(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Transactional
	public void deleteUser(String Id) {
		User userToDelete = new User();
		userToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(userToDelete);

	}

	@Transactional
	public User getUser(String Id) {
		String hql = "from User where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<User> gotUser = (List<User>)query.list();
		if (gotUser != null && !gotUser.isEmpty())
			return gotUser.get(0);
		return null;
	}

	@Transactional
	public List<User> listUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listOfUser = (List<User>)query.list();
		return listOfUser;
	}

}
