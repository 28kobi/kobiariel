package Server.Message;

import Server.DataBase.User;
import Server.DataBase.athlete;
import Server.logic.*;


public class MessageGetAthleteByUserIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private athlete athlete;
/**
 * constructor
 */
 	
    public MessageGetAthleteByUserIdReplay(athlete athlete) {
		super(MessageType.MESSAGE_GET_ATHLETE_BY_USER_ID_REPLAY);
		this.athlete =athlete;
	}

    public athlete getAthlete() {
		return athlete;
	}


}