package com.autentia.tutoriales.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.autentia.tutoriales.dao.service.Dao;

@Repository("dao")
public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Autowired
	public DaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public <T> T getById(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveOrUpdate(List entities) {
		for (Object entity : entities) {
			getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findByQuery(String queryString, int firstResult, int maxResults, List<Object> params) {

		final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();

		final Query query = session.createQuery(queryString);

		if (params != null && params.size() > 0) {
			int i = 0;
			for (Object param : params) {
				query.setParameter(i, param);
				i++;
			}
		}

		if (firstResult > 0) {
			query.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			query.setMaxResults(maxResults);
		}

		return query.list();

	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNamedQuery(String namedQuery, int firstResult, int maxResults, Object... values) {

		final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		final Query query = session.getNamedQuery(namedQuery);

		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}

		if (firstResult > 0) {
			query.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			query.setMaxResults(maxResults);
		}

		return query.list();
	}

}
