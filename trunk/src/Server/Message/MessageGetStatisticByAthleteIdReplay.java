package Server.Message;


import Server.DataBase.statistic;
import Server.DataBase.statisticQuery;
import Server.logic.*;


public class MessageGetStatisticByAthleteIdReplay extends Message  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private statistic statisticQ;
/**
 * constructor
 */
 	
    public MessageGetStatisticByAthleteIdReplay(statistic statisticQ) {
		super(MessageType.MESSAGE_GET_STATISTIC_BY_ATHLETE_ID_REPLAY);
		this.setStatisticQ(statisticQ);
	}
public statistic getStatisticQ() {
	return statisticQ;
}
public void setStatisticQ(statistic statisticQ) {
	this.statisticQ = statisticQ;
}



}