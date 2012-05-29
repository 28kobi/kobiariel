
package Server.DataBase;

import java.io.Serializable;
/**
 * 
 * @author kobiariel
 *
 *
 */

public class PreformedTeamTraining implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * user id number
	 */
	
	private int athleteId;
	private int trainingId;
	private int activityid;
	private int trainingTypeId;
	private String time;
	private String details;
	private String duration;
	private String distance;
	private String date;
	
	
	public PreformedTeamTraining(){
		
	}
	
	
	public PreformedTeamTraining(int athleteId,int trainingId,int activityid , int trainingTypeId,String time,String details,
			String duration ,String distance,String date) {
		super();	
		this.athleteId=athleteId;		
		this.trainingId=trainingId;
		this.activityid=activityid;
		this.trainingTypeId=trainingTypeId;
		this.time=time;
		this.details=details;
		this.duration=duration;
		this.distance=distance;
		this.date=date;
		
	}


	public int getAthleteId() {
		return athleteId;
	}


	public void setAthleteId(int athleteId) {
		this.athleteId = athleteId;
	}


	public int getTrainingId() {
		return trainingId;
	}


	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	
	
	
	public int getActivityid() {
		return activityid;
	}





	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}



	public int getTrainingTypeId() {
		return trainingTypeId;
	}





	public void setTrainingTypeId(int trainingTypeId) {
		this.trainingTypeId = trainingTypeId;
	}




	public String getTime() {
		return time;
	}





	public void setTime(String time) {
		this.time = time;
	}





	public String getDuration() {
		return duration;
	}





	public void setDuration(String duration) {
		this.duration = duration;
	}





	public String getDetails() {
		return details;
	}





	public void setDetails(String details) {
		this.details = details;
	}





	public String getDistance() {
		return distance;
	}





	public void setDistance(String distance) {
		this.distance = distance;
	}





	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	public String toString() {
		return date+" "+details;
	}


	
}