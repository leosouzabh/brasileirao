package br.com.montreal.script.manager.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseApiController {

	public BaseApiController() {
		super();
	}

	protected ResponseEntity<Object> errorHandle(String msg, HttpStatus httpStatus) {
		Map<String, String> responseBody = new HashMap<String, String>();
		responseBody.put("message", msg);
		return new ResponseEntity<Object>(responseBody, httpStatus);
	}

}