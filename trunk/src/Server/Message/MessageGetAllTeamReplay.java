

package Server.Message;

import java.util.ArrayList;

import Server.DataBase.Team;
import Server.logic.*;


public class MessageGetAllTeamReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> TeamArray;
/**
 * constructor
 */
 	
    public MessageGetAllTeamReplay(ArrayList<Team> array) {
		super(MessageType.MESSAGE_GET_ALL_TEAM_REPLAY);
		this.TeamArray =array;
	}

    public ArrayList<Team> getArray() {
		return TeamArray;
	}
    public void setTeamArray(ArrayList<Team> TeamArray)
    {
	          this.TeamArray=TeamArray;
    }

}

