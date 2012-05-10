package Server.DataBase;
import java.io.Serializable;


public class Team implements Serializable{
	
	/**
	 //private static final long serialVersionUID = 1L;
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TeamId  number
	 */
	private int TeamId;
	
	/**
	 * TeamName
	 */
	private String TeamName;
	
	/**
	 * CoachId
	 */
	private int CoachId;
	
	
	
	
	
	/**
	 * builder 
	 */
	public Team(int TeamId,int CoachId , String TeamName) {
		super();
		this.TeamId=TeamId;
		this.CoachId=CoachId;
		this.TeamName=TeamName;
		
	}

	
	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public int getCoachId() {
		return CoachId;
	}

	public void setCoachId(int coachId) {
		CoachId = coachId;
	}
	public String toString() {
		return TeamName;
	}
	

	
}