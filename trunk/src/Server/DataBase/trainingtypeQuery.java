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
public class trainingtypeQuery extends Query{
	
	public trainingtypeQuery() {
		super();
	}

	
	
	public int addtrainingtype(trainingtype trainingtypeob) throws SQLException{
		Info info = new Info();
		int newIdTraining= info.getNewTrainingTypeId();
		setQuery("INSERT INTO trainingtype(trainingId,activityId,trainingName) VALUES(?,?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, newIdTraining);
		query2.setInt(2, trainingtypeob.getActivityId());
		query2.setString(3, trainingtypeob.gettrainingName());
		query2.executeUpdate();
		query2.close();
		info.inctrainingTypeId();
		info.close();
		return 1;
	}
	
	
	
	public boolean isExist(String trainingtype) throws SQLException{
		setQuery("SELECT * FROM trainingtype " + "WHERE trainingName = ?");
		PreparedStatement query = getPS();
		query.setString(1, trainingtype);
		if (query.executeQuery().next()){
			query.close();
			return true;
		}
		else {
			query.close();
			return false;
		}
	}
	public trainingtype getatrainingtypeById(int trainingid) throws SQLException{
		setQuery("SELECT * FROM trainingtype " + "WHERE trainingId = '"+trainingid+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			trainingtype trainingType = new trainingtype(trainingid, rs.getInt(2),  rs.getString(3));
			return trainingType;
		}
		return null;
	}
	
	public ArrayList<trainingtype> getAllTrainingTypeByActivityId(int activityId) throws SQLException{
		ArrayList<trainingtype> array = new ArrayList<trainingtype>();
		setQuery("SELECT * " + "FROM trainingtype WHERE activityId = '"+activityId+"'");
		ResultSet rs=execQuery();
		while (rs.next()){
			trainingtype trainingType = new trainingtype(rs.getInt(1),rs.getInt(2), rs.getString(3));
			array.add(trainingType);
		}
		return array;
	}

}

