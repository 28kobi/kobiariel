package Server.Message;

import Server.logic.*;



public class MessageGetAllTeamByCoachId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int coachId;
/**
 * constructor
 */
public MessageGetAllTeamByCoachId(int coachId) {
		super(MessageType.MESSAGE_GET_ALL_TEAM_BY_COACH_ID);
		this.setCoachId(coachId);
	}
public int getCoachId() {
	return coachId;
}
public void setCoachId(int coachId) {
	this.coachId = coachId;
}

}
