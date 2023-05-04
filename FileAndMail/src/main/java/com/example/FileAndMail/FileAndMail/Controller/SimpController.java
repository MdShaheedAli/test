package com.example.FileAndMail.FileAndMail.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/gg")
@Controller
public class SimpController {

//	@ResponseBody
	@GetMapping("/kk")
	public String run() {
		return "hellllooo";
	}
	
//	@GetMapping("/kk")
//	public String run2() {
//		return "helll2looo";
//	}
}
