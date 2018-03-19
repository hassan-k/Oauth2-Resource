package com.oauth.resource.service;


import java.io.Serializable;
import java.util.List;

public interface GenericService <T, PK extends Serializable> {

    public T saveOrUpdate(T object);
    public boolean deleteEntity(PK id);
    public List<T> getEntityList();
    public List<T> getEntityList(int page,int size);
    public T getEntityById(PK id);

}
