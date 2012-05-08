package Server.logic;

import java.io.IOException;
import java.sql.SQLException;

import Server.DataBase.TeamQuery;
import Server.DataBase.User;
import Server.DataBase.UserQuery;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllTeamReplay;
import Server.Message.MessageLogin;
import Server.Message.MessageLoginReplay;
import Server.Message.MessageLogout;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;
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
		case MESSAGE_GET_ALL_COACH:
			UserQuery UserQuery = new UserQuery();
			MessageGetAllCoachReplay mgsr = new MessageGetAllCoachReplay(UserQuery.getAllCoach());
			client.sendToClient(mgsr);
			UserQuery.close();
			break;
		case MESSAGE_UPDATE_COACH:
			UserQuery UserQuery1 = new UserQuery();
			MessageUpdateCoach Messageupdatecoach = (MessageUpdateCoach) message ;
			MessageUpdateCoachReplay mgsr1 = new MessageUpdateCoachReplay(UserQuery1.UpdateUser(Messageupdatecoach.getCoach()));
			client.sendToClient(mgsr1);
			UserQuery1.close();
			break;
		case MESSAGE_CREATE_NEW_COACH:
			UserQuery UserQuery2 = new UserQuery();
			int Privilge=1,online=0;
			MessageCreateNewCoach MessageCreateNewCoach = (MessageCreateNewCoach) message ;
			MessageCreateNewCoachReplay mgsr2 = new MessageCreateNewCoachReplay(UserQuery2.addUser(MessageCreateNewCoach.getCoach().getFirstName(),MessageCreateNewCoach.getCoach().getLastName(),MessageCreateNewCoach.getCoach().getUserName(),MessageCreateNewCoach.getCoach().getPassword(), Privilge,MessageCreateNewCoach.getCoach().getPhoneNumber(),MessageCreateNewCoach.getCoach().getAddress(),online));
			client.sendToClient(mgsr2);
			UserQuery2.close();
			break;
		case MESSAGE_GET_ALL_TEAM:
			TeamQuery TeamQuery1 = new TeamQuery();
			MessageGetAllTeamReplay mgsr11 = new MessageGetAllTeamReplay(TeamQuery1.getAllTeams());
			client.sendToClient(mgsr11);
			TeamQuery1.close();
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
