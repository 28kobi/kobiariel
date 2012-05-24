
package Server.Message;

import Server.DataBase.trainingtype;
import Server.logic.*;

public class MessageCreateNewTrainingType extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private trainingtype trainingType;
/**
 * constructor
 */
public  MessageCreateNewTrainingType(trainingtype trainingType) {
		super(MessageType.MESSAGE_CREATE_NEW_TRAINING_TYPE);
		this.setTrainingType(trainingType);
	}
public trainingtype getTrainingType() {
	return trainingType;
}
public void setTrainingType(trainingtype trainingType) {
	this.trainingType = trainingType;
}



}
