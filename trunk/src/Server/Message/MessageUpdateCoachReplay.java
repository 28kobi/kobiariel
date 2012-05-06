package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageUpdateCoachReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean x;
/**
 * constructor
 */
 	
    public MessageUpdateCoachReplay(boolean x) {
		super(MessageType.MESSAGE_UPDATE_COACH_REPLAY);
		this.x =x;
	}

    public boolean getBoolean() {
		return x;
	}
   
}