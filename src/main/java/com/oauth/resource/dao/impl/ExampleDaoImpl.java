package com.oauth.resource.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.oauth.resource.dao.GenericDaoHibernate;
import com.oauth.resource.domain.ExampleModel;
import com.oauth.resource.dao.api.ExampleDao;


/**
 * 
 * @authors Hassan.khani
 * @version 1.1.20170512
 * @change 
 * @target
 * 
 */
 
 
@Repository
public class ExampleDaoImpl extends GenericDaoHibernate<ExampleModel, Long> implements ExampleDao {

	Logger logger = Logger.getLogger(ExampleDaoImpl.class);
	
	public ExampleDaoImpl() {
		super(ExampleModel.class);
	}
	
	
}
