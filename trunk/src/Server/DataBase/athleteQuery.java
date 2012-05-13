
package Server.DataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	
	

}

