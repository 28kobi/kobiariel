package Server.Message;
import Server.logic.*;


public class MessageCreateNewPreformedTeamPlannedTrainingReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewPreformedTeamPlannedTrainingReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_PREORMED_TEAM_PLANNED_TRAINING_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}