package com.oauth.resource.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.oauth.resource.dao.GenericDaoHibernate;
import com.oauth.resource.domain.${object}Model;
import com.oauth.resource.dao.api.${object}Dao;


/**
 * 
 * @authors Hassan.khani
 * @version 1.1.20170512
 * @change 
 * @target
 * 
 */
 
 
@Repository
public class ${object}DaoImpl extends GenericDaoHibernate<${object}Model, Long> implements ${object}Dao {

	Logger logger = Logger.getLogger(${object}DaoImpl.class);
	
	public ${object}DaoImpl() {
		super(${object}Model.class);
	}
	
	
}
