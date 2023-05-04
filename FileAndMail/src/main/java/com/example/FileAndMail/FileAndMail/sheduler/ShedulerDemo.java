package com.example.FileAndMail.FileAndMail.sheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ShedulerDemo {

	@Scheduled(cron = "0 0/1 * * * ?", zone = "Asia/Kolkata")
	public void sheduler() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("-------Java cron job expression:: --------------- " +strDate);
	}

}
