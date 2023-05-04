package com.example.FileAndMail.FileAndMail.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handler(Exception e) {
		return new ResponseEntity<Object>("Exception occurs its global level..", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
