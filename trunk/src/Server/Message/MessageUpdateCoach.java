package Server.Message;

import Server.DataBase.User;
import Server.logic.*;



public class MessageUpdateCoach extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User coach;
/**
 * constructor
 */
public  MessageUpdateCoach(User coach) {
		super(MessageType.MESSAGE_UPDATE_COACH);
		this.coach=coach;
	}

public User getCoach() {
	return coach;
}

}
