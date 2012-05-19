package Server.Message;

import Server.logic.*;


public class MessageUpdateAthleteReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean x;
/**
 * constructor
 */
 	
    public MessageUpdateAthleteReplay(boolean x) {
		super(MessageType.MESSAGE_UPDATE_ATHLETE_REPLAY);
		this.x =x;
	}

    public boolean getBoolean() {
		return x;
	}
   
}