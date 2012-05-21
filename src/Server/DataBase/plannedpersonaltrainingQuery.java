package Server.DataBase;

import java.sql.PreparedStatement;

import java.sql.SQLException;

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
	
	
	
}

