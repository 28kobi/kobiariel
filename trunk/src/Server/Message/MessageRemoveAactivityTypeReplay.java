
package Server.Message;

import Server.logic.Message;


public class MessageRemoveAactivityTypeReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageRemoveAactivityTypeReplay(int x) {
		super(MessageType.MESSAGE_REMOVE_ACTIVITY_TYPE_REPLAY);
		this.x=x;
	}
public int getSeccsses() {
	return x;
}
public void setSeccsses(int x) {
	this.x = x;
}

    
}