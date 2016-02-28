package chat.websocket.server;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/jsr356toUpper")
public class ToUpper356Socket {
	
	private static Set<Session> clients =
			Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("WebSocket opened: " + session.getId());
		clients.add(session);
	}
	@OnMessage
	public void onMessage(String txt, Session session) throws IOException {
		System.out.println("Message received: " + txt);
//		session.getBasicRemote().sendText(txt);
		synchronized(clients){
		      // Iterate over the connected sessions
		      // and broadcast the received message
		      for(Session client : clients){
		        client.getBasicRemote().sendText(txt);
		        }
		}
	}

	@OnClose
	public void onClose(CloseReason reason, Session session) {
		System.out.println("Closing a WebSocket: " + session.getId());
		clients.remove(session);
	}
	
}

