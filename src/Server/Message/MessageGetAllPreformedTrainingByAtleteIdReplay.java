package Server.Message;

import java.util.ArrayList;

import Server.DataBase.PreformedPersonalTraining;

import Server.logic.*;


public class MessageGetAllPreformedTrainingByAtleteIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PreformedPersonalTraining> PreformedPersonalArray;
/**
 * constructor
 */
 	
    public MessageGetAllPreformedTrainingByAtleteIdReplay(ArrayList<PreformedPersonalTraining> array) {
		super(MessageType.MESSAGE_GET_ALL_PEFORMED_PERSONAL_TRAINING_BY_ATHLETE_REPLAY);
		this.setPreformedPersonalArray(array);
	}
public ArrayList<PreformedPersonalTraining> getPreformedPersonalArray() {
	return PreformedPersonalArray;
}
public void setPreformedPersonalArray(ArrayList<PreformedPersonalTraining> preformedPersonalArry) {
	PreformedPersonalArray = preformedPersonalArry;
}


}