package Server.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Server.logic.SqlAdapter;

/**
 * abstract Query class .
 */
public abstract class Query {
	/**
	 * SqlAdapter sql
	 */
	private SqlAdapter sql = null;
	/**
	 * Statement
	 */
	private Statement stm = null;
	/**
	 *  String query
	 */
	private String query = null;
	/**
	 * constructor query
	 */
	public Query(){
		sql = new SqlAdapter();  //Open a connection to the DB
	}
	/**
	 * query setter 
	 * @param str
	 */
	public void setQuery(String str){
		query = str;
	}
	/**
	 * 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet execQuery() throws SQLException{
		if (query!=null){ 
			stm = sql.getConnection().createStatement();
			return stm.executeQuery(query);
		}
		return null;
	}
/**
 * close db connection
 * @throws SQLException
 */
	public void close() throws SQLException{
		if (sql!=null) sql.close();
		if (stm!=null) stm.close();
	}
	/** 
	 * @return Prepared Statement
	 * @throws SQLException
	 */
	public PreparedStatement getPS() throws SQLException{
		return sql.getConnection().prepareStatement(query);
	}
}
