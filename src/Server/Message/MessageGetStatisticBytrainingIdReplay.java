package Server.Message;


import Server.DataBase.statistic;
import Server.DataBase.statisticQuery;
import Server.logic.*;


public class MessageGetStatisticBytrainingIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private statistic statisticQ;
/**
 * constructor
 */
 	
    public MessageGetStatisticBytrainingIdReplay(statistic statisticQ) {
		super(MessageType.MESSAGE_GET_TRAINING_STATISTIC_BY_TRAINING_ID_REPLAY);
		this.setStatisticQ(statisticQ);
	}
public statistic getStatisticQ() {
	return statisticQ;
}
public void setStatisticQ(statistic statisticQ) {
	this.statisticQ = statisticQ;
}



}