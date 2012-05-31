package Server.Message;

import Server.logic.*;


public class MessageRemoveAthleteFromTeamReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageRemoveAthleteFromTeamReplay(int x) {
		super(MessageType.MESSAGE_REMOVE_ATHLETE_FROM_TEAM_REPLAY);
		this.x =x;
	}

    public int getsuccssed() {
		return x;
	}
   
}