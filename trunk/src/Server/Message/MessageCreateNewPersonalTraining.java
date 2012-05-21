
package Server.Message;


import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.logic.*;



public class MessageCreateNewPersonalTraining extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private plannedpersonaltraining training;
/**
 * constructor
 */
public  MessageCreateNewPersonalTraining(plannedpersonaltraining training) {
		super(MessageType.MESSAGE_CREATE_NEW_PERSONAL_TRAINING);
		this.training=training;
	}

public plannedpersonaltraining getTraining() {
	return training;
}
public void setTraining(plannedpersonaltraining training) {
	this.training = training;
}


}
