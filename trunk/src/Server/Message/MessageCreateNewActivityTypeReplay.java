package Server.Message;
import java.util.ArrayList;
import Server.DataBase.User;
import Server.logic.*;

public class MessageCreateNewActivityTypeReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
/**
 * constructor
 */
 	
    public MessageCreateNewActivityTypeReplay(int x) {
		super(MessageType.MESSAGE_CREATE_NEW_ACTIVITY_TYPE_REPLAY);
		this.x =x;
	}

    public int getint() {
		return x;
	}
   
}