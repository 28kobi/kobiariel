
package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.logic.*;


public class MessageGetAllAactivityTypeReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<activitytype> activityType;
/**
 * constructor
 */
 	
    public MessageGetAllAactivityTypeReplay(ArrayList<activitytype> activityType) {
		super(MessageType.MESSAGE_GET_ALL_ACTIVITY_TYPE_REPLAY);
		this.activityType =activityType;
	}

    public ArrayList<activitytype> getArray() {
		return activityType;
	}
    public void setActivityArray(ArrayList<activitytype> activityType)
    {
	          this.activityType=activityType;
    }

}