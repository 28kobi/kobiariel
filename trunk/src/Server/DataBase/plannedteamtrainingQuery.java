package Server.DataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 
 * @author kobi
 *
 */
public class plannedteamtrainingQuery extends Query{
	
	public plannedteamtrainingQuery() {
		super();
	}
	
	
	
	
	public int addTeamTraining(plannedteamtraining training) throws SQLException{
		Info info = new Info();
		int newPlannedTeamId = info.getNewPlannedTeamTrainingId();
		
		setQuery("INSERT INTO plannedteamtraining(trainingId,teamId, activityid, trainingTypeId,time,details,duration,distance,date) VALUES(?,?,?,?,?,?,?,?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, newPlannedTeamId);
		query2.setInt(2, training.getTeamId());
		query2.setInt(3, training.getActivityid());
		query2.setInt(4, training.getTrainingTypeId());
		query2.setString(5,training.getTime());
		query2.setString(6,training.getDetails());
		query2.setString(7,training.getDuration());
		query2.setString(8,training.getDistance());
		query2.setString(9,training.getDate());
		query2.executeUpdate();
		query2.close();
		info.incTeamPlannedTrainingId();
		info.close();
		return 1;
	}
	
	
	
}

