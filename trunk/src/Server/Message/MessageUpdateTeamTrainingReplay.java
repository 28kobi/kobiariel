package Server.Message;

import Server.logic.*;


public class MessageUpdateTeamTrainingReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageUpdateTeamTrainingReplay(int x) {
		super(MessageType.MESSAGE_UPDATE_TEAMTRAINING_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}