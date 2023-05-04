package com.example.FileAndMail.FileAndMail.webSockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketTextHandler extends TextWebSocketHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger("webSocketTextHandler");
//	public WebSocketSession session;
	public JSONObject dboradjson;
	static List<String> webSessions = new ArrayList<String>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		
		String data = message.getPayload();

		dboradjson = new JSONObject(data);
		Thread t1 = new Thread(new DataPusherToSocket(data, session, message));
		t1.start();

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOGGER.error("Session Closing");
		webSessions.remove(session.getId());
	}

}
