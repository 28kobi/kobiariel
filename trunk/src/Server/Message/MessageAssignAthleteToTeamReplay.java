package Server.Message;

import Server.logic.*;


public class MessageAssignAthleteToTeamReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageAssignAthleteToTeamReplay(int x) {
		super(MessageType.MESSAGE_ASSIGN_ATHLETE_TO_TEAM_REPLAY);
		this.x =x;
	}

    public int getsuccssed() {
		return x;
	}
   
}