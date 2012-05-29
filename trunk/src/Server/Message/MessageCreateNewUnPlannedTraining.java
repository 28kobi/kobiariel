package Server.Message;

import Server.DataBase.PreformedPersonalTraining;
import Server.DataBase.plannedteamtraining;
import Server.logic.*;

public class MessageCreateNewUnPlannedTraining extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PreformedPersonalTraining Preformedtraining;
/**
 * constructor
 */
public  MessageCreateNewUnPlannedTraining(PreformedPersonalTraining Preformedtraining) {
		super(MessageType.MESSAGE_CREATE_NEW_TEAM_UN_PLANNED_TRAINING);
		this.Preformedtraining=Preformedtraining;
	}
public PreformedPersonalTraining getPreformedtraining() {
	return Preformedtraining;
}
public void setPreformedtraining(PreformedPersonalTraining Preformedtraining) {
	this.Preformedtraining = Preformedtraining;
}


}
