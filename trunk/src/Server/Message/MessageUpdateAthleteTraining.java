package Server.Message;

import Server.DataBase.*;
import Server.logic.*;



public class MessageUpdateAthleteTraining extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private plannedpersonaltraining training;
/**
 * constructor
 */
public  MessageUpdateAthleteTraining(plannedpersonaltraining AthleteTraining) {
		super(MessageType.MESSAGE_UPDATE_ATHLETE_TRAINING);
		this.training=AthleteTraining;
	}

public plannedpersonaltraining gettraining() {
	return training;
}

}
