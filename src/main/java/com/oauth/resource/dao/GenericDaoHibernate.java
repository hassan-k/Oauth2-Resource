package com.oauth.resource.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oauth.resource.util.ResourceNotFoundException;


/**
*
* @author  Hassan.khani
* @version 1.1.20170601
* @change 
* @target
* 
*/

@Repository
@Transactional
@Primary
public class GenericDaoHibernate <T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> persistentClass;
    
    private SessionFactory sessionFactory;
    
    Logger logger = Logger.getLogger(this.getClass().getName());

    public GenericDaoHibernate() {
    }
    
	public GenericDaoHibernate(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    
	@Override
	@Transactional
	public T saveOrUpdate(T object) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		return object;
		
	}

	@Override
	@Transactional
	public boolean deleteEntity(PK id) {
		
		@SuppressWarnings("unchecked")
		T obj = (T) sessionFactory.getCurrentSession().load(persistentClass, id);
		if (obj != null) {
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		}
		return false;
		
	}

    @SuppressWarnings("unchecked")
	@Override
    @Transactional(readOnly = true)
    public List<T> getEntityList() {
    	
        return sessionFactory.getCurrentSession().createCriteria(persistentClass).list();
        
          }

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEntityList(int page, int size) {
		
		List<T> list = new ArrayList<T>();
		list = sessionFactory.getCurrentSession().createCriteria(persistentClass)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
		if (page != 1 && page > list.size() / size) {
			throw new ResourceNotFoundException(persistentClass.getSimpleName());
		} else if (list.size() == 0) {
			throw new ResourceNotFoundException(persistentClass.getSimpleName());
		}
		return list;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public T getEntityById(PK id){	
		
			T res =  (T) sessionFactory.getCurrentSession().get(persistentClass, id);
			if (res == null) {
				throw new ResourceNotFoundException(persistentClass.getSimpleName(), Integer.parseInt(id.toString()));
			}
			return res;
			
	}

}
