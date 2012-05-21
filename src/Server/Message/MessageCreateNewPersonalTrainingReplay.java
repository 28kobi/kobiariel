
package Server.Message;
import Server.logic.*;


public class MessageCreateNewPersonalTrainingReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewPersonalTrainingReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_PERSONAL_TRAINING_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}