package Server.logic;

import java.io.Serializable;


/**
 * This is our Message system we use to send messages between the client to the server.
 * all messages inherits from this class. every message has a unique purpose and it gets it 
 * type from the enum to the server or the client can identify what the message meaning is.
 */
public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum MessageType {
		MESSAGE_LOGIN,
		MESSAGE_LOGOUT,
		MESSAGE_LOGIN_REPLY,
		MESSAGE_GET_ALL_COACH,
		MESSAGE_GET_ALL_COACH_REPLAY,
		MESSAGE_UPDATE_COACH,
		MESSAGE_UPDATE_COACH_REPLAY,
		MESSAGE_CREATE_NEW_COACH,
		MESSAGE_CREATE_NEW_COACH_REPLAY,
		MESSAGE_GET_ALL_TEAM,
		MESSAGE_GET_ALL_TEAM_REPLAY,
		MESSAGE_GET_USER_BY_USER_ID,
		MESSAGE_GET_ALL_TRAINING_BY_TEAM_ID,
		MESSAGE_GET_ALL_TRAINING_BY_TEAM_ID_REPLAY,
		MESSAGE_GET_ALL_TRAINING_BY_ATHLETE_ID,
		MESSAGE_GET_ALL_TRAINING_BY_ATHLETE_ID_REPLAY,
		MESSAGE_GET_USER_BY_USER_ID_REPLAY,
		MESSAGE_UPDATE_TEAM,
		MESSAGE_UPDATE_TEAM_REPLAY,
		MESSAGE_CREATE_NEW_TEAM,
		MESSAGE_CREATE_NEW_TEAM_REPLAY,
		MESSAGE_CREATE_NEW_ATHLETE,
		MESSAGE_CREATE_NEW_ATHLETE_REPLAY,
		MESSAGE_GET_ALL_TEAM_BY_COACH_ID,
		MESSAGE_GET_ALL_TEAM_BY_COACH_ID_REPLAY,
		MESSAGE_ASSIGN_ATHLETE_TO_TEAM,
		MESSAGE_ASSIGN_ATHLETE_TO_TEAM_REPLAY,
		MESSAGE_GET_ALL_ATHLETE_BY_COACH_ID,
		MESSAGE_GET_ALL_ATHLETE_BY_COACH_ID_REPLAY,
		MESSAGE_UPDATE_ATHLETE,
		MESSAGE_UPDATE_ATHLETE_REPLAY,
		MESSAGE_GET_ALL_UNTEAMED_ATHLETE,
		MESSAGE_GET_ALL_UNTEAMED_ATHLETE_REPLAY,
		MESSAGE_GET_ALL_ACTIVITY_TYPE,
		MESSAGE_GET_ALL_ACTIVITY_TYPE_REPLAY,
		MESSAGE_GET_ALL_TRAINING_TYPE,
		MESSAGE_GET_ALL_TRAINING_TYPE_REPLAY,
		MESSAGE_CREATE_NEW_TEAM_TRAINING,
		MESSAGE_CREATE_NEW_TEAM_TRAINING_REPLAY,
		MESSAGE_CREATE_NEW_PERSONAL_TRAINING,
		MESSAGE_CREATE_NEW_PERSONAL_TRAINING_REPLAY,
		MESSAGE_CREATE_NEW_ACTIVITY_TYPE,
		MESSAGE_CREATE_NEW_ACTIVITY_TYPE_REPLAY,
		MESSAGE_REMOVE_ACTIVITY_TYPE,
		MESSAGE_REMOVE_ACTIVITY_TYPE_REPLAY,
		MESSAGE_CREATE_NEW_TRAINING_TYPE,
		MESSAGE_CREATE_NEW_TRAINING_TYPE_REPLAY,
		MESSAGE_GET_ATHLETE_BY_USER_ID,
		MESSAGE_GET_ATHLETE_BY_USER_ID_REPLAY,
		MESSAGE_CREATE_NEW_TEAM_UN_PLANNED_TRAINING,
		MESSAGE_CREATE_NEW_TEAM_UN_PLANNED_TRAINING_REPLAY,
		MESSAGE_UPDATE_TEAMTRAINING,
		MESSAGE_UPDATE_TEAMTRAINING_REPLAY,
		MESSAGE_UPDATE_ATHLETE_TRAINING,
		MESSAGE_UPDATE_ATHLETE_TRAINING_REPLAY,
		MESSAGE_CREATE_NEW_PREFORMED_TEAM_PLANNED_TRAINING,
		MESSAGE_CREATE_NEW_PREORMED_TEAM_PLANNED_TRAINING_REPLAY,
		MESSAGE_GET_ALL_PEFORMED_PERSONAL_TRAINING_BY_ATHLETE,
		MESSAGE_GET_ALL_PEFORMED_PERSONAL_TRAINING_BY_ATHLETE_REPLAY,
		MESSAGE_GET_TRAINING_BY_TRAINING_ID,
		MESSAGE_GET_TRAINING_BY_TRAINING_ID_REPLAY,
		MESSAGE_GET_TEAM_TRAINING_BY_TRAINING_ID,
		MESSAGE_GET_TEAM_TRAINING_BY_TRAINING_ID_REPLAY,
		MESSAGE_GET_ALL_PEFORMED_TEAM_TRAINING_BY_ATHLETE,
		MESSAGE_GET_ALL_PEFORMED_TEAM_TRAINING_BY_ATHLETE_REPLAY,
		MESSAGE_REMOVE_ATHLETE_FROM_TEAM,
		MESSAGE_REMOVE_ATHLETE_FROM_TEAM_REPLAY,
		MESSAGE_GET_STATISTIC_BY_ATHLETE_ID,
		MESSAGE_GET_STATISTIC_BY_ATHLETE_ID_REPLAY,
		MESSAGE_GET_TRAINING_STATISTIC_BY_TRAINING_ID,
		MESSAGE_GET_TRAINING_STATISTIC_BY_TRAINING_ID_REPLAY,
		MESSAGE_GET_ALL_USER_REPLAY,
		MESSAGE_GET_ALL_USER,
		MESSAGE_GET_ALL_UN_PREFORMED_TEAM_TRAINING_BY_TEAM_ID_REPLAY,
		MESSAGE_GET_ALL_UN_PREFORMED_PERSONAL_TRAINING_BY_ATHLETE_ID,
		MESSAGE_GET_ALL_UN_PREFORMED_PERSONAL_TRAINING_BY_ATHLETE_ID_REPLAY,
		MESSAGE_GET_ALL_UN_PREFORMED_TEAM_TRAINING_BY_TEAM_ID,
	}
	
	private MessageType messageType;
	
	/**
	 **
	 * @param type Message type
	 */
	public Message(MessageType type){
		messageType = type;	
	}

	
	/**
	 * 
	 * @return Message type
	 */
	public MessageType getMessageType(){
		return messageType;	
	}
}