package Server.Message;
import Server.logic.Message;


	public class MessageGetPlannedTrainingByTrainingId extends Message{
		
		private static final long serialVersionUID = 1L;
		
		private int trainingId;
		
		
		/**
		 * constructor
		 */
		public MessageGetPlannedTrainingByTrainingId(int trainingId) {
				super(MessageType.MESSAGE_GET_TRAINING_BY_TRAINING_ID);
				this.setTrainingId(trainingId);
				
			}


		public int getTrainingId() {
			return trainingId;
		}


		public void setTrainingId(int trainingId) {
			this.trainingId = trainingId;
		}


		



	}
