package Server.Message;
import Server.DataBase.PreformedTeamTraining;
import Server.logic.*;

public class MessageCreateNewPreformedTeamPlannedTraining extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PreformedTeamTraining PreformedTeamTraining;
/**
 * constructor
 */
public  MessageCreateNewPreformedTeamPlannedTraining(PreformedTeamTraining PreformedTeamTraining) {
		super(MessageType.MESSAGE_CREATE_NEW_PREFORMED_TEAM_PLANNED_TRAINING);
		this.PreformedTeamTraining=PreformedTeamTraining;
	}
public PreformedTeamTraining getPreformedTeamTraining() {
	return PreformedTeamTraining;
}
public void setPreformedTeamTraining(PreformedTeamTraining PreformedTeamTraining) {
	this.PreformedTeamTraining = PreformedTeamTraining;
}


}
