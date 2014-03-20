package com.autentia.tutoriales.dao.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface Dao {

	<T> T getById(Class<T> entityClass, Serializable id);

	<T> List<T> loadAll(Class<T> entityClass);

	@Transactional
	void saveOrUpdate(Object entity);

	@SuppressWarnings("unchecked")
	@Transactional
	void saveOrUpdate(List entities);

	@Transactional
	void delete(Object entity);

	@SuppressWarnings("unchecked")
	List findByQuery(String queryString, int firstResult, int maxResults,
			List<Object> params);

	<T> List<T> findByNamedQuery(String namedQuery, int firstResult,
			int maxResults, Object... values);
}
