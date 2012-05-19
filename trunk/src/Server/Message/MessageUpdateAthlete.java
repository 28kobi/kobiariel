package Server.Message;

import Server.DataBase.User;
import Server.logic.*;



public class MessageUpdateAthlete extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User athlete;
/**
 * constructor
 */
public  MessageUpdateAthlete(User athlete) {
		super(MessageType.MESSAGE_UPDATE_ATHLETE);
		this.athlete=athlete;
	}

public User getathlete() {
	return athlete;
}

}
