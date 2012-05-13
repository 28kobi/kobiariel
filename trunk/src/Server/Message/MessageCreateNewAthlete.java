package Server.Message;

import Server.DataBase.User;
import Server.logic.*;



public class MessageCreateNewAthlete extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User athlete;
/**
 * constructor
 */
public  MessageCreateNewAthlete(User athlete) {
		super(MessageType.MESSAGE_CREATE_NEW_ATHLETE);
		this.athlete=athlete;
	}

public User getAthlete() {
	return this.athlete;
}

}
