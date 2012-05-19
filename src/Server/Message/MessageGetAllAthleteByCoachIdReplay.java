
package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageGetAllAthleteByCoachIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<User> AthleteArray;
/**
 * constructor
 */
 	
    public MessageGetAllAthleteByCoachIdReplay(ArrayList<User> array) {
		super(MessageType.MESSAGE_GET_ALL_ATHLETE_BY_COACH_ID_REPLAY);
		this.AthleteArray =array;
	}

    public ArrayList<User> getArray() {
		return AthleteArray;
	}
    public void setAthleteArray(ArrayList<User> AthleteArray)
    {
	          this.AthleteArray=AthleteArray;
    }

}