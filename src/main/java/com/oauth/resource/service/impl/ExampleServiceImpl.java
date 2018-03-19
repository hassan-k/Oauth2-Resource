package com.oauth.resource.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oauth.resource.dao.api.ExampleDao;
import com.oauth.resource.domain.ExampleModel;
import com.oauth.resource.service.GenericServiceImpl;
import com.oauth.resource.service.api.ExampleService;


/**
 * 
 * @authors  Hassan.khani
 * @version 1.1.20170512
 * @change 
 * @target
 * 
 */
 

@Service
public class ExampleServiceImpl extends GenericServiceImpl<ExampleModel, Long> implements ExampleService {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	ExampleDao exampleDao; 
	
}
