package Server.Message;

import Server.logic.*;



public class MessageGetAllUnPreformedTeamTrainingByTeamId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int teamid;
/**
 * constructor
 */
public MessageGetAllUnPreformedTeamTrainingByTeamId(int teamId) {
		super(MessageType.MESSAGE_GET_ALL_UN_PREFORMED_TEAM_TRAINING_BY_TEAM_ID);
		this.teamid=teamId;
	}
public int getteamid() {
	return teamid;
}
public void setteamid(int teamid) {
	this.teamid = teamid;
}

}
