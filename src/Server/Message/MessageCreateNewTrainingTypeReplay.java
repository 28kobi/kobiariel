
package Server.Message;
import Server.logic.Message;

public class MessageCreateNewTrainingTypeReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewTrainingTypeReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_TRAINING_TYPE_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}