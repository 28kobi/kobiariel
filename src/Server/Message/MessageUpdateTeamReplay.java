package Server.Message;
import Server.logic.*;


public class MessageUpdateTeamReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean x;
/**
 * constructor
 */
 	
    public MessageUpdateTeamReplay(boolean x) {
		super(MessageType.MESSAGE_UPDATE_TEAM_REPLAY);
		this.x =x;
	}

    public boolean getBoolean() {
		return x;
	}
   
}