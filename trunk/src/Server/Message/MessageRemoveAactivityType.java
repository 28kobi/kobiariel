
package Server.Message;

import Server.DataBase.activitytype;
import Server.logic.*;



public class MessageRemoveAactivityType extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private activitytype activityType;
	 
/**
 * constructor
 */
public MessageRemoveAactivityType(activitytype activityType) {
		super(MessageType.MESSAGE_REMOVE_ACTIVITY_TYPE);
		this.setActivityType(activityType);
	}

public activitytype getActivityType() {
	return activityType;
}

public void setActivityType(activitytype activityType) {
	this.activityType = activityType;
}

}
