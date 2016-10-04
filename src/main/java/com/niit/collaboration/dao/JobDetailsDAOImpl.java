package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaboration.model.JobDetails;

@Repository("jobDetailsDAO")
public class JobDetailsDAOImpl implements JobDetailsDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public JobDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(JobDetails jobDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobDetails);

	}

	@Transactional
	public void delete(String jobDetailsId) {
		JobDetails jobDetailsToDelete = new JobDetails();
		jobDetailsToDelete.setJobDetailsId(jobDetailsId);
		sessionFactory.getCurrentSession().delete(jobDetailsToDelete);
	}

	@Transactional
	public JobDetails getJobDetails(String jobDetailsId) {
		String hql = "from JobDetails where jobDetailsId=:jobDetailsId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("jobDetailsId",
				jobDetailsId);
		List<JobDetails> gotJobDetails = (List<JobDetails>)query.list();
		if (gotJobDetails != null && !gotJobDetails.isEmpty())
			return gotJobDetails.get(0);
		return null;
	}

	@Transactional
	public List<JobDetails> listOfJobDetails() {
		String hql = "from JobDetails";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<JobDetails> listOfJobDetails = (List<JobDetails>)query.list();
		return listOfJobDetails;
	}

}
