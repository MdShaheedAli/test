package com.example.FileAndMail.FileAndMail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FileAndMail.FileAndMail.Service.SendMailInter;

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class SendMailController {
	
	@Autowired
	SendMailInter sendMailInter;
	
	@PostMapping("/sendMail")
	public String send(@RequestBody String data) {
		return sendMailInter.send(data);
	}
	
	@PostMapping("/sendAttachmentMail")
	public String sendAttachmentMail(@RequestBody String data) {
		return sendMailInter.sendAttachmentMail(data);
	}

}
