package Server.Message;

import Server.DataBase.plannedpersonaltraining;
import Server.logic.*;


public class MessageGetPlannedTrainingByTrainingIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private plannedpersonaltraining plannedpersonaltraining1;
/**
 * constructor
 */
 	
    public MessageGetPlannedTrainingByTrainingIdReplay(plannedpersonaltraining plannedtraining) {
		super(MessageType.MESSAGE_GET_TRAINING_BY_TRAINING_ID_REPLAY);
		this.setPlannedpersonaltraining(plannedtraining);
	}
public plannedpersonaltraining getPlannedpersonaltraining() {
	return plannedpersonaltraining1;
}
public void setPlannedpersonaltraining(plannedpersonaltraining plannedpersonaltraining) {
	this.plannedpersonaltraining1 = plannedpersonaltraining;
}


}