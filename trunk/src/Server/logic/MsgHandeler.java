package Server.logic;

import java.io.IOException;
import java.sql.SQLException;

import Server.DataBase.PreformedPersonalTraining;
import Server.DataBase.PreformedPersonalTrainingQuery;
import Server.DataBase.PreformedTeamTrainingQuery;
import Server.DataBase.TeamQuery;
import Server.DataBase.User;
import Server.DataBase.UserQuery;
import Server.DataBase.activitytypeQuery;
import Server.DataBase.athleteQuery;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedpersonaltrainingQuery;
import Server.DataBase.plannedteamtrainingQuery;
import Server.DataBase.trainingtypeQuery;
import Server.Message.MessageAssignAthleteToTeam;
import Server.Message.MessageAssignAthleteToTeamReplay;
import Server.Message.MessageCreateNewActivityType;
import Server.Message.MessageCreateNewActivityTypeReplay;
import Server.Message.MessageCreateNewAthlete;
import Server.Message.MessageCreateNewAthleteReplay;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageCreateNewPersonalTraining;
import Server.Message.MessageCreateNewPersonalTrainingReplay;
import Server.Message.MessageCreateNewPreformedTeamPlannedTraining;
import Server.Message.MessageCreateNewPreformedTeamPlannedTrainingReplay;
import Server.Message.MessageCreateNewTeam;
import Server.Message.MessageCreateNewTeamReplay;
import Server.Message.MessageCreateNewTeamTraining;
import Server.Message.MessageCreateNewTeamTrainingReplay;
import Server.Message.MessageCreateNewTrainingType;
import Server.Message.MessageCreateNewTrainingTypeReplay;
import Server.Message.MessageCreateNewUnPlannedTraining;
import Server.Message.MessageCreateNewUnPlannedTrainingReplay;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllCoachReplay;
import Server.Message.MessageGetAllPersonalTrainingByAtleteId;
import Server.Message.MessageGetAllPersonalTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllPreformedTeamTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTeamTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllPreformedTrainingByAtleteId;
import Server.Message.MessageGetAllPreformedTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;
import Server.Message.MessageGetAllUnTeamedAthleteReplay;
import Server.Message.MessageGetAthleteByUserId;
import Server.Message.MessageGetAthleteByUserIdReplay;
import Server.Message.MessageGetUserByUserId;
import Server.Message.MessageGetUserByUserIdReplay;
import Server.Message.MessageLogin;
import Server.Message.MessageLoginReplay;
import Server.Message.MessageLogout;
import Server.Message.MessageRemoveAactivityType;
import Server.Message.MessageRemoveAactivityTypeReplay;
import Server.Message.MessageUpdateAthlete;
import Server.Message.MessageUpdateAthleteReplay;
import Server.Message.MessageUpdateAthleteTraining;
import Server.Message.MessageUpdateAthleteTrainingReplay;
import Server.Message.MessageUpdateCoach;
import Server.Message.MessageUpdateCoachReplay;
import Server.Message.MessageUpdateTeam;
import Server.Message.MessageUpdateTeamReplay;
import Server.Message.MessageUpdateTeamTraining;
import Server.Message.MessageUpdateTeamTrainingReplay;
import ocsf.server.ConnectionToClient;
/**
 * 
 * class handle all the massage that the client communicate with server
 *  
 *
 */
public class MsgHandeler {
	
	private Message message;
	private ConnectionToClient client;
	/**
	 * constructor MsgHandeler
	 * @param message
	 * @param client
	 */
	public MsgHandeler(Object message, ConnectionToClient client){
		this.message = (Message) message;
		this.client = client;
		
	}
	/**
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * 
	 * msg switch cases of message type to server
	 */
	
	public void msgHandeler() throws SQLException, IOException {
		switch (message.getMessageType()){
		case MESSAGE_LOGIN:
			login();
			break;
		case MESSAGE_LOGOUT: 
			MessageLogout logout = (MessageLogout) message;
			UserQuery userQuery2 = new UserQuery();
			userQuery2.setOffline(logout.getUser().getIdUser());
			userQuery2.close();
			break;
		case MESSAGE_GET_ALL_COACH:
			UserQuery UserQuery = new UserQuery();
			MessageGetAllCoachReplay mgsr = new MessageGetAllCoachReplay(UserQuery.getAllCoach());
			client.sendToClient(mgsr);
			UserQuery.close();
			break;
		case MESSAGE_GET_ALL_TRAINING_BY_TEAM_ID:
			plannedteamtrainingQuery plannedteamtrainingQuery10 = new plannedteamtrainingQuery();
			MessageGetAllTeamTrainingByTeamId MessageGetAllTeamTrainingByteamId1 = (MessageGetAllTeamTrainingByTeamId) message ;
			MessageGetAllTeamTrainingByTeamIdReplay mgsr14 = new MessageGetAllTeamTrainingByTeamIdReplay(plannedteamtrainingQuery10.getAllTeamTrainingByTeamId(MessageGetAllTeamTrainingByteamId1.getteamid()));
			client.sendToClient(mgsr14);
			plannedteamtrainingQuery10.close();
			break;
		case MESSAGE_UPDATE_COACH:
			UserQuery UserQuery1 = new UserQuery();
			MessageUpdateCoach Messageupdatecoach = (MessageUpdateCoach) message ;
			MessageUpdateCoachReplay mgsr1 = new MessageUpdateCoachReplay(UserQuery1.UpdateUser(Messageupdatecoach.getCoach()));
			client.sendToClient(mgsr1);
			UserQuery1.close();
			break;
		case MESSAGE_GET_ALL_TRAINING_BY_ATHLETE_ID:
			plannedpersonaltrainingQuery plannedpersonaltraining1 = new plannedpersonaltrainingQuery();
			MessageGetAllPersonalTrainingByAtleteId MessageGetAllPersonalTrainingByAtleteId1 = (MessageGetAllPersonalTrainingByAtleteId) message ;
			MessageGetAllPersonalTrainingByAtleteIdReplay mgsr15 = new MessageGetAllPersonalTrainingByAtleteIdReplay(plannedpersonaltraining1.getAllPersonalTrainingByAthleteId(MessageGetAllPersonalTrainingByAtleteId1.getAthleteId()));
			client.sendToClient(mgsr15);
			plannedpersonaltraining1.close();
			break;
		case MESSAGE_CREATE_NEW_COACH:
			UserQuery UserQuery2 = new UserQuery();
			int Privilge=1,online=0;
			MessageCreateNewCoach MessageCreateNewCoach = (MessageCreateNewCoach) message ;
			MessageCreateNewCoachReplay mgsr2 = new MessageCreateNewCoachReplay(UserQuery2.addUser(MessageCreateNewCoach.getCoach().getFirstName(),MessageCreateNewCoach.getCoach().getLastName(),MessageCreateNewCoach.getCoach().getUserName(),MessageCreateNewCoach.getCoach().getPassword(), Privilge,MessageCreateNewCoach.getCoach().getPhoneNumber(),MessageCreateNewCoach.getCoach().getAddress(),online));
			client.sendToClient(mgsr2);
			UserQuery2.close();
			break;
		case MESSAGE_GET_ALL_TEAM:
			TeamQuery TeamQuery1 = new TeamQuery();
			MessageGetAllTeamReplay mgsr11 = new MessageGetAllTeamReplay(TeamQuery1.getAllTeams());
			client.sendToClient(mgsr11);
			TeamQuery1.close();
			break;
		case MESSAGE_GET_USER_BY_USER_ID:
			UserQuery UserQuery3 = new UserQuery();
			MessageGetUserByUserId MessageGetCoachByCoachId = (MessageGetUserByUserId) message ;
			MessageGetUserByUserIdReplay mgcbid  = new MessageGetUserByUserIdReplay(UserQuery3.getUserByUserId(MessageGetCoachByCoachId.getUserId()));
			client.sendToClient(mgcbid);
			UserQuery3.close();
			break;
		case MESSAGE_UPDATE_TEAM:
			TeamQuery TeamQuery= new TeamQuery();
			MessageUpdateTeam MessageUpdateTeam = (MessageUpdateTeam) message ;
			MessageUpdateTeamReplay mutr = new MessageUpdateTeamReplay(TeamQuery.UpdateTeam(MessageUpdateTeam.getTeam()));
			client.sendToClient(mutr);
			TeamQuery.close();
			break;
		case MESSAGE_CREATE_NEW_ATHLETE:
			int offline=0;
			UserQuery userQuery= new UserQuery();
			MessageCreateNewAthlete Messagecreatenewathlete = (MessageCreateNewAthlete) message ;
			MessageCreateNewAthleteReplay msgr = new MessageCreateNewAthleteReplay(userQuery.addAthlete(Messagecreatenewathlete.getAthlete().getFirstName(),Messagecreatenewathlete.getAthlete().getLastName(),Messagecreatenewathlete.getAthlete().getUserName(),Messagecreatenewathlete.getAthlete().getPassword(),Messagecreatenewathlete.getAthlete().getPrivilge(),Messagecreatenewathlete.getAthlete().getPhoneNumber(),Messagecreatenewathlete.getAthlete().getAddress(),offline));
			client.sendToClient(msgr);
			userQuery.close();
			break;
		case MESSAGE_GET_ALL_TEAM_BY_COACH_ID:
			TeamQuery teamquery1= new TeamQuery();
			MessageGetAllTeamByCoachId MessageGetAllTeamByCoachId = (MessageGetAllTeamByCoachId) message ;
			MessageGetAllTeamByCoachReplay msgr1 = new MessageGetAllTeamByCoachReplay(teamquery1.getTeamByCoachId(MessageGetAllTeamByCoachId.getCoachId()));
			client.sendToClient(msgr1);
			teamquery1.close();
			break;	
		case MESSAGE_ASSIGN_ATHLETE_TO_TEAM:
			athleteQuery athleteQuery1= new athleteQuery();
			MessageAssignAthleteToTeam MessageAssignAthleteToTeam1 = (MessageAssignAthleteToTeam) message ;
			MessageAssignAthleteToTeamReplay msgr2 = new MessageAssignAthleteToTeamReplay(athleteQuery1.addAthleteToTeam(MessageAssignAthleteToTeam1.getUserid(),MessageAssignAthleteToTeam1.getTeamhid()));
			client.sendToClient(msgr2);
			athleteQuery1.close();
			break;
		case MESSAGE_CREATE_NEW_TEAM:
			TeamQuery teamquery = new TeamQuery();
			int teamid=1;
			MessageCreateNewTeam MessageCreateNewteam = (MessageCreateNewTeam) message ;
			MessageCreateNewTeamReplay msg = new MessageCreateNewTeamReplay(teamquery.addTeam(teamid, MessageCreateNewteam.getCoachId(), MessageCreateNewteam.getTeamName()));
			client.sendToClient(msg);
			teamquery.close();
			break;
		case MESSAGE_GET_ALL_ATHLETE_BY_COACH_ID:
			UserQuery UserQueryByCoachId= new UserQuery();
			MessageGetAllAthleteByCoachId MessageGetAllAthleteByCoachId1 = (MessageGetAllAthleteByCoachId) message ;
			MessageGetAllAthleteByCoachIdReplay msgr3 = new MessageGetAllAthleteByCoachIdReplay(UserQueryByCoachId.getAllAthletByCoach(MessageGetAllAthleteByCoachId1.getCoachid()));
			client.sendToClient(msgr3);
			UserQueryByCoachId.close();
			break;	
		case MESSAGE_UPDATE_ATHLETE:
			UserQuery UserQuery4 = new UserQuery();
			MessageUpdateAthlete MessageUpdateAthlete = (MessageUpdateAthlete) message ;
			MessageUpdateAthleteReplay mgsr5 = new MessageUpdateAthleteReplay(UserQuery4.UpdateUser(MessageUpdateAthlete.getathlete()));
			client.sendToClient(mgsr5);
			UserQuery4.close();
			break;
		case MESSAGE_GET_ALL_UNTEAMED_ATHLETE:
			UserQuery UserQuery5 = new UserQuery();
			MessageGetAllUnTeamedAthleteReplay mgsre = new MessageGetAllUnTeamedAthleteReplay(UserQuery5.getAllUnTeamedAthlete());
			client.sendToClient(mgsre);
			UserQuery5.close();
			break;
		case MESSAGE_GET_ALL_ACTIVITY_TYPE:
			activitytypeQuery activityTypeQuery = new activitytypeQuery();
			MessageGetAllAactivityTypeReplay mgsr6 = new MessageGetAllAactivityTypeReplay(activityTypeQuery.getAllActivity());
			client.sendToClient(mgsr6);
			activityTypeQuery.close();
			break;
		case MESSAGE_GET_ALL_TRAINING_TYPE:
			trainingtypeQuery trainingTypeQuery = new trainingtypeQuery();
			MessageGetAllTrainingType MessageGetAllTrainingType1 = (MessageGetAllTrainingType) message ;
			MessageGetAllTrainingTypeReplay mgsr7 = new MessageGetAllTrainingTypeReplay(trainingTypeQuery.getAllTrainingTypeByActivityId(MessageGetAllTrainingType1.getActivityId()));
			client.sendToClient(mgsr7);
			trainingTypeQuery.close();
			break;
		case MESSAGE_CREATE_NEW_TEAM_TRAINING:
			plannedteamtrainingQuery plannedTeamTrainingQuery = new plannedteamtrainingQuery();
			MessageCreateNewTeamTraining MessagecreateNewteamTraining = (MessageCreateNewTeamTraining) message ;
			MessageCreateNewTeamTrainingReplay msgr8 = new MessageCreateNewTeamTrainingReplay(plannedTeamTrainingQuery.addTeamTraining(MessagecreateNewteamTraining.getTraining()));
			client.sendToClient(msgr8);
			plannedTeamTrainingQuery.close();
			break;
		case MESSAGE_CREATE_NEW_PERSONAL_TRAINING:
			plannedpersonaltrainingQuery plannedpersonalTrainingQuery = new plannedpersonaltrainingQuery();
			MessageCreateNewPersonalTraining MessageCreateNewpersonaltraining = (MessageCreateNewPersonalTraining) message ;
			MessageCreateNewPersonalTrainingReplay msgr9 = new MessageCreateNewPersonalTrainingReplay(plannedpersonalTrainingQuery.addPersonalTrainingByCoach(MessageCreateNewpersonaltraining.getTraining()));
			client.sendToClient(msgr9);
			plannedpersonalTrainingQuery.close();
			break;
		case MESSAGE_CREATE_NEW_ACTIVITY_TYPE:
			activitytypeQuery activityTypeQuery1 = new activitytypeQuery();
			MessageCreateNewActivityType MessagecreateNewactivityType = (MessageCreateNewActivityType) message ;
			MessageCreateNewActivityTypeReplay mgsr10 = new MessageCreateNewActivityTypeReplay(activityTypeQuery1.addActivityType(MessagecreateNewactivityType.getActivity().getActivityName()));
			client.sendToClient(mgsr10);
			activityTypeQuery1.close();
			break;
		case MESSAGE_REMOVE_ACTIVITY_TYPE:
			activitytypeQuery activityTypeQuery2 = new activitytypeQuery();
			MessageRemoveAactivityType MessageRemoveaactivityType = (MessageRemoveAactivityType) message ;
			MessageRemoveAactivityTypeReplay mgsr12 = new MessageRemoveAactivityTypeReplay(activityTypeQuery2.removeActivityType(MessageRemoveaactivityType.getActivityType()));
			client.sendToClient(mgsr12);
			activityTypeQuery2.close();
			break;
		case MESSAGE_CREATE_NEW_TRAINING_TYPE:
			trainingtypeQuery trainingtypeQuery1 = new trainingtypeQuery();
			MessageCreateNewTrainingType MessageCreateNewTrainingType1 = (MessageCreateNewTrainingType) message ;
			MessageCreateNewTrainingTypeReplay mgsr13 = new MessageCreateNewTrainingTypeReplay(trainingtypeQuery1.addtrainingtype(MessageCreateNewTrainingType1.getTrainingType()));
			client.sendToClient(mgsr13);
			trainingtypeQuery1.close();
			break;
		case MESSAGE_UPDATE_TEAMTRAINING:
			plannedteamtrainingQuery plannedteamtrainingQuery4 = new plannedteamtrainingQuery();
			MessageUpdateTeamTraining MessageUpdateTeamTraining1 = (MessageUpdateTeamTraining) message ;
			MessageUpdateTeamTrainingReplay mgsr16 = new MessageUpdateTeamTrainingReplay(plannedteamtrainingQuery4.upDateTeamTraining(MessageUpdateTeamTraining1.gettraining()));
			client.sendToClient(mgsr16);
			plannedteamtrainingQuery4.close();
			break;

		case MESSAGE_GET_ATHLETE_BY_USER_ID:
			athleteQuery athleteQuery= new athleteQuery();
			MessageGetAthleteByUserId MessageGetAthleteByUserId = (MessageGetAthleteByUserId) message ;
			MessageGetAthleteByUserIdReplay mgabid  = new MessageGetAthleteByUserIdReplay(athleteQuery.getAthleteByUserId(MessageGetAthleteByUserId.getUserId()));
			client.sendToClient(mgabid);
			athleteQuery.close();
			break;
		case MESSAGE_CREATE_NEW_TEAM_UN_PLANNED_TRAINING:
			PreformedPersonalTrainingQuery PreformedPersonalTrainingQuery = new PreformedPersonalTrainingQuery();
			MessageCreateNewUnPlannedTraining MessageCreateNewUnPlannedTraining = (MessageCreateNewUnPlannedTraining) message ;
			MessageCreateNewUnPlannedTrainingReplay msgr10 = new MessageCreateNewUnPlannedTrainingReplay(PreformedPersonalTrainingQuery.addUnPlannedTrainingByAthlete(MessageCreateNewUnPlannedTraining.getPreformedtraining()));
			client.sendToClient(msgr10);
			PreformedPersonalTrainingQuery.close();
			break;

		case MESSAGE_UPDATE_ATHLETE_TRAINING:
			plannedpersonaltrainingQuery plannedpersonaltrainingQuery1 = new plannedpersonaltrainingQuery();
			MessageUpdateAthleteTraining MessageUpdateAthleteTraining1 = (MessageUpdateAthleteTraining) message ;
			MessageUpdateAthleteTrainingReplay mgsr17 = new MessageUpdateAthleteTrainingReplay(plannedpersonaltrainingQuery1.upDatePersonalTraining(MessageUpdateAthleteTraining1.gettraining()));
			client.sendToClient(mgsr17);
			plannedpersonaltrainingQuery1.close();
			break;
		case MESSAGE_CREATE_NEW_PREFORMED_TEAM_PLANNED_TRAINING:
			PreformedTeamTrainingQuery PreformedTeamTrainingQuery = new PreformedTeamTrainingQuery();
			MessageCreateNewPreformedTeamPlannedTraining MessageCreateNewPreformedTeamPlannedTraining = (MessageCreateNewPreformedTeamPlannedTraining) message ;
			MessageCreateNewPreformedTeamPlannedTrainingReplay msgr11 = new MessageCreateNewPreformedTeamPlannedTrainingReplay(PreformedTeamTrainingQuery.addPlannedPreformedTeamTrainingByAthlete(MessageCreateNewPreformedTeamPlannedTraining.getPreformedTeamTraining()));
			client.sendToClient(msgr11);
			PreformedTeamTrainingQuery.close();
			break;
		case MESSAGE_GET_ALL_PEFORMED_TEAM_TRAINING_BY_ATHLETE:
			PreformedTeamTrainingQuery PreformedTeamTrainingQuery1 = new PreformedTeamTrainingQuery();
			MessageGetAllPreformedTeamTrainingByAtleteId MessageGetAllPreformedTeamTrainingByAtleteId = (MessageGetAllPreformedTeamTrainingByAtleteId) message ;
			MessageGetAllPreformedTeamTrainingByAtleteIdReplay msgr12 = new MessageGetAllPreformedTeamTrainingByAtleteIdReplay(PreformedTeamTrainingQuery1.getAllPersonalPreformedTeamTrainingByAthlete(MessageGetAllPreformedTeamTrainingByAtleteId.getAthleteId()));
			client.sendToClient(msgr12);
			PreformedTeamTrainingQuery1.close();
			break;
		case MESSAGE_GET_ALL_PEFORMED_PERSONAL_TRAINING_BY_ATHLETE:
			PreformedPersonalTrainingQuery PreformedPersonalTrainingQuery1 = new PreformedPersonalTrainingQuery();
			MessageGetAllPreformedTrainingByAtleteId MessageGetAllPreformedTrainingByAtleteId = (MessageGetAllPreformedTrainingByAtleteId) message ;
			MessageGetAllPreformedTrainingByAtleteIdReplay msgr13 = new MessageGetAllPreformedTrainingByAtleteIdReplay(PreformedPersonalTrainingQuery1.getAllPersonalPreformedTrainingByAthlete(MessageGetAllPreformedTrainingByAtleteId.getAthleteId()));
			client.sendToClient(msgr13);
			PreformedPersonalTrainingQuery1.close();
			break;
			


			
	
			
		}
	}
	
	private void login() throws SQLException, IOException{
		String str=null;
		boolean pass =true;
		User user = null;
		MessageLogin login = (MessageLogin) message;
		
		UserQuery userQuery = new UserQuery();
		if (userQuery.isExist(login.getUserName())){
			user = userQuery.getUserByName(login.getUserName());
			if (login.getPassword().equals(user.getPassword())){
				if (user.isOnline()==1){
					pass = false;
					str = "User already login, try again later.";
				}
				
			}
			else {
				str = "Forgot your password? please contact Youre Administrator.";
				pass=false;
			}
		}
		else {
				if (login.getUserName().isEmpty())
					str = "Please enter user name.";
				else
					str = "Wrong user name, please try again.";
				pass= false;
			}
		//if (pass) userQuery.setOnline(user.getIdUser());
		userQuery.close();
		client.sendToClient(new MessageLoginReplay(pass, user, str));
	}
	
	
	
	
	
}
