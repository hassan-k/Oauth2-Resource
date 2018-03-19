package com.oauth.resource.dao;


import java.io.Serializable;
import java.util.List;

public interface GenericDao <T extends Object, PK extends Serializable> {

    public T saveOrUpdate(T object);
   
    public boolean deleteEntity(PK id);
    
    public List<T> getEntityList() ;
    
    public List<T> getEntityList(int page, int size);
    
    public T getEntityById(PK id);

}
