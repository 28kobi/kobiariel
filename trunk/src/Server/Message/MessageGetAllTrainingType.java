
package Server.Message;

import Server.logic.*;



public class MessageGetAllTrainingType extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int activityId;
/**
 * constructor
 */
public MessageGetAllTrainingType(int activityId) {
		super(MessageType.MESSAGE_GET_ALL_TRAINING_TYPE);
		this.activityId=activityId;
		
	}
public int getActivityId() {
	return activityId;
}
public void setActivityId(int activityId) {
	this.activityId = activityId;
}

}
