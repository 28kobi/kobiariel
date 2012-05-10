package Server.DataBase;
import java.io.Serializable;
/**
 * 
 * @author kobiariel
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
	private int UserId;
	
	private String UserName;
	
	/**
	 * FirstName
	 */
	private String FirstName = null;

	/**
	 * user  LastName
	 */
	private String LastName=null;
	
	
	/**
	 * login password
	 */
	private String password = null;
	
	/**
	 * users Privilge
	 */
	private int Privilge;
	
	/**
	 * online state 
	 */
	private int Online = 0;
	
	
	private  String PhoneNumber;
	
	private String Address;
	
	
	
	
	public User(int UserId,String  FirstName,String LastName ,String UserName, String password, int Privilge,
			   String PhoneNumber ,String Address,int  Online) {
		super();
		this. UserId =  UserId;
		this.UserName = UserName;
		this.password = password;
		this.Privilge = Privilge;
		this.Online =  Online;
		this.FirstName =  FirstName;
		this.LastName= LastName;
		this.setPhoneNumber(PhoneNumber);
		this.setAddress(Address);
	}
	
	
	

	/**
	 * @return user id number
	 */
	public int getIdUser() {
		return  UserId;
	}
	
	/**
	 * set user id number
	 * @param  UserId
	 */
	public void setIdUser(int UserId) {
		this.UserId=UserId;
	}
	
	/**
	 * @return user name
	 */
	public String getUserName() {
		return UserName;
	}
	
	/**
	 * set user name
	 * @param userName
	 */
	public void setUserName(String UserName) {
		this.UserName = UserName;
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
	public int getPrivilge() {
		return Privilge;
	}
	
	/**
	 * set permission
	 * @param permission
	 */
	public void setPrivilge(int  Privilge) {
		this.Privilge = Privilge;
	}
	
	/**
	 * @return online state
	 */
	public int isOnline() {
		return  Online;
	}
	
	/**
	 * change online state
	 * @param online
	 */
	public void setOnline(int Online) {
		this.Online=  Online;
	}
	
	/**
	 * @return  FirstName
	 */
	public String getFirstName() {
		return FirstName;
	}
	
	/**
	 * set first name
	 * @param firstName
	 */
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	/**
	 * @return LastName
	 */
	public String getLastName() {
		return LastName;
	}
	
	public String toString() {
		return LastName+" "+FirstName;
	}
	
	/**
	 * set last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}



	public String getPhoneNumber() {
		return PhoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}
	
	
}
