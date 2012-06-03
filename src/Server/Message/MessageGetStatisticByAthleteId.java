package Server.Message;

import Server.logic.*;



public class MessageGetStatisticByAthleteId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int athleteId;
/**
 * constructor
 */
public MessageGetStatisticByAthleteId(int athleteId1) {
		super(MessageType.MESSAGE_GET_STATISTIC_BY_ATHLETE_ID);
		this.setAthleteId(athleteId1);
	}
public int getAthleteId() {
	return athleteId;
}
public void setAthleteId(int athleteId1) {
	this.athleteId = athleteId1;
}


}
