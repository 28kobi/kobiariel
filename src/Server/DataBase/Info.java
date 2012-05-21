package Server.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *class handle data save in table
 */
public class Info extends Query{

	public Info() {
		super();
	}
	/**
	 * set a new user id
	 * @return new user id num
	 *         else 0 if error 
	 */	
	public int getNewUserId() throws SQLException{
		setQuery("SELECT * FROM info " + "WHERE name = ?");
		PreparedStatement query = getPS();
		query.setString(1, "lastUser");
		ResultSet rs = query.executeQuery();
		if (rs.next()) return rs.getInt(3) + 1;
		else return 0;
	}
	/**
	 *
	 * inc user id
	 */
	public void incUserId() throws SQLException{
		setQuery("UPDATE info "+"SET data = ? WHERE name = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, getNewUserId());
		update.setString(2, "lastUser");
		update.executeUpdate();
		update.close();
	}
	
	public int getNewTeamId() throws SQLException{
		setQuery("SELECT * FROM info " + "WHERE name = ?");
		PreparedStatement query = getPS();
		query.setString(1, "lastTeam");
		ResultSet rs = query.executeQuery();
		if (rs.next()) return rs.getInt(3) + 1;
		else return 0;
	}
	public void incTeamId() throws SQLException{
		setQuery("UPDATE info "+"SET data = ? WHERE name = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, getNewTeamId());
		update.setString(2, "lastTeam");
		update.executeUpdate();
		update.close();
	}
	
	public int getNewActivityId() throws SQLException{
		setQuery("SELECT * FROM info " + "WHERE name = ?");
		PreparedStatement query = getPS();
		query.setString(1, "lastActivityType");
		ResultSet rs = query.executeQuery();
		if (rs.next()) return rs.getInt(3) + 1;
		else return 0;
	}
	public void incActivityId() throws SQLException{
		setQuery("UPDATE info "+"SET data = ? WHERE name = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, getNewTeamId());
		update.setString(2, "lastActivityType");
		update.executeUpdate();
		update.close();
	}
	

	public int getNewTrainingTypeId() throws SQLException{
		setQuery("SELECT * FROM info " + "WHERE name = ?");
		PreparedStatement query = getPS();
		query.setString(1, "lastTrainingType");
		ResultSet rs = query.executeQuery();
		if (rs.next()) return rs.getInt(3) + 1;
		else return 0;
	}
	public void inctrainingTypeId() throws SQLException{
		setQuery("UPDATE info "+"SET data = ? WHERE name = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, getNewTeamId());
		update.setString(2, "lastTrainingType");
		update.executeUpdate();
		update.close();
	}
	
	
	public int getNewPlannedTeamTrainingId() throws SQLException{
		setQuery("SELECT * FROM info " + "WHERE name = ?");
		PreparedStatement query = getPS();
		query.setString(1, "LastPlannedTeamTraining");
		ResultSet rs = query.executeQuery();
		if (rs.next()) return rs.getInt(3) + 1;
		else return 0;
	}
	public void incTeamPlannedTrainingId() throws SQLException{
		setQuery("UPDATE info "+"SET data = ? WHERE name = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, getNewTeamId());
		update.setString(2, "LastPlannedTeamTraining");
		update.executeUpdate();
		update.close();
	}
	
	public int getNewPlannedPersonalTrainingId() throws SQLException{
		setQuery("SELECT * FROM info " + "WHERE name = ?");
		PreparedStatement query = getPS();
		query.setString(1, "LastPlannedTeamTraining");
		ResultSet rs = query.executeQuery();
		if (rs.next()) return rs.getInt(3) + 1;
		else return 0;
	}
	public void incPersonalPlannedTrainingId() throws SQLException{
		setQuery("UPDATE info "+"SET data = ? WHERE name = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, getNewPlannedPersonalTrainingId());
		update.setString(2, "LastPlannedTeamTraining");
		update.executeUpdate();
		update.close();
	}
	
}

