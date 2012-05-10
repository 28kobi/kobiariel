


package Server.Message;
import Server.DataBase.Team;
import Server.logic.*;



public class MessageUpdateTeam extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Team team;
/**
 * constructor
 */
public  MessageUpdateTeam(Team team) {
		super(MessageType.MESSAGE_UPDATE_TEAM);
		this.team=team;
	}

public Team getTeam() {
	return team;
}

}
