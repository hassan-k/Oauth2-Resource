package com.oauth.resource.service;


import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth.resource.dao.GenericDao;

/**
*
* @author  Hassan.khani
* @version 1.1.20170429
* @change 
* @target
* 
*/

@Service
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	@Autowired
    private GenericDao<T, PK> genericDao;

    public GenericServiceImpl(GenericDao<T, PK> genericDao) {
        this.genericDao = genericDao;
    }

	public GenericServiceImpl() {
	}

    @Override
    public List<T> getEntityList() {
        return genericDao.getEntityList();
    }

    @Override
    public List<T> getEntityList(int page, int size) {
        return genericDao.getEntityList(page, size);
    }

    @Override
    public T getEntityById(PK id){
        return genericDao.getEntityById(id);
    }

    @Override
    public T saveOrUpdate(T object) {
        return genericDao.saveOrUpdate(object);
    }

    @Override
    public boolean deleteEntity(PK id) {
        return genericDao.deleteEntity(id);
    }

}
