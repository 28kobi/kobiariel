package Server.Message;
import Server.logic.*;


public class MessageCreateNewTeamTrainingReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewTeamTrainingReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_TEAM_TRAINING_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}