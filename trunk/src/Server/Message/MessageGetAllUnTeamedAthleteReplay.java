package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageGetAllUnTeamedAthleteReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<User> AthleteArray;
/**
 * constructor
 */
 	
    public MessageGetAllUnTeamedAthleteReplay(ArrayList<User> array) {
		super(MessageType.MESSAGE_GET_ALL_UNTEAMED_ATHLETE_REPLAY);
		this.AthleteArray =array;
	}

    public ArrayList<User> getArray() {
		return AthleteArray;
	}
   

}