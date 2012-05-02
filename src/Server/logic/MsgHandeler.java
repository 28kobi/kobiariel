package Server.logic;

import java.io.IOException;
import java.sql.SQLException;
import ocsf.server.ConnectionToClient;
/**
 * 
 * class handle all the massage that the client communicate with server
 *  
 *
 */
public class MsgHandeler {
	
	private Message message;
	private ConnectionToClient client;
	/**
	 * constructor MsgHandeler
	 * @param message
	 * @param client
	 */
	public MsgHandeler(Object message, ConnectionToClient client){
		this.message = (Message) message;
		this.client = client;
	}
	/**
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * 
	 * msg switch cases of message type to server
	 */
	
	public void msgHandeler() throws SQLException, IOException {
		switch (message.getMessageType()){
		case MESSAGE_LOGIN:
		
		
		
		}
	}
	
	
	
	
	
	
	
}
