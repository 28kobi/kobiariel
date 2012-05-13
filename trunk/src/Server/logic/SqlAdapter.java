package Server.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlAdapter {
	
	/** Variable represents connection instance */
	private Connection connection;
	/** Variable represents password */
	private static String password = "";
	/** Variable represents username */
	private static String username = "root";
	
	/**
	 * Default Constructor. Open a connection to the DB
	 * 
	 */
	public SqlAdapter() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {/* handle the error*/}
    
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/tndb",username,password);
		} catch (SQLException ex) 
 	    	{/* handle any errors*/
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());	
 	    	}
	}
	
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	* @return the Connection
	*/
	public Connection getConnection() {
		return connection;
	}

	/**
	* @return the password
	*/
	public static String getPassword() {
		return password;
	}

	/**
	* @param password the password to set
	*/
	public static void setPassword(String password) 
	{
		SqlAdapter.password = password;
	}

	/**
	 * @return the username
	 */
	public static String getUsername() 
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public static void setUsername(String username) 
	{
		SqlAdapter.username = username;
	}	
}

