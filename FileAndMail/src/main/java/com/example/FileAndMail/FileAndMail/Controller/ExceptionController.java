package com.example.FileAndMail.FileAndMail.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class ExceptionController {

	@GetMapping("/hello")
	public ResponseEntity<String> saveFile() {
		// return ResponseEntity.ok().body("helllo");
		
		int a=10/0;
		
		return new ResponseEntity<String>("helllo",HttpStatus.OK);
	}
	
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handler(Exception e){
//		return new ResponseEntity<Object>("Exception occurs it is class level ..",HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}

}
