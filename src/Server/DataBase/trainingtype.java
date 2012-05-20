

package Server.DataBase;
import java.io.Serializable;
/**
 * 
 * @author kobiariel
 *
 *activity type is the upper lever of type as : running ,navigation, swimming....
 */

public class trainingtype implements Serializable{

	/**
	 * Contains user info 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private int activityId ;
	
	private String trainingName;
	
	private int trainingId;
	
	
	public trainingtype(int trainingId,int activityId,String  trainingName) {
		super();
		
		this.setActivityId(activityId);
		this.setTrainingId(trainingId);
		this.settrainingName(trainingName);
		
	}


	public int getActivityId() {
		return activityId;
	}


	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}


	public String gettrainingName() {
		return trainingName;
	}


	public void settrainingName(String trainingName) {
		this.trainingName = trainingName;
	}


	public int getTrainingId() {
		return trainingId;
	}
	
	
	public String toString() {
		return trainingName;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	
	
	
}
