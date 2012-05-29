package Server.Message;
import Server.logic.Message;


	public class MessageGetAthleteByUserId extends Message{
		
		private static final long serialVersionUID = 1L;
		
		private int userId;
		
		
		/**
		 * constructor
		 */
		public MessageGetAthleteByUserId(int userId) {
				super(MessageType.MESSAGE_GET_ATHLETE_BY_USER_ID);
				this.setUserId(userId);
				
			}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}





	}
