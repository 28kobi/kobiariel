
package Server.Message;

import Server.logic.*;


public class MessageUpdateAthleteTrainingReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageUpdateAthleteTrainingReplay(int x) {
		super(MessageType.MESSAGE_UPDATE_ATHLETE_TRAINING_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}