
package Server.Message;

import Server.logic.*;



public class MessageGetAllTeamTrainingByTeamId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int teamid;
/**
 * constructor
 */
public MessageGetAllTeamTrainingByTeamId(int teamId) {
		super(MessageType.MESSAGE_GET_ALL_TRAINING_BY_TEAM_ID);
		this.teamid=teamId;
	}
public int getteamid() {
	return teamid;
}
public void setteamid(int teamid) {
	this.teamid = teamid;
}

}
