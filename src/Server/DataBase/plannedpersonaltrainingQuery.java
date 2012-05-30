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
public class plannedpersonaltrainingQuery extends Query{
	
	
	
		
	public plannedpersonaltrainingQuery() {
		super();
	}
	
	
	
	public int addPersonalTrainingByCoach(plannedpersonaltraining training) throws SQLException{
		Info info = new Info();
		int newPlannedPersonalTrainingId = info.getNewPlannedPersonalTrainingId();
		
		setQuery("INSERT INTO plannedpersonaltraining(trainingId,athleteId, activityid, trainingTypeId,time,details,duration,distance,date) VALUES(?,?,?,?,?,?,?,?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, newPlannedPersonalTrainingId);
		query2.setInt(2, training.getathleteId());
		query2.setInt(3, training.getActivityid());
		query2.setInt(4, training.getTrainingTypeId());
		query2.setString(5,training.getTime());
		query2.setString(6,training.getDetails());
		query2.setString(7,training.getDuration());
		query2.setString(8,training.getDistance());
		query2.setString(9,training.getDate());
		query2.executeUpdate();
		query2.close();
		info.incPersonalPlannedTrainingId();
		info.close();
		return 1;
	}
	
public ArrayList<plannedpersonaltraining> getAllPersonalTrainingByAthleteId(int athleteId) throws SQLException{
		
		ArrayList<plannedpersonaltraining> array = new ArrayList<plannedpersonaltraining>();
		
		setQuery("SELECT * FROM plannedpersonaltraining " + "WHERE athleteId  = '"+athleteId+"'");
			ResultSet rs = execQuery();
			while (rs.next()){				
				plannedpersonaltraining training = null;
				try {
						training = new plannedpersonaltraining(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					array.add(training);
				}
		  
		  return array;
		  }

public int upDatePersonalTraining(plannedpersonaltraining training) throws SQLException{
	setQuery("UPDATE plannedpersonaltraining set  athleteId =?, activityid=?, trainingTypeId=?, time=?,details=?,duration=?,distance=?,date=? WHERE trainingId=?");
	PreparedStatement query2 = getPS();
	query2.setInt(1, training.getathleteId());
	query2.setInt(2,training.getActivityid());
	query2.setInt(3, training.getTrainingTypeId());
	query2.setString(4,training.getTime());
	query2.setString(5, training.getDetails());
	query2.setString(6,training.getDuration());
	query2.setString(7,training.getDistance());
	query2.setString(8, training.getDate());
	query2.setInt(9, training.getTrainingId());
	query2.executeUpdate();
	query2.close();
    return 1;
}	
	
public plannedpersonaltraining getPersonalTrainingByTrainingId(int trainingId) throws SQLException{
	
			setQuery("SELECT * FROM plannedpersonaltraining " + "WHERE trainingId = '"+trainingId+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			plannedpersonaltraining training = new plannedpersonaltraining(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9));
			return training;
		}
		return null;
	}
		
			
	  
	
	  
}

