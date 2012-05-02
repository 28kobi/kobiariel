package Server.DataBase;

import java.io.Serializable;
/**
 * 
 * @author Polak Ido
 *
 *
 */

public class User implements Serializable{

	/**
	 * Contains user info 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * user id number
	 */
	private int idUser;
	
	/**
	 * user name
	 */
	private String userName = null;
	
	/**
	 * login password
	 */
	private String password = null;
	
	/**
	 * users permission 
	 */
	private int permission;
	
	/**
	 * online state 
	 */
	private int online = 0;

	/**
	 * user first name
	 */
	private String firstName;
	
	/**
	 * user last name
	 */
	private String lastName;
	
	
	
	public User(int idUser, String userName, String password, int permission,
			int online, String firstName, String lastName) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.permission = permission;
		this.online = online;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	/**
	 * @return user id number
	 */
	public int getIdUser() {
		return idUser;
	}
	
	/**
	 * set user id number
	 * @param idUser
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * @return user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * set user name
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set new password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return user permission
	 */
	public int getPermission() {
		return permission;
	}
	
	/**
	 * set permission
	 * @param permission
	 */
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	/**
	 * @return online state
	 */
	public int isOnline() {
		return online;
	}
	
	/**
	 * change online state
	 * @param online
	 */
	public void setOnline(int online) {
		this.online = online;
	}
	
	/**
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * set first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	public String toString() {
		return lastName+" "+firstName;
	}
	
	/**
	 * set last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
