package Server.Message;
import Server.DataBase.User;
import Server.logic.*;


public class MessageGetUserByUserIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
/**
 * constructor
 */
 	
    public MessageGetUserByUserIdReplay(User user) {
		super(MessageType.MESSAGE_GET_USER_BY_USER_ID_REPLAY);
		this.user =user;
	}

    public User getCoach() {
		return user;
	}


}