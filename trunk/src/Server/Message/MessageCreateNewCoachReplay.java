package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageCreateNewCoachReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewCoachReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_COACH_REPLAY);
		this.x =x;
	}

    public int getBoolean() {
		return x;
	}
   
}