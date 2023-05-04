package com.example.FileAndMail.FileAndMail.webSockets;

import org.json.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class DataPusherToSocket implements Runnable {
	JSONObject json;
	WebSocketSession session;
	TextMessage message;

	public DataPusherToSocket(String data, WebSocketSession session, TextMessage message) {

		this.json = new JSONObject(data);
		this.session = session;
		this.message = message;

	}

	@Override
	public void run() {
		try {
			while (true) {
				if (session.isOpen()) {

					session.sendMessage(new TextMessage("---------web socket message-------"));
					Thread.sleep(10000);

				} else
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
