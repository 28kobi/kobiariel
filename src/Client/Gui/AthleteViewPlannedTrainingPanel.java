package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Server.DataBase.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import Server.GUI.MyJTable;
import Server.Message.MessageGetAllPersonalTrainingByAtleteId;
import Server.Message.MessageGetAllPersonalTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetAthleteByUserId;
import Server.Message.MessageGetAthleteByUserIdReplay;

import Client.Logic.ClientIF;


public class AthleteViewPlannedTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	private AthelteViewPlannedTeamTrainingTableModel stm;
	private AthelteViewPlannedPersonalTrainingTableModel stm2;
	private MyJTable table;
	private MyJTable table2;
	private ArrayList<plannedteamtraining> Allplannedteamtraining=null ;
	private ArrayList<plannedpersonaltraining> Allplannedpersonaltraining=null ;
	private int id;
	private JLabel lblListOfAll;
	private JLabel lblPersonalTraining;
	private athlete Athlete;
   

	
   
    
	
	
	public AthleteViewPlannedTrainingPanel(ClientIF client) {
		super(PanelType.ATHLETE_VIEW_PLANNED_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPlannedTrainging = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPlannedTrainging.setBounds(149, 11, 340, 46);
			add(lblPlannedTrainging);
			
			Athlete=new athlete();
			getClient().sendMsgToServer(new MessageGetAthleteByUserId(getClient().getUser().getIdUser()));
			MessageGetAthleteByUserIdReplay rep4= (MessageGetAthleteByUserIdReplay)getClient().getMessageFromServer();
			Athlete = rep4.getAthlete();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
init();
		
	}	
	public void initLables(){
	 lblListOfAll = new JLabel("PLANNED TEAM TRAINING:");
		lblListOfAll.setBounds(10, 115, 375, 14);
		add(lblListOfAll);
		
		 lblPersonalTraining = new JLabel("PLANNED PERSONAL TRAINING:");
		lblPersonalTraining.setBounds(10, 288, 349, 14);
		add(lblPersonalTraining);
	}
		public void initArrays(){
			
			Allplannedteamtraining = new ArrayList<plannedteamtraining>();
			getClient().sendMsgToServer(new MessageGetAllTeamTrainingByTeamId(Athlete.getTeamId()));
			MessageGetAllTeamTrainingByTeamIdReplay mgap = (MessageGetAllTeamTrainingByTeamIdReplay)getClient().getMessageFromServer();
			Allplannedteamtraining = mgap.getArray();
			
			
			Allplannedpersonaltraining = new ArrayList<plannedpersonaltraining>();
			getClient().sendMsgToServer(new MessageGetAllPersonalTrainingByAtleteId(Athlete.getUserid()));
			MessageGetAllPersonalTrainingByAtleteIdReplay mgapttba1 = (MessageGetAllPersonalTrainingByAtleteIdReplay)getClient().getMessageFromServer();
			Allplannedpersonaltraining = mgapttba1.getPersonalTrainingArray();
		}
		
		
		
		public void initTables(){
			stm = new AthelteViewPlannedTeamTrainingTableModel();		
			stm.setArray(Allplannedteamtraining);
			table = new MyJTable(stm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(10, 140, 772, 120);
		add(table);
			
		stm2 = new AthelteViewPlannedPersonalTrainingTableModel();		
		stm2.setArray(Allplannedpersonaltraining);
		table2 = new MyJTable(stm2);
	table2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	table2.setBounds(10, 325, 772, 120);
	add(table2);
	
	
		
	}
		
		public void init() 
		{
			
			initArrays();
			initTables();
			initLables();
		}	
			
		
		
	
	   
	
	
	
  

	
	private void popUp(String msg){
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new AthleteViewPlannedTrainingPanel(getClient());
	}
}



