package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;


public class MessageGetAllusersReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<User> UserArray;
/**
 * constructor
 */
 	
    public MessageGetAllusersReplay(ArrayList<User> array) {
		super(MessageType.MESSAGE_GET_ALL_USER_REPLAY);
		this.setUserArray(array);
	}
public ArrayList<User> getUserArray() {
	return UserArray;
}
public void setUserArray(ArrayList<User> userArray) {
	UserArray = userArray;
}

   

}