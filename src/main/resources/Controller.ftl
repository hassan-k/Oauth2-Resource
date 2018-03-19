package com.oauth.resource.controller;

import java.util.List;
import com.oauth.resource.domain.${object}Model;
import com.oauth.resource.service.api.${object}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @authors  Hassan.khani
 * @version 1.1.20170601
 * @change 
 * @target
 * 
 */
 

@RestController
@RequestMapping("/api/${object?lower_case}")
public class ${object}Controller {
 
	@Autowired
	${object}Service ${object?lower_case}Service;



	 /**
	 * Test method
	 * 	 
	 * @return Welcome!
	 */
	 @RequestMapping(value = "/test", method = RequestMethod.GET)
	 public String getTest() {		
			return "Welcome!";		
	 }
	
	 
	 /**
	 * Returns a list of all ${object}s, supports pagination
	 *
	 * @param page      page number
	 * @param size      page size
	 * @return          ${object}s list
	 */	  
	 @RequestMapping(value = "/list", method = RequestMethod.GET, params = { "page", "size" })
	 public @ResponseBody List<${object}Model> get${object}List(@RequestParam int page,@RequestParam int size) {		
			return ${object?lower_case}Service.getEntityList(page,size);		
	 }
	 
	 
	  /**
	 * Returns one ${object} by ${object} id
	 *
	 * @param id        ${object} id
	 * @return          ${object}
	 */	  
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public @ResponseBody ${object}Model get${object}(@PathVariable("id") long id) {		
			return ${object?lower_case}Service.getEntityById(id);		
	 }
	 
	 
	 /**
	 * Creates a new ${object}
	 *
	 * @param ${object}     ${object} to create	
	 * @return              response Entity
	 */	  	
	 @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public ResponseEntity<${object}Model> add${object}(@RequestBody ${object}Model ${object?lower_case}){
     		${object?lower_case}Service.saveOrUpdate(${object?lower_case});
     		return new ResponseEntity<${object}Model>(${object?lower_case}, HttpStatus.OK);
	 }
	 		 	 
	 
	 /**
	 * Deletes a ${object} object
	 *
	 * @param id         ${object} id
	 * @return           response Entity
	 */	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	 public ResponseEntity<${object}Model> delete${object}(@PathVariable("id") long id) {
			 ${object?lower_case}Service.deleteEntity(id);
			 return new ResponseEntity<${object}Model>(HttpStatus.OK);	
	 }
	 
}

