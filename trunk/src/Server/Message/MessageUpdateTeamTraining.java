package Server.Message;

import Server.DataBase.*;
import Server.logic.*;



public class MessageUpdateTeamTraining extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private plannedteamtraining training;
/**
 * constructor
 */
public  MessageUpdateTeamTraining(plannedteamtraining teamTraining) {
		super(MessageType.MESSAGE_UPDATE_TEAMTRAINING);
		this.training=teamTraining;
	}

public plannedteamtraining gettraining() {
	return training;
}

}
