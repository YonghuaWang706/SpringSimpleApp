package com.example.spinrgrest_yonghua.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


public abstract class AbstractDao <T extends Serializable>{
	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<T> clazz;

	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	@Transactional
	public T findById(final Long id) {
		return getCurrentSession().get(clazz, id);
	}

	@Transactional
	public void add(T t) {
		getCurrentSession().persist(t);
	}

	@Transactional
	public T update(T t) {
		return (T) getCurrentSession().merge(t);
	}

	protected Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) session = sessionFactory.openSession();
		return session;
	}

	@Transactional
	public abstract List<T> getAll();
	//Session session = getCurrentSession();
	//		return  session.createQuery("from User").list();

	@Transactional
	public abstract int deleteGivenID(Long id);
	//entityManager.createQuery("delete from Foo where id = :id")
	//  .setParameter("id", foo.getId())
	//  .executeUpdate();
}
