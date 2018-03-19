package com.oauth.resource.util;


import org.apache.log4j.Logger;
import org.hibernate.metamodel.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oauth.resource.domain.ErrorModel;
import com.oauth.resource.view.ErrorsWrapper;



@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private final static Logger logger = Logger.getLogger(RestExceptionHandler.class);

	public RestExceptionHandler() {
		super();
	}

	/**
	 * 400: Incorrect page number handler
	 */
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorModel handleBadRequest(final ValidationException ex) {
		return new ErrorModel("page_number_incorrect", "The page number is not correct");
	}

	/**
	 * 400: Model objects validation errors handler. ResponseEntityExceptionHandler already provides a method
	 * to handle MethodArgumentNotValidException, so we can't create a new one (it will throw "ambiguous handler"
	 * exception) and we have to override the parent one.
	 */
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorsWrapper errors = new ErrorsWrapper();
		for (FieldError fieldError: ex.getBindingResult().getFieldErrors()) {
			errors.add(new ErrorModel(fieldError));
		}
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}


	/**
	 * 404: Resource not found
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected ErrorModel handleNotFound(final Exception ex, final WebRequest request) {
		ResourceNotFoundException rnfex = (ResourceNotFoundException) ex;
		if (rnfex.getResourceId() == 0) {
			return new ErrorModel("resource_not_found", "List of " + rnfex.getResourceName() + " is empty");
		} else {
			return new ErrorModel("resource_not_found", "Entity " + rnfex.getResourceName() + " with id " + rnfex.getResourceId() + " not found");
		}
	}

	/**
	 * 409: Resource already exist
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	protected ErrorModel handleConflict(final Exception ex, final WebRequest request) {
		ResourceNotFoundException rnfex = (ResourceNotFoundException) ex;
		logger.error(ex);
		return new ErrorModel("resource_exists", "The resource already exists in " + rnfex.getResourceName());
	}

	/**
	 * 503: Generic fall-through handler
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorModel handleInternal(final Exception ex, final WebRequest request) {
		logger.error(ex);
		return new ErrorModel("server_error", ex.getMessage());
	}

}
