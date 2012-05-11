package Server.Message;

import Server.logic.*;


public class MessageCreateNewTeamReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewTeamReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_TEAM_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}