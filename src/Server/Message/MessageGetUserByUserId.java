package Server.Message;

import Server.logic.Message;
import Server.logic.Message.MessageType;

public class MessageGetUserByUserId extends Message{
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
	
	
	/**
	 * constructor
	 */
	public MessageGetUserByUserId(int userId) {
			super(MessageType.MESSAGE_GET_USER_BY_USER_ID);
			this.setUserId(userId);
			
		}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}





}
