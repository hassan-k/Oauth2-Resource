package com.oauth.resource.view;


import java.util.ArrayList;
import java.util.List;

import com.oauth.resource.domain.ErrorModel;

/**
 * Error object holder, send for multiple
 *
 * @author Hassan.khani
 */

public class ErrorsWrapper {

	private final List<ErrorModel> errors;

	public ErrorsWrapper() {
		this.errors = new ArrayList<>();
	}

	public void add(ErrorModel errorModel) {
		errors.add(errorModel);
	}

	public List<ErrorModel> getErrors() {
		return errors;
	}
}
