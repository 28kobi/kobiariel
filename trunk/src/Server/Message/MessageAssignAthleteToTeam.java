

package Server.Message;


import Server.logic.*;



public class MessageAssignAthleteToTeam extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userid;
	private int teamhid;
/**
 * constructor
 */
public  MessageAssignAthleteToTeam(int userid,int teamid) {
		super(MessageType.MESSAGE_ASSIGN_ATHLETE_TO_TEAM);
		this.userid=userid;
		this.teamhid=teamid;
	}


public int getTeamhid() {
	return teamhid;
}
public void setTeamhid(int teamhid) {
	this.teamhid = teamhid;
}


public int getUserid() {
	return userid;
}


public void setUserid(int userid) {
	this.userid = userid;
}



}
