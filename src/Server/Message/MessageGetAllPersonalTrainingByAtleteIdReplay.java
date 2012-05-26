package Server.Message;

import java.util.ArrayList;
import Server.DataBase.plannedpersonaltraining;
import Server.logic.*;


public class MessageGetAllPersonalTrainingByAtleteIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<plannedpersonaltraining> PersonalTrainingArray;
/**
 * constructor
 */
 	
    public MessageGetAllPersonalTrainingByAtleteIdReplay(ArrayList<plannedpersonaltraining> array) {
		super(MessageType.MESSAGE_GET_ALL_TRAINING_BY_ATHLETE_ID_REPLAY);
		this.setPersonalTrainingArray(array);
	}
public ArrayList<plannedpersonaltraining> getPersonalTrainingArray() {
	return PersonalTrainingArray;
}
public void setPersonalTrainingArray(ArrayList<plannedpersonaltraining> personalTrainingArray) {
	PersonalTrainingArray = personalTrainingArray;
} 

}