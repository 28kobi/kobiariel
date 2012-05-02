package Server.Message;

import Server.DataBase.User;
import Server.logic.Message;

public class MessageLoginReplay extends Message{
	/**********************************************
	 * (BDT)Baglama Developer Team software
	 * @author 
	 **** 
	 ******          
	 ********
	 *********/
	private static final long serialVersionUID = 1L;
	
	private boolean pass = false;
	private User user = null;
	private String msg = null;
	/**
	 * 
	 * @param pass
	 * @param user
	 * @param msg
	 */
	public MessageLoginReplay(Boolean pass, User user, String msg) {
		super(MessageType.MESSAGE_LOGIN_REPLY);
		this.pass = pass;
		this.user = user;
		this.msg = msg;
	}
	/**
	 * 
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}
/**
 * 
 * @return pass
 */
	public boolean isPass() {
		return pass;
	}
/**
 * 
 * @return user
 */
	public User getUser() {
		return user;
	}


}
