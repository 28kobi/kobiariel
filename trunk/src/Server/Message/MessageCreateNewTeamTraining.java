package Server.Message;


import Server.DataBase.plannedteamtraining;
import Server.logic.*;



public class MessageCreateNewTeamTraining extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private plannedteamtraining training;
/**
 * constructor
 */
public  MessageCreateNewTeamTraining(plannedteamtraining training) {
		super(MessageType.MESSAGE_CREATE_NEW_TEAM_TRAINING);
		this.training=training;
	}
public plannedteamtraining getTraining() {
	return training;
}
public void setTraining(plannedteamtraining training) {
	this.training = training;
}


}
