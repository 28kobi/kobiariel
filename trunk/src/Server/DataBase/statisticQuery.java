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
public class statisticQuery extends Query {
	
	
	
	
	
	public statisticQuery() {
		super();
	}
	
	

	 
	public statistic getAthleteStatistic(int athleteId) throws SQLException {
		int howmanyoutofplannedPreformed=0,unplanned=0;
		float precnetHowManyOfPlannedPref=0;
		statistic statisticQ=new statistic();
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
		 for (int i=0; i<arraypreformed.size(); i++)
			{
				if (arraypreformed.get(i).getIsplanned().equals("true")){
					howmanyoutofplannedPreformed++;
				}	
				else{
					unplanned++;
				}
			}
		 statisticQ.setHowmanyoutofplannedPreformed(howmanyoutofplannedPreformed);
		 statisticQ.setUnplanned(unplanned);
		 
			  return statisticQ;
	}
	
	
	
	public statistic gettrainingStatisticByTrainingId(int traingingId,int teamId) throws SQLException {
		int numberOfAthletePreformed=0;
		float precentDidTheTraining,precentDidntDoTheTraining;
		ArrayList<athlete> array = new ArrayList<athlete>();
		athleteQuery athleteQ=new athleteQuery();
		PreformedTeamTrainingQuery preformedQ=new PreformedTeamTrainingQuery();
		ArrayList<PreformedTeamTraining> array1 = new ArrayList<PreformedTeamTraining>();
		array1=preformedQ.getAllTrainingPreformedByTrainingId(traingingId);
		numberOfAthletePreformed=array1.size();
		int athleteInTeam=0;
		float precnetHowManyPreformed=0;
		statistic statisticQ=new statistic();
		array=athleteQ.getAllAthleteByTeamId(teamId);
		athleteInTeam=array.size();
		precentDidTheTraining=(float)(numberOfAthletePreformed)/(athleteInTeam);
		precentDidTheTraining=precentDidTheTraining*100;
		precentDidntDoTheTraining=100-precentDidTheTraining;
		statisticQ.setPrecentDidTheTraining(precentDidTheTraining);
		statisticQ.setPrecentDidntDoTheTraining(precentDidntDoTheTraining);
		statisticQ.setAthleteInTeam(athleteInTeam);
	
			  return statisticQ;
	}
	
	
	
	
	

}

