package com.nttdatacenters.springt3.arr.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdatacenters.springt3.arr.persistence.AbstractEntity;

import jakarta.persistence.EntityManager;

/**
 * 
 * @author Alexandra Rodríguez
 *
 * @param <T>
 */
@Repository
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	@Transactional
	public void insert(final T paramT) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Insercción.
		currentSession.save(paramT);

		// Cierre de sesión.
		currentSession.close();

	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void update(final T paramT) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Insercción.
		currentSession.saveOrUpdate(paramT);

		// Cierre de sesión.
		currentSession.close();

	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void delete(final T paramT) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Insercción.
		currentSession.delete(paramT);

		// Cierre de sesión.
		currentSession.close();

	}

	@Override
	@Transactional
	public T searchById(final Long id) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda por PK.
		T result = currentSession.get(this.entityClass, id);

		// Cierre de sesión.
		currentSession.close();

		return result;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<T> searchAll() {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda de todos los registros.
		@SuppressWarnings("deprecation")
		List<T> list = currentSession.createQuery("FROM " + this.entityClass.getName()).list();

		// Cierre de sesión.
		currentSession.close();

		return list;

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}


