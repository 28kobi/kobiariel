package Server.Message;

import Server.logic.*;



public class MessageCreateNewTeam extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int coachId;
	private String teamName;
/**
 * constructor
 */
public  MessageCreateNewTeam(int coachId,String teamName) {
		super(MessageType.MESSAGE_CREATE_NEW_TEAM);
		this.coachId=coachId;
		this.teamName=teamName;
		
	}


public int getCoachId() {
	return coachId;
}

public void setCoachId(int coachId) {
	this.coachId = coachId;
}

public String getTeamName() {
	return teamName;
}

public void setTeamName(String teamName) {
	this.teamName = teamName;
}

}
