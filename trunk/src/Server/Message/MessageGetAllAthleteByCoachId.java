package Server.Message;

import Server.logic.*;



public class MessageGetAllAthleteByCoachId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int coachid;
/**
 * constructor
 */
public MessageGetAllAthleteByCoachId(int coachid) {
		super(MessageType.MESSAGE_GET_ALL_ATHLETE_BY_COACH_ID);
		this.setCoachid(coachid);
	}
public int getCoachid() {
	return coachid;
}
public void setCoachid(int coachid) {
	this.coachid = coachid;
}

}
