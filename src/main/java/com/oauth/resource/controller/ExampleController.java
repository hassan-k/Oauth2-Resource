package com.oauth.resource.controller;

import java.util.List;
import com.oauth.resource.domain.ExampleModel;
import com.oauth.resource.service.api.ExampleService;
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
@RequestMapping("/api/example")
public class ExampleController {
 
	@Autowired
	ExampleService exampleService;



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
	 * Returns a list of all Examples, supports pagination
	 *
	 * @param page      page number
	 * @param size      page size
	 * @return          Examples list
	 */	  
	 @RequestMapping(value = "/list", method = RequestMethod.GET, params = { "page", "size" })
	 public @ResponseBody List<ExampleModel> getExampleList(@RequestParam int page,@RequestParam int size) {		
			return exampleService.getEntityList(page,size);		
	 }
	 
	 
	  /**
	 * Returns one Example by Example id
	 *
	 * @param id        Example id
	 * @return          Example
	 */	  
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public @ResponseBody ExampleModel getExample(@PathVariable("id") long id) {		
			return exampleService.getEntityById(id);		
	 }
	 
	 
	 /**
	 * Creates a new Example
	 *
	 * @param Example     Example to create	
	 * @return              response Entity
	 */	  	
	 @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public ResponseEntity<ExampleModel> addExample(@RequestBody ExampleModel example){
     		exampleService.saveOrUpdate(example);
     		return new ResponseEntity<ExampleModel>(example, HttpStatus.OK);
	 }
	 		 	 
	 
	 /**
	 * Deletes a Example object
	 *
	 * @param id         Example id
	 * @return           response Entity
	 */	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	 public ResponseEntity<ExampleModel> deleteExample(@PathVariable("id") long id) {
			 exampleService.deleteEntity(id);
			 return new ResponseEntity<ExampleModel>(HttpStatus.OK);	
	 }
	 
}

