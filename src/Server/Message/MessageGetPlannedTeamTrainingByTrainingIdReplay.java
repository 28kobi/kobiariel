package Server.Message;

import Server.DataBase.plannedteamtraining;
import Server.logic.*;


public class MessageGetPlannedTeamTrainingByTrainingIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private plannedteamtraining plannedteamtraining1;
/**
 * constructor
 */
 	
    public MessageGetPlannedTeamTrainingByTrainingIdReplay(plannedteamtraining plannedTeamtraining) {
		super(MessageType.MESSAGE_GET_TEAM_TRAINING_BY_TRAINING_ID_REPLAY);
		this.setPlannedteamtraining(plannedTeamtraining);
	}
public plannedteamtraining getPlannedteamtraining() {
	return plannedteamtraining1;
}
public void setPlannedteamtraining(plannedteamtraining plannedteamtraining) {
	this.plannedteamtraining1 = plannedteamtraining;
}



}