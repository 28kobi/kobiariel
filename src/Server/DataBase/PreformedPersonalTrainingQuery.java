
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
public class PreformedPersonalTrainingQuery extends Query{
	
	
	
		
	public PreformedPersonalTrainingQuery() {
		super();
	}
	
	
	
	public int addUnPlannedTrainingByAthlete(PreformedPersonalTraining Preformedtraining) throws SQLException{
		Info info = new Info();
		int NewUnPlannedPersonalpreformedId = info.getNewUnPlannedPersonalpreformedId();
		
		setQuery("INSERT INTO preformedpersonaltraining(preformedId,athleteId,isplanned,trainingId, activityid, trainingTypeId,time,details,duration,distance,date) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, NewUnPlannedPersonalpreformedId);
		query2.setInt(2, Preformedtraining.getAthleteId());
		query2.setString(3,"true");
		query2.setInt(4, 0);
		query2.setInt(5, Preformedtraining.getActivityid());
		query2.setInt(6, Preformedtraining.getTrainingTypeId());
		query2.setString(7,Preformedtraining.getTime());
		query2.setString(8,Preformedtraining.getDetails());
		query2.setString(9,Preformedtraining.getDuration());
		query2.setString(10,Preformedtraining.getDistance());
		query2.setString(11,Preformedtraining.getDate());
		query2.executeUpdate();
		query2.close();
		info.incNewUnPlannedPersonalpreformedId();
		info.close();
		return 1;
	}
	
public ArrayList<PreformedPersonalTraining> getAllUnPlannedPreformedTrainingByAthlete(int athleteId) throws SQLException{
		
		ArrayList<PreformedPersonalTraining> array = new ArrayList<PreformedPersonalTraining>();
		
		setQuery("SELECT * FROM preformedpersonaltraining " + "WHERE athleteId  = '"+athleteId+"'AND isplanned='true'");
			ResultSet rs = execQuery();
			while (rs.next()){				
				PreformedPersonalTraining Preformedtraining = null;
				try {
					Preformedtraining = new PreformedPersonalTraining(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					array.add(Preformedtraining);
				}
		  
		  return array;
		  }

public int addPlannedPreformedTrainingByAthlete(PreformedPersonalTraining Preformedtraining) throws SQLException{
	Info info = new Info();
	int NewUnPlannedPersonalpreformedId = info.getNewUnPlannedPersonalpreformedId();
	
	setQuery("INSERT INTO preformedpersonaltraining(preformedId,athleteId,isplanned,trainingId, activityid, trainingTypeId,time,details,duration,distance,date) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
	PreparedStatement query2 = getPS();
	query2.setInt(1, NewUnPlannedPersonalpreformedId);
	query2.setInt(2, Preformedtraining.getAthleteId());
	query2.setString(3,"false");
	query2.setInt(4, Preformedtraining.getTrainingId());
	query2.setInt(5, Preformedtraining.getActivityid());
	query2.setInt(6, Preformedtraining.getTrainingTypeId());
	query2.setString(7,Preformedtraining.getTime());
	query2.setString(8,Preformedtraining.getDetails());
	query2.setString(9,Preformedtraining.getDuration());
	query2.setString(10,Preformedtraining.getDistance());
	query2.setString(11,Preformedtraining.getDate());
	query2.executeUpdate();
	query2.close();
	info.incNewUnPlannedPersonalpreformedId();
	info.close();
	return 1;
}

public ArrayList<PreformedPersonalTraining> getAllPersonalPlannedPreformedTrainingByAthlete(int athleteId) throws SQLException{
	
	ArrayList<PreformedPersonalTraining> array = new ArrayList<PreformedPersonalTraining>();
	
	setQuery("SELECT * FROM preformedpersonaltraining " + "WHERE athleteId  = '"+athleteId+"'AND isplanned='false'");
		ResultSet rs = execQuery();
		while (rs.next()){				
			PreformedPersonalTraining Preformedtraining = null;
			try {
				Preformedtraining = new PreformedPersonalTraining(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				array.add(Preformedtraining);
			}
	  
	  return array;
	  }
}

