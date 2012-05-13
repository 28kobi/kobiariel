
package Server.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * 
 * @author kobi
 *
 */
public class TeamQuery extends Query{
	
	public TeamQuery() {
		super();
	}
	/**
	 * getTeamByName
	 * @param Teamname
	 * @return team
	 * @throws SQLException
	 */
	public Team getTeamByName(String TeamName) throws SQLException{
		setQuery("SELECT * FROM team " + "WHERE TeamName = '"+TeamName+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			Team team = new Team(rs.getInt(1), rs.getInt(2), rs.getString(3));
			return team;
		}
		return null;
	}
	/**
	 * getUserByTeamid
	 * @param idUser
	 * @return
	 * @throws SQLException
	 */
	public Team getTeamByTeamId(int TeamId) throws SQLException{
		setQuery("SELECT * FROM team " + "WHERE TeamId = '"+TeamId+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			Team team = new Team(TeamId, rs.getInt(2), rs.getString(3));
			return team;
		}
		return null;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public boolean isExist(String TeamName) throws SQLException{
		setQuery("SELECT * FROM team " + "WHERE TeamName = ?");
		PreparedStatement query = getPS();
		query.setString(1, TeamName);
		if (query.executeQuery().next()){
			query.close();
			return true;
		}
		else {
			query.close();
			return false;
		}
	}
	
	
	public int addTeam(int TeamId,int CoachId,String TeamName) throws SQLException{
		Info info = new Info();
		int newTeamId = info.getNewTeamId();
		if (isExist(TeamName)) return 1;
		setQuery("INSERT INTO team(TeamId, CoachId, TeamName) VALUES(?,?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, newTeamId);
		query2.setInt(2, CoachId);
		query2.setString(3, TeamName);
		query2.executeUpdate();
		query2.close();
		info.incTeamId();
		info.close();
		return 1;
	}
	
	
	public ArrayList<Team> getAllTeams() throws SQLException{
		ArrayList<Team> array = new ArrayList<Team>();
		setQuery("SELECT * FROM team ");
		ResultSet rs=execQuery();
		while (rs.next()){
			Team team = new Team(rs.getInt(1), rs.getInt(2), rs.getString(3));		
			array.add(team);
		}
		return array;
	}
	public boolean UpdateTeam(Team team) throws SQLException{
		
		setQuery("UPDATE team set CoachId=?, TeamName=? WHERE TeamId=?");
		PreparedStatement query2 = getPS();
		
		query2.setInt(1, team.getCoachId());
		query2.setString(2, team.getTeamName());
		query2.setInt(3,team.getTeamId());
		query2.executeUpdate();
		query2.close();
		
		return true;
	}
	public ArrayList<Team> getTeamByCoachId(int Coachid) throws SQLException{
		ArrayList<Team> array = new ArrayList<Team>();
		setQuery("SELECT * FROM team " + "WHERE CoachId = '"+Coachid+"'");
		ResultSet rs = execQuery();
		while (rs.next()){
			Team team = new Team(rs.getInt(1), rs.getInt(2), rs.getString(3));		
			array.add(team);
		}
		return array;
	}

}

