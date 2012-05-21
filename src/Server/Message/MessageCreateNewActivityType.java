package Server.Message;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.logic.*;

public class MessageCreateNewActivityType extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private activitytype activity;
/**
 * constructor
 */
public  MessageCreateNewActivityType(activitytype activityType) {
		super(MessageType.MESSAGE_CREATE_NEW_ACTIVITY_TYPE);
		this.activity=activityType;
	}

public activitytype getActivity() {
	return activity;
}

}
