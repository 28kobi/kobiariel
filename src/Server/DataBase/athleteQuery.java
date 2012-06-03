
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
public class athleteQuery extends Query{
	
	public athleteQuery() {
		super();
	}

	
	
	public int addAthleteToTeam(int userid,int TeamId) throws SQLException{
		setQuery("INSERT INTO athlete(UserId, TeamId) VALUES(?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, userid);
		query2.setInt(2, TeamId);
		query2.executeUpdate();
		query2.close();
		return 1;
	}
	
	
	public int removeAthleteFromTeam(int userid) throws SQLException{
		setQuery("DELETE FROM athlete WHERE UserId= '"+userid+"'");
		PreparedStatement query2 = getPS();
		query2.executeUpdate();
		query2.close();
		return 1;
	}
	public athlete getAthleteByUserId(int UserId) throws SQLException{
		setQuery("SELECT * FROM athlete " + "WHERE UserId = '"+UserId+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			athlete athlete = new athlete(UserId, rs.getInt(2));
			return athlete;
		}
		return null;
	}
	public ArrayList<athlete> getAllAthleteByTeamId(int teamId) throws SQLException{
		ArrayList<athlete> array = new ArrayList<athlete>();
		setQuery("SELECT * FROM athlete " + "WHERE TeamId = '"+teamId+"'");
		ResultSet rs = execQuery();
		
		while (rs.next()){				
			athlete athlete1 = null;
			try {
				athlete1 = new athlete(rs.getInt(1), teamId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				array.add(athlete1);
		}
		return array;
	}

}

