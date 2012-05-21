
package Server.DataBase;
import java.io.Serializable;
/**
 * 
 * @author kobiariel
 *
 *activity type is the upper lever of type as : running ,navigation, swimming....
 */

public class activitytype implements Serializable{

	/**
	 * Contains user info 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * user id number
	 */
	private int activityId ;
	
	private String activityName;
	
	public activitytype() {
		super();

		
	}
	
	
	public activitytype(int activityId,String  activityName) {
		super();
		this.setActivityId(activityId);
		this.setActivityName(activityName);
		
	}


	public int getActivityId() {
		return activityId;
	}


	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}


	public String getActivityName() {
		return activityName;
	}
	
	
	public String toString() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	
	
}
