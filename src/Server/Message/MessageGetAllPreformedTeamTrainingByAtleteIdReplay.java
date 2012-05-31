
package Server.Message;

import java.util.ArrayList;

import Server.DataBase.PreformedPersonalTraining;
import Server.DataBase.PreformedTeamTraining;

import Server.logic.*;


public class MessageGetAllPreformedTeamTrainingByAtleteIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PreformedTeamTraining> PreformedTeamTraining1;
/**
 * constructor
 */
 	
    public MessageGetAllPreformedTeamTrainingByAtleteIdReplay(ArrayList<PreformedTeamTraining> array) {
		super(MessageType.MESSAGE_GET_ALL_PEFORMED_TEAM_TRAINING_BY_ATHLETEG_REPLAY);
		this.setPreformedTeamTraining1(array);
	}
public ArrayList<PreformedTeamTraining> getPreformedTeamTraining1() {
	return PreformedTeamTraining1;
}
public void setPreformedTeamTraining1(ArrayList<PreformedTeamTraining> preformedTeamTraining1) {
	PreformedTeamTraining1 = preformedTeamTraining1;
}



}