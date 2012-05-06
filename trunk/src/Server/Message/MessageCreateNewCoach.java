
package Server.Message;

import Server.DataBase.User;
import Server.logic.*;



public class MessageCreateNewCoach extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User coach;
/**
 * constructor
 */
public  MessageCreateNewCoach(User coach) {
		super(MessageType.MESSAGE_CREATE_NEW_COACH);
		this.coach=coach;
	}

public User getCoach() {
	return coach;
}

}
