
package Server.Message;

import java.util.ArrayList;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.DataBase.trainingtype;
import Server.logic.*;


public class MessageGetAllTrainingTypeReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<trainingtype> trainingType;
/**
 * constructor
 */
 	
    public MessageGetAllTrainingTypeReplay(ArrayList<trainingtype> trainingType) {
		super(MessageType.MESSAGE_GET_ALL_TRAINING_TYPE_REPLAY);
		this.trainingType =trainingType;
	}

    public ArrayList<trainingtype> getArray() {
		return trainingType;
	}
    public void setTrainingArray(ArrayList<trainingtype> trainingType)
    {
	          this.trainingType=trainingType;
    }

}