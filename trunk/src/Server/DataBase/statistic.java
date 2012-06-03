
package Server.DataBase;
import java.io.Serializable;


public class statistic implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int howmanyoutofplannedPreformed;
	private int howmanypreformed;
	private float precentDidTheTraining;
	private float precentDidntDoTheTraining;
	private int athleteInTeam;
	private int howmanyplanned;
	private int unplanned;
	/**
	 * builder 
	 */
	
	public statistic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public statistic(int howmanyoutofplannedPreformed,int howmanypreformed,float precentDidTheTraining,float precentDidntDoTheTraining,int athleteInTeam
			,int howmanyplanned,int unplanned) {
		super();
	
		this.howmanyoutofplannedPreformed=howmanyoutofplannedPreformed;
		this.howmanypreformed=howmanypreformed;
		this.setPrecentDidTheTraining(precentDidTheTraining);
		this.setPrecentDidntDoTheTraining(precentDidntDoTheTraining);
		this.setAthleteInTeam(athleteInTeam);
		this.howmanyplanned=howmanyplanned;
		this.unplanned=unplanned;
		
		
	}

	
	


	public int getHowmanyoutofplannedPreformed() {
		return howmanyoutofplannedPreformed;
	}


	public void setHowmanyoutofplannedPreformed(int howmanyoutofplannedPreformed) {
		this.howmanyoutofplannedPreformed = howmanyoutofplannedPreformed;
	}


	

	public int getHowmanypreformed() {
		return howmanypreformed;
	}


	public void setHowmanypreformed(int howmanypreformed) {
		this.howmanypreformed = howmanypreformed;
	}


	

	


	public int getHowmanyplanned() {
		return howmanyplanned;
	}


	public void setHowmanyplanned(int howmanyplanned) {
		this.howmanyplanned = howmanyplanned;
	}


	public int getUnplanned() {
		return unplanned;
	}


	public void setUnplanned(int unplanned) {
		this.unplanned = unplanned;
	}

	public float getPrecentDidTheTraining() {
		return precentDidTheTraining;
	}

	public void setPrecentDidTheTraining(float precentDidTheTraining) {
		this.precentDidTheTraining = precentDidTheTraining;
	}

	public float getPrecentDidntDoTheTraining() {
		return precentDidntDoTheTraining;
	}

	public void setPrecentDidntDoTheTraining(float precentDidntDoTheTraining) {
		this.precentDidntDoTheTraining = precentDidntDoTheTraining;
	}

	public int getAthleteInTeam() {
		return athleteInTeam;
	}

	public void setAthleteInTeam(int athleteInTeam) {
		this.athleteInTeam = athleteInTeam;
	}



	
}