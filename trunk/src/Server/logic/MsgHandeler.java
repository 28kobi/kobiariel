package Server.logic;

import java.io.IOException;
import java.sql.SQLException;
import Server.DataBase.User;
import Server.DataBase.UserQuery;
import Server.Message.MessageLogin;
import Server.Message.MessageLoginReplay;
import Server.Message.MessageLogout;
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
			login();
			break;
		case MESSAGE_LOGOUT: 
			MessageLogout logout = (MessageLogout) message;
			UserQuery userQuery2 = new UserQuery();
			userQuery2.setOffline(logout.getUser().getIdUser());
			userQuery2.close();
			break;
		
		
		
		}
	}
	
	private void login() throws SQLException, IOException{
		String str=null;
		boolean pass =true;
		User user = null;
		MessageLogin login = (MessageLogin) message;
		
		UserQuery userQuery = new UserQuery();
		if (userQuery.isExist(login.getUserName())){
			user = userQuery.getUserByName(login.getUserName());
			if (login.getPassword().equals(user.getPassword())){
				if (user.isOnline()==1){
					pass = false;
					str = "User already login, try again later.";
				}
				
			}
			else {
				str = "Forgot your password? please contact Youre Administrator.";
				pass=false;
			}
		}
		else {
				if (login.getUserName().isEmpty())
					str = "Please enter user name.";
				else
					str = "Wrong user name, please try again.";
				pass= false;
			}
		if (pass) userQuery.setOnline(user.getIdUser());
		userQuery.close();
		client.sendToClient(new MessageLoginReplay(pass, user, str));
	}
	
	
	
	
	
}
