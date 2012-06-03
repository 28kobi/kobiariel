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
public class PreformedTeamTrainingQuery extends Query{
	
	
	
		
	public PreformedTeamTrainingQuery() {
		super();
	}
	


public int addPlannedPreformedTeamTrainingByAthlete(PreformedTeamTraining PreformedTeamTraining) throws SQLException{
	
	
	setQuery("INSERT INTO preformedteamtraining(athleteId,trainingId, activityid, trainingTypeId,time,details,duration,distance,date) VALUES(?,?,?,?,?,?,?,?,?)");
	PreparedStatement query2 = getPS();
	query2.setInt(1, PreformedTeamTraining.getAthleteId());
	query2.setInt(2, PreformedTeamTraining.getTrainingId());
	query2.setInt(3, PreformedTeamTraining.getActivityid());
	query2.setInt(4, PreformedTeamTraining.getTrainingTypeId());
	query2.setString(5,PreformedTeamTraining.getTime());
	query2.setString(6,PreformedTeamTraining.getDetails());
	query2.setString(7,PreformedTeamTraining.getDuration());
	query2.setString(8,PreformedTeamTraining.getDistance());
	query2.setString(9,PreformedTeamTraining.getDate());
	query2.executeUpdate();
	query2.close();
	
	return 1;
}

public ArrayList<PreformedTeamTraining> getAllTeamPlannedTrainingPreformedByAthlete(int athleteId, int trainingId) throws SQLException{
	
	ArrayList<PreformedTeamTraining> array = new ArrayList<PreformedTeamTraining>();
	
	setQuery("SELECT * FROM preformedteamtraining " + "WHERE athleteId  = '"+athleteId+"'AND trainingId='"+trainingId+"'");
		ResultSet rs = execQuery();
		while (rs.next()){				
			PreformedTeamTraining PreformedTeamTraining = null;
			try {
				PreformedTeamTraining = new PreformedTeamTraining(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				array.add(PreformedTeamTraining);
			}
	  
	  return array;
	  }

public ArrayList<PreformedTeamTraining> getAllPersonalPreformedTeamTrainingByAthlete(int athleteId) throws SQLException{
	
	ArrayList<PreformedTeamTraining> array = new ArrayList<PreformedTeamTraining>();
	
	setQuery("SELECT * FROM preformedteamtraining " + "WHERE athleteId  = '"+athleteId+"'");
		ResultSet rs = execQuery();
		while (rs.next()){				
			PreformedTeamTraining Preformedtraining = null;
			try {
				Preformedtraining = new PreformedTeamTraining(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				array.add(Preformedtraining);
			}
	  
	  return array;
	  }
public ArrayList<PreformedTeamTraining> getAllTrainingPreformedByTrainingId(int trainingId) throws SQLException{
	
	ArrayList<PreformedTeamTraining> array = new ArrayList<PreformedTeamTraining>();
	
	setQuery("SELECT * FROM preformedteamtraining " + "WHERE trainingId  = '"+trainingId+"'");
		ResultSet rs = execQuery();
		while (rs.next()){				
			PreformedTeamTraining PreformedTeamTraining = null;
			try {
				PreformedTeamTraining = new PreformedTeamTraining(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				array.add(PreformedTeamTraining);
			}
	  
	  return array;
	  }


}

