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
public class statisticQuery extends Query{
	
	
	
	private int howmanyofplanned;
	private int howmanyoutofplannedPreformed;
	private int howmanypreformed;
	private float precenthowmanyofplanned;
	private float precenthowmanyoutofplannedPreformed;
	private float precenthowmanypreformed;
	private int howmanyplanned;
	private int unplanned;
	
	public statisticQuery() {
		super();
	}
	public statisticQuery(float precenthowmanyofplanned,float precenthowmanyoutofplannedPreformed,float precenthowmanypreformed,int howmanyofplanned,
							int howmanyoutofplannedPreformed,int howmanypreformed,int howmanyplanned,int unplanned) {
		
		super();
		this.setHowmanyofplanned(howmanyofplanned);///מתוך אימונים שעשה בפרפרמד כמה פלנד?
		this.setHowmanypreformed(howmanypreformed);
		this.setHowmanyoutofplannedPreformed(howmanyoutofplannedPreformed);
		this.setPrecenthowmanyofplanned(precenthowmanyofplanned);
		this.setPrecenthowmanyoutofplannedPreformed(precenthowmanyoutofplannedPreformed);
		this.setPrecenthowmanypreformed(precenthowmanypreformed);
		this.setHowmanyplanned(howmanyplanned);
		this.setUnplanned(unplanned);
	}
	

	 
	public statisticQuery getAthleteStatistic(int athleteId) throws SQLException{
		int Howmanyofplanned1=0;
		statisticQuery statisticQ=new statisticQuery();
		ArrayList<plannedpersonaltraining> arrayplanned = new ArrayList<plannedpersonaltraining>();
		ArrayList<PreformedPersonalTraining> arraypreformed = new ArrayList<PreformedPersonalTraining>();
		ArrayList<PreformedPersonalTraining> arrayunPlanned = new ArrayList<PreformedPersonalTraining>();
		plannedpersonaltrainingQuery plannedPersonalQuery =new plannedpersonaltrainingQuery();
		PreformedPersonalTrainingQuery PreformedPersonalTraining1 =new PreformedPersonalTrainingQuery();
		arrayplanned=plannedPersonalQuery.getAllPersonalTrainingByAthleteId(athleteId);
		arraypreformed=PreformedPersonalTraining1.getAllPersonalPreformedTrainingByAthlete(athleteId);
		arrayunPlanned=PreformedPersonalTraining1.getAllUnPlannedPreformedTrainingByAthlete(athleteId);
		
		statisticQ.setHowmanyplanned(arrayplanned.size());
		statisticQ.setHowmanypreformed(arraypreformed.size());
		statisticQ.setUnplanned(arrayunPlanned.size());
		 for (int i=0; i<=arraypreformed.size(); i++)
			{
				if (arraypreformed.get(i).getIsplanned()=="true"){
					Howmanyofplanned1++;
				}	
			}
		 statisticQ.setHowmanyofplanned(Howmanyofplanned1);
		 
		 
			  return statisticQ;
	}
	
	
	
	
	
	
	
	public int getHowmanyofplanned() {
		return howmanyofplanned;
	}
	public void setHowmanyofplanned(int howmanyofplanned) {
		this.howmanyofplanned = howmanyofplanned;
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
	public float getPrecenthowmanyofplanned() {
		return precenthowmanyofplanned;
	}
	public void setPrecenthowmanyofplanned(float precenthowmanyofplanned) {
		this.precenthowmanyofplanned = precenthowmanyofplanned;
	}
	public float getPrecenthowmanyoutofplannedPreformed() {
		return precenthowmanyoutofplannedPreformed;
	}
	public void setPrecenthowmanyoutofplannedPreformed(
			float precenthowmanyoutofplannedPreformed) {
		this.precenthowmanyoutofplannedPreformed = precenthowmanyoutofplannedPreformed;
	}
	public float getPrecenthowmanypreformed() {
		return precenthowmanypreformed;
	}
	public void setPrecenthowmanypreformed(float precenthowmanypreformed) {
		this.precenthowmanypreformed = precenthowmanypreformed;
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
	
	

}

