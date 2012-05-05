package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageGetAllCoachReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<User> CoachArray;
/**
 * constructor
 */
 	
    public MessageGetAllCoachReplay(ArrayList<User> array) {
		super(MessageType.MESSAGE_GET_ALL_COACH_REPLAY);
		this.CoachArray =array;
	}

    public ArrayList<User> getArray() {
		return CoachArray;
	}
    public void setCoachArray(ArrayList<User> CoachArray)
    {
	          this.CoachArray=CoachArray;
    }

}