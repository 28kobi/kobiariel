package Client.Gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.jfree.ui.RefineryUtilities;

import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.statistic;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetStatisticByAthleteId;
import Server.Message.MessageGetStatisticByAthleteIdReplay;
import Server.Message.MessageGetStatisticBytrainingId;
import Server.Message.MessageGetStatisticBytrainingIdReplay;

import Client.Logic.ClientIF;


public class AthleteViewStatisticInfoPanel extends MyJPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private plannedteamtraining plannedteamtraining;
	private JLabel lblChooseTraining;
	private JRadioButton rdbtnTeamTraining;
	private JButton btnViewStatistic;
	private JRadioButton rdbtnPersonalTraining;
	private BarChart  bar;
	private TeamBarChart teamBar;
	private ArrayList <String> colu;
	private statistic statisticQ=null;
	private JComboBox comboBoxTraining;
	
   
    
	
	
	public AthleteViewStatisticInfoPanel(ClientIF client) {
		super(PanelType.ATHLETE_VIEW_STATISTIC_INFO, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		init();
	}
		
	
		
		
		
	public void	init(){
			
	
		statisticQ = new statistic();
		getClient().sendMsgToServer(new MessageGetStatisticByAthleteId(client.getUser().getIdUser()));
		MessageGetStatisticByAthleteIdReplay rep5= (MessageGetStatisticByAthleteIdReplay)getClient().getMessageFromServer();
		statisticQ = rep5.getStatisticQ();
		bar= new BarChart("statistic",statisticQ);
		bar.pack();
        RefineryUtilities.centerFrameOnScreen(bar);
        bar.setVisible(true);	
		
		}
	
	
	
   
    
    
    
    
  
			
		
	
	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	@Override
	public MyJPanel pushPanel() {
		return new AthleteViewStatisticInfoPanel(getClient());
	}
}



