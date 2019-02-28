package com.jk.testservice.controller;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ApiErrorController implements ErrorController {

	private final static String ERROR_PATH = "/error";
	
	@GetMapping("/error")
	private ResponseEntity<Map<String, Object>> getError(WebRequest request){
		ErrorAttributes err = new DefaultErrorAttributes(true);
		return new ResponseEntity<>(err.getErrorAttributes(request, false), HttpStatus.OK);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	
}
