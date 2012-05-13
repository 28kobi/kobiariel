
package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageCreateNewAthleteReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int newAthleteId;
/**
 * constructor
 */
 	
    public MessageCreateNewAthleteReplay(int newAthleteId) {
		super(MessageType.MESSAGE_CREATE_NEW_ATHLETE_REPLAY);
		this.newAthleteId =newAthleteId;
	}

    public int getAthelteId() {
		return newAthleteId;
	}
   
}