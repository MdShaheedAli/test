package com.example.FileAndMail.FileAndMail.Service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailImpl implements SendMailInter {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public String send(String data) {
		JSONObject json = new JSONObject(data);
		String to = json.getString("to");
		String subject = json.getString("subject");
		String body = json.getString("body");

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);

		javaMailSender.send(simpleMailMessage);
		return "success";
	}

	@Override
	public String sendAttachmentMail(String data) {
		JSONObject json = new JSONObject(data);
		String to = json.getString("to");
		String subject = json.getString("subject");
		String body = json.getString("body");
		File file = new File("C:\\Users\\admin\\Downloads\\vehicle (8).sql");
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);
			mimeMessageHelper.addAttachment("vinList", file);
			mimeMessageHelper.addAttachment("vinList2", file);
			javaMailSender.send(mimeMessage);
			return "success";
		} catch (MessagingException e) {

			e.printStackTrace();
		}

		return "Error";

	}

}
