package com.jk.testservice.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages= {"com.jk"})
public class ApplicationExceptionHandler {
	/**
     * Exception handler for handling any exception
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<ApiError> handleException(Exception ex) {
        return new ResponseEntity<ApiError>(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}