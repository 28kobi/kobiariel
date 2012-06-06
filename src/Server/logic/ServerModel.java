package Server.logic;


import java.io.IOException;
import java.sql.SQLException;

import Server.logic.ServerPanel;
import ocsf.server.*;
/**********************************************
 * 
 * @author 
 **** 
 ******          
 ********
 *********/




/*
 */
public class ServerModel extends AbstractServer 
{
  
	final public static int DEFAULT_PORT = 5555;
 	
	public ServerModel(int port, ServerPanel panel) {
		super(port);
	}

	public void handleMessageFromClient (Object msg, ConnectionToClient client)
	{
		MsgHandeler mh = new MsgHandeler(msg, client);
		try {
			mh.msgHandeler();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void serverStarted()
	{
		System.out.println
		("Server listening for connections on port " + getPort());
	}
  
	protected void serverStopped()
	{
		System.out.println
		("Server has stopped listening for connections.");
	} 
}
