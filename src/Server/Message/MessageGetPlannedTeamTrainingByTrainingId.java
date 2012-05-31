package Server.Message;
import Server.logic.Message;


	public class MessageGetPlannedTeamTrainingByTrainingId extends Message{
		
		private static final long serialVersionUID = 1L;
	
		private int trainingId;
		
		
		/**
		 * constructor
		 */
		public MessageGetPlannedTeamTrainingByTrainingId(int trainingId) {
				super(MessageType.MESSAGE_GET_TEAM_TRAINING_BY_TRAINING_ID);
			this.setTrainingId(trainingId);
				
			}

		public int getTrainingId() {
		return trainingId;
		}

		public void setTrainingId(int trainingId) {
			this.trainingId = trainingId;
		}


			



		}
