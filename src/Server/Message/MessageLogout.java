package Server.Message;

import Server.DataBase.User;
import Server.logic.Message;

public class MessageLogout extends Message{

	/**********************************************
	 * (BDT)Baglama Developer Team software
	 * @author 
	 **** 
	 ******          
	 ********
	 *********/
	private static final long serialVersionUID = 1L;
	
	private User user = null;
	 /**
	  * 
	  * @param user
	  */
	public MessageLogout(User user) {
		super(MessageType.MESSAGE_LOGOUT);
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}


}
