package Server.Message;

import Server.logic.*;



public class MessageGetAllUnPreformedPersonalTrainingByAtleteId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int athleteId;
/**
 * constructor
 */
public MessageGetAllUnPreformedPersonalTrainingByAtleteId(int Athletid) {
		super(MessageType.MESSAGE_GET_ALL_UN_PREFORMED_PERSONAL_TRAINING_BY_ATHLETE_ID);
		this.setAthleteId(Athletid);
	}
public int getAthleteId() {
	return athleteId;
}
public void setAthleteId(int athleteId) {
	this.athleteId = athleteId;
}


}
