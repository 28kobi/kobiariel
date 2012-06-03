package Server.Message;

import java.util.ArrayList;
import Server.DataBase.plannedteamtraining;
import Server.logic.*;


public class MessageGetAllTeamUnPreformedTrainingByTeamIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<plannedteamtraining> TeamTrainingArray;
/**
 * constructor
 */
 	
    public MessageGetAllTeamUnPreformedTrainingByTeamIdReplay(ArrayList<plannedteamtraining> array) {
		super(MessageType.MESSAGE_GET_ALL_UN_PREFORMED_TEAM_TRAINING_BY_TEAM_ID_REPLAY);
		this.TeamTrainingArray =array;
	}

    public ArrayList<plannedteamtraining> getArray() {
		return TeamTrainingArray;
	}
    public void setAthleteArray(ArrayList<plannedteamtraining> TeamTrainingArray1)
    {
	          this.TeamTrainingArray=TeamTrainingArray1;
    }

}