package Server.Message;

import Server.logic.Message;

/**********************************************
 * Kobi & Ariel
 * @author 
 **** 
 ******          
 ********
 *********/
public class MessageLogin extends Message {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
	public MessageLogin(String userName, String password) {
		super(MessageType.MESSAGE_LOGIN);
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
