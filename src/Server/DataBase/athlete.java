
package Server.DataBase;
import java.io.Serializable;


public class athlete implements Serializable{
	
	/**
	 //private static final long serialVersionUID = 1L;
	 */
	private static final long serialVersionUID = 1L;
	
	private int Userid;
	
	/**
	 * TeamId  number
	 */
	private int TeamId;
		
	/**
	 * builder 
	 */
	public athlete(int Userid,int TeamId) {
		super();
		this.TeamId=TeamId;
		this.setUserid(Userid);
		
	}

	
	public athlete() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}


	public int getUserid() {
		return Userid;
	}


	public void setUserid(int userid) {
		Userid = userid;
	}

	

	
}