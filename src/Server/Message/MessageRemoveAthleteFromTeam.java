package Server.Message;


import Server.logic.*;



public class MessageRemoveAthleteFromTeam extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userid;

/**
 * constructor
 */
public  MessageRemoveAthleteFromTeam(int userid) {
		super(MessageType.MESSAGE_REMOVE_ATHLETE_FROM_TEAM);
		this.userid=userid;
		
	}





public int getUserid() {
	return userid;
}


public void setUserid(int userid) {
	this.userid = userid;
}



}
