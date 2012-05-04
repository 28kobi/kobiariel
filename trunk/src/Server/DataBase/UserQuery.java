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
public class UserQuery extends Query{
	
	public UserQuery() {
		super();
	}
	/**
	 * getUserByName
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public User getUserByName(String UserName) throws SQLException{
		setQuery("SELECT * FROM users " + "WHERE UserName = '"+UserName+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), UserName, 
					rs.getString(5),rs.getInt(6), rs.getString(7),rs.getString(8),rs.getInt(9));
			return user;
		}
		return null;
	}
	/**
	 * getUserByIdUser
	 * @param idUser
	 * @return
	 * @throws SQLException
	 */
	public User getUserByIdUser(int UserId) throws SQLException{
		setQuery("SELECT * FROM users " + "WHERE idUser = '"+UserId+"'");
		ResultSet rs = execQuery();
		if (rs.next()){
			User user = new User(UserId, rs.getString(2), rs.getString(3),rs.getString(4), 
					rs.getString(5),rs.getInt(6), rs.getString(7),rs.getString(8),rs.getInt(9));
			return user;
		}
		return null;
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<User> getAllUsers() throws SQLException{
		ArrayList<User> array = new ArrayList<User>();
		setQuery("SELECT * FROM users");
		ResultSet rs = execQuery();
		while (rs.next())
			array.add(getUserByIdUser(rs.getInt(1)));
		return array;
	}
	/**
	 * 
	 * @param idUser
	 * @throws SQLException
	 */
	public void setOnline(int UserId) throws SQLException{
		setQuery("UPDATE users "+"SET Online = ? WHERE UserId = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, 1);
		update.setInt(2, UserId);
		update.executeUpdate();
		update.close();
	}
	/**
	 * 
	 * @param idUser
	 * @throws SQLException
	 */
	public void setOffline(int UserId) throws SQLException{
		setQuery("UPDATE users "+"SET Online = ? WHERE UserId = ? ");
		PreparedStatement update = getPS();
		update.setInt(1, 0);
		update.setInt(2, UserId);
		update.executeUpdate();
		update.close();
	}
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public boolean isExist(String UserName) throws SQLException{
		setQuery("SELECT * FROM users " + "WHERE UserName = ?");
		PreparedStatement query = getPS();
		query.setString(1, UserName);
		if (query.executeQuery().next()){
			query.close();
			return true;
		}
		else {
			query.close();
			return false;
		}
	}
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param permission
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws SQLException
	 */
	public int addUser(String  FirstName,String LastName ,String UserName, String Password, int Privilge,
			   String PhoneNumber ,String Address,int  Online) throws SQLException{
		Info info = new Info();
		int newIdUser = info.getNewUserId();
		if (isExist(UserName)) return 1;
		setQuery("INSERT INTO users(UserId, FirstName, LastName, UserName, Password, Privilge,PhoneNumber,Address,Online) VALUES(?,?,?,?,?,?,?,?,?)");
		PreparedStatement query2 = getPS();
		query2.setInt(1, newIdUser);
		query2.setString(2, FirstName);
		query2.setString(3, LastName);
		query2.setString(4, UserName);
		query2.setString(5, Password);
		query2.setInt(6, Privilge);
		query2.setString(7, PhoneNumber);
		query2.setString(8, Address);
		query2.setInt(9, Online);
		query2.executeUpdate();
		query2.close();
		info.incUserId();
		info.close();
		return 0;
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public void resetOnline() throws SQLException{
		ArrayList<User> array = getAllUsers();
		for (User user: array){
			setQuery("UPDATE users SET Online='0' WHERE UserId=?");
			PreparedStatement query = getPS();
			query.setInt(1, user.getIdUser());
			query.executeUpdate();
			query.close();
		}
	}
}
