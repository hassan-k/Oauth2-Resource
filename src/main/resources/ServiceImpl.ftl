package com.oauth.resource.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oauth.resource.dao.api.${object}Dao;
import com.oauth.resource.domain.${object}Model;
import com.oauth.resource.service.GenericServiceImpl;
import com.oauth.resource.service.api.${object}Service;


/**
 * 
 * @authors  Hassan.khani
 * @version 1.1.20170512
 * @change 
 * @target
 * 
 */
 

@Service
public class ${object}ServiceImpl extends GenericServiceImpl<${object}Model, Long> implements ${object}Service {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	${object}Dao ${object?lower_case}Dao; 
	
}
