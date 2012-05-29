package Server.DataBase;

import java.io.Serializable;
/**
 * 
 * @author kobiariel
 *
 *
 */

public class PreformedPersonalTraining implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * user id number
	 */
	private int preformedId;
	private int athleteId;
	private String isplanned;
	private int trainingId;
	private int activityid;
	private int trainingTypeId;
	private String time;
	private String details;
	private String duration;
	private String distance;
	private String date;
	
	
	public PreformedPersonalTraining(){
		
	}
	
	
	public PreformedPersonalTraining(int preformedId,int athleteId,String isplanned,int trainingId,int activityid , int trainingTypeId,String time,String details,
			String duration ,String distance,String date) {
		super();
		this.preformedId=preformedId;
		this.athleteId=athleteId;
		this.isplanned=isplanned;
		this.trainingId=trainingId;
		this.activityid=activityid;
		this.trainingTypeId=trainingTypeId;
		this.time=time;
		this.details=details;
		this.duration=duration;
		this.distance=distance;
		this.date=date;
		
	}


	public int getPreformedId() {
		return preformedId;
	}


	public void setPreformedId(int preformedId) {
		this.preformedId = preformedId;
	}


	public int getAthleteId() {
		return athleteId;
	}


	public void setAthleteId(int athleteId) {
		this.athleteId = athleteId;
	}


	public String getIsplanned() {
		return isplanned;
	}


	public void setIsplanned(String isplanned) {
		this.isplanned = isplanned;
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