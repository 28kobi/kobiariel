

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
public class activitytypeQuery extends Query{
	
	public activitytypeQuery() {
		super();
	}

	
	
	public int addActivityType(String ActivityName) throws SQLException{
		Info info = new Info();
		int newIdActivity= info.getNewActivityId();
		if (isExist(ActivityName)) return 1;
		setQuery("INSERT INTO activitytype(activityId, activityName) VALUES(?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, newIdActivity);
		query2.setString(2, ActivityName);
		query2.executeUpdate();
		query2.close();
		info.incActivityId();
		info.close();
		return 1;
	}
	
	public int removeActivityType(activitytype activity) throws SQLException{
		setQuery("DELETE FROM activitytype WHERE activityId ='"+activity.getActivityId()+"'");
		PreparedStatement query2 = getPS();
		query2.executeUpdate();
		query2.close();
		return 1;	
	}
	 
		public activitytype getactivitytypeById(int activityId) throws SQLException{
			setQuery("SELECT * FROM activitytype " + "WHERE activityId = '"+activityId+"'");
			ResultSet rs = execQuery();
			if (rs.next()){
				activitytype activity = new activitytype(activityId,  rs.getString(2));
				return activity;
			}
			return null;
		}
	
	
	public boolean isExist(String activitytype) throws SQLException{
		setQuery("SELECT * FROM activitytype " + "WHERE activityName = ?");
		PreparedStatement query = getPS();
		query.setString(1, activitytype);
		if (query.executeQuery().next()){
			query.close();
			return true;
		}
		else {
			query.close();
			return false;
		}
	}
	
	
	public ArrayList<activitytype> getAllActivity() throws SQLException{
		ArrayList<activitytype> array = new ArrayList<activitytype>();
		setQuery("SELECT * " + "FROM activitytype ");
		ResultSet rs=execQuery();
		while (rs.next()){
			activitytype activityType = new activitytype(rs.getInt(1), rs.getString(2));
			array.add(activityType);
		}
		return array;
	}

}

