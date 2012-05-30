package Server.Message;

import Server.logic.*;



public class MessageGetAllPreformedTrainingByAtleteId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int athleteId;
/**
 * constructor
 */
public MessageGetAllPreformedTrainingByAtleteId(int Athletid) {
		super(MessageType.MESSAGE_GET_ALL_PEFORMED_PERSONAL_TRAINING_BY_ATHLETE);
		this.setAthleteId(Athletid);
	}
public int getAthleteId() {
	return athleteId;
}
public void setAthleteId(int athleteId) {
	this.athleteId = athleteId;
}


}
