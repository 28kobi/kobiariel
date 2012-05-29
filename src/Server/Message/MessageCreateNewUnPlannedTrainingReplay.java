package Server.Message;
import Server.logic.*;


public class MessageCreateNewUnPlannedTrainingReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewUnPlannedTrainingReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_TEAM_UN_PLANNED_TRAINING_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}