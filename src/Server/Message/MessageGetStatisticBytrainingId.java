package Server.Message;

import Server.logic.*;



public class MessageGetStatisticBytrainingId extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int trainingId;
	private int teamId;
/**
 * constructor
 */
public MessageGetStatisticBytrainingId(int trainingId,int teamId) {
		super(MessageType.MESSAGE_GET_TRAINING_STATISTIC_BY_TRAINING_ID);
		this.setTrainingId(trainingId);
		this.setTeamId(teamId);
	}
public int getTrainingId() {
	return trainingId;
}
public void setTrainingId(int trainingId) {
	this.trainingId = trainingId;
}
public int getTeamId() {
	return teamId;
}
public void setTeamId(int teamId) {
	this.teamId = teamId;
}



}
