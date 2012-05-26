package Client.Gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllPersonalTrainingByAtleteId;
import Server.Message.MessageGetAllPersonalTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.DataBase.athlete;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.trainingtype;

import java.awt.event.ActionListener;
import Client.Logic.ClientIF;
import javax.swing.JButton;


public class EditTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private plannedteamtraining teamTraining;
	private ArrayList<plannedpersonaltraining> allPersonalTrainingArray =null;
	private plannedpersonaltraining AthletTraining;
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	private JRadioButton rdbtnTeamTraining;
	private JRadioButton rdbtnPersonalTraining;
	private JLabel lblChooseTraining;
	private User Athlete;
	private Team team1;
	private activitytype activityType;
	private JComboBox comboBoxTeams;
	private JComboBox comboBoxAthlete;
	private JComboBox comboBoxTraining;
	private JComboBox comboBoxMin;
	private JComboBox comboBoxActivityType ;
	private JComboBox comboBoxTrainingType;
	private JComboBox comboBoxHour;
	private JComboBox comboBoxDay;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JLabel lblTrainingDate;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JLabel lblHour;
	private JLabel lblMi; 
	private JLabel lblYear;
	private JLabel lblActivityType;
	private JLabel lblTrainingType;
	private JLabel lblDetails ;
	private JLabel lblDuration;
	private JLabel lblDistance;
	private JLabel lblTime ;
	private JTextField textFieldDetails;
	private JTextField textFieldDuration;
	private JTextField textFieldDistance ;
	private String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] year={"2012","2013","2014","2015","2016"};
	
	
	public EditTrainingPanel(ClientIF client) {
		super(PanelType.EDIT_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPerformedTraining = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPerformedTraining.setBounds(477, 11, 12, 43);
			add(lblPerformedTraining);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	   init();
	}
	
	public void inittable(){
		
	}
	public void initArrays(){
		
	       
		allTeamArray = new ArrayList<Team>();
		getClient().sendMsgToServer(new MessageGetAllTeamByCoachId(getClient().getUser().getIdUser()));
		MessageGetAllTeamByCoachReplay rep1= (MessageGetAllTeamByCoachReplay)getClient().getMessageFromServer();
		allTeamArray = rep1.getArray();
		
		allAthleteArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(client.getUser().getIdUser()));
		MessageGetAllAthleteByCoachIdReplay rep2= (MessageGetAllAthleteByCoachIdReplay)getClient().getMessageFromServer();
		allAthleteArray = rep2.getArray();
		
		allAactivityTypeArray = new ArrayList<activitytype>();
		getClient().sendMsgToServer(new MessageGetAllAactivityType());
		MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
		allAactivityTypeArray = rep3.getArray();
		
	}
	public void initLabel(){
		

		lblChooseTraining = new JLabel("choose training:");
		lblChooseTraining.setBounds(6, 85, 105, 14);
		add(lblChooseTraining);
		
		lblDetails = new JLabel("Details: ");
		lblDetails.setBounds(6, 300, 109, 14);
		add(lblDetails);
				
		lblDuration = new JLabel("Duration: ");
		lblDuration.setBounds(6, 330, 82, 14);
		add(lblDuration);
				
		lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(6, 360, 82, 14);
		add(lblDistance);
		
		lblTrainingDate = new JLabel("Training Date:");
		lblTrainingDate.setBounds(6, 180, 87, 14);
		add(lblTrainingDate);
		
		lblDay = new JLabel("day:");
		lblDay.setBounds(98, 180, 46, 14);
		add(lblDay);
		
		lblMonth = new JLabel("month:");
		lblMonth.setBounds(222, 180, 46, 14);
		add(lblMonth);
		
		lblYear = new JLabel("year:");
		lblYear.setBounds(350, 180, 46, 14);
		add(lblYear);
		
		lblHour = new JLabel("hour:");
		lblHour.setBounds(93, 210, 53, 14);
		add(lblHour);
		
		lblMi = new JLabel("min:");
		lblMi.setBounds(258, 210, 46, 14);
		add(lblMi);
		
		lblTime = new JLabel("Time:");
		lblTime.setBounds(6, 210, 68, 14);
		add(lblTime);
		
		lblTrainingType = new JLabel("Training Type :");
		lblTrainingType.setBounds(6, 270, 105, 14);
		add(lblTrainingType);
		
		lblActivityType = new JLabel("Activity Type:");
		lblActivityType.setBounds(6, 240, 105, 14);
		add(lblActivityType);
		
		
		
	}
public void initTextField(){
		
		textFieldDistance = new JTextField();
		textFieldDistance.setBounds(150, 360, 153, 24);
		add(textFieldDistance);
		
		
		textFieldDuration = new JTextField();
		textFieldDuration.setBounds(150, 330, 184, 23);
		add(textFieldDuration);
		
		
		textFieldDetails = new JTextField();
		textFieldDetails.setBounds(150, 300, 311, 23);
		add(textFieldDetails);
		
	}
	public void initBtn(){
		
	}
	 public void initJRadioButton(){
			
		    rdbtnTeamTraining = new JRadioButton("team training");
		    rdbtnTeamTraining.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    			if(rdbtnTeamTraining.isSelected()){
		    				comboBoxTeams.setEnabled(true);
		    				comboBoxAthlete.setEnabled(false);
		    				if(rdbtnPersonalTraining.isSelected()){
		    					rdbtnPersonalTraining.doClick();
		    					comboBoxTraining.setEnabled(false);
		    				}
		    				comboBoxTeams.setEnabled(true);
		    			}
		    			else 
		    				comboBoxTeams.setEnabled(false);	
		    				
		    				
		    	}
		    });
			rdbtnTeamTraining.setBounds(6, 7, 109, 23);
			add(rdbtnTeamTraining);
			
			rdbtnPersonalTraining = new JRadioButton("personal training");
			rdbtnPersonalTraining.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnPersonalTraining.isSelected()){
						comboBoxAthlete.setEnabled(true);
						comboBoxTeams.setEnabled(false);
	    				if(rdbtnTeamTraining.isSelected()){
	    					rdbtnTeamTraining.doClick();
	    					comboBoxTraining.setEnabled(false);
	    				}
	    				comboBoxTeams.setEnabled(false);
	    			}
	    			else 
	    				comboBoxAthlete.setEnabled(false);
					
					
				}
			});
			if(rdbtnTeamTraining.isSelected())
				comboBoxTeams.setEnabled(true);
			else 
				comboBoxTeams.setEnabled(false);	

			rdbtnPersonalTraining.setBounds(6, 34, 109, 23);
			add(rdbtnPersonalTraining); 
			
			
	 }
	
	 public void initComboBox(){
		 
		 	comboBoxDay = new JComboBox();
			comboBoxDay.setBounds(151, 180, 60, 20);
			comboBoxDay.setEnabled(false);
			add(comboBoxDay);
			
			comboBoxMonth = new JComboBox();
			comboBoxMonth.setBounds(274, 180, 61, 20);			
			 for (int i=0; i<=month.length; i++)
				{
					if (i==0) comboBoxMonth.addItem("Choose..");
					else comboBoxMonth.addItem(month[i-1]);
					}
			add(comboBoxMonth);
			
			comboBoxYear = new JComboBox();
			comboBoxYear.setBounds(391, 180, 71, 20);
			 for (int j=0; j<=year.length; j++)
				{
					if (j==0) comboBoxYear.addItem("Choose..");
					else comboBoxYear.addItem(year[j-1]);
					}
			add(comboBoxYear);
			
			comboBoxHour = new JComboBox();
			comboBoxHour.setBounds(151, 210, 71, 20);
			for(int hour=0;hour<25;hour++){
				if(hour==0) comboBoxHour.addItem("choose..");
				else comboBoxHour.addItem(Integer.toString(hour));
				
			}
			add(comboBoxHour);
						
			comboBoxMin = new JComboBox();
			comboBoxMin.setBounds(300, 210, 71, 20);
			for(int min=0;min<75;min=min+15){
				if(min==0) comboBoxMin.addItem("choose..");
				else comboBoxMin.addItem(Integer.toString(min));
				
			}
			add(comboBoxMin);
			
			comboBoxActivityType = new JComboBox();		
			
			comboBoxActivityType.setBounds(150, 240, 105, 20);
			add(comboBoxActivityType);
						
			comboBoxTrainingType = new JComboBox();
			comboBoxTrainingType.setBounds(150, 270, 109, 20);
			add(comboBoxTrainingType);
			comboBoxTrainingType.setEnabled(false);

			comboBoxTraining = new JComboBox();
			comboBoxTraining.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnPersonalTraining.isSelected()){
						AthletTraining=(plannedpersonaltraining)comboBoxTraining.getSelectedItem();
					
					}
					
					
					
				}
			});
			comboBoxTraining.setBounds(151,82, 117, 20);
			comboBoxTraining.setEnabled(false);
			add(comboBoxTraining);
			comboBoxTraining.setEnabled(false);
			
		    comboBoxTeams = new JComboBox();
		    comboBoxTeams.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		if(!comboBoxTeams.getSelectedItem().toString().equals("Choose..")){			
						allTeamTrainingArray = new ArrayList<plannedteamtraining>();
						team1 = (Team)comboBoxTeams.getSelectedItem();
					  	getClient().sendMsgToServer(new MessageGetAllTeamTrainingByTeamId(team1.getTeamId()));
					  	MessageGetAllTeamTrainingByTeamIdReplay rep5= (MessageGetAllTeamTrainingByTeamIdReplay)getClient().getMessageFromServer();
						allTeamTrainingArray = rep5.getArray();
						comboBoxTraining.removeAllItems();
		    			
		    			 for (int i=0; i<=allTeamTrainingArray.size(); i++)
		    				{
		    					if (i==0) comboBoxTraining.addItem("Choose..");
		    					else comboBoxTraining.addItem(allTeamTrainingArray.get(i-1));
		    					}
		    			 comboBoxTraining.setEnabled(true);
		    		}
		    		
					
		    	}
		    });
			comboBoxTeams.setBounds(151, 7, 117, 20);
			add(comboBoxTeams);
			comboBoxTeams.setEnabled(false);
			
			comboBoxAthlete = new JComboBox();
			comboBoxAthlete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){			
						allPersonalTrainingArray = new ArrayList<plannedpersonaltraining>();
			
						Athlete = (User) comboBoxAthlete.getSelectedItem();
						
					  	getClient().sendMsgToServer(new MessageGetAllPersonalTrainingByAtleteId(Athlete.getIdUser()));
					  	MessageGetAllPersonalTrainingByAtleteIdReplay rep6= (MessageGetAllPersonalTrainingByAtleteIdReplay)getClient().getMessageFromServer();
					  	allPersonalTrainingArray = rep6.getPersonalTrainingArray();
					  	comboBoxTraining.removeAllItems();
		    			 for (int i=0; i<=allPersonalTrainingArray.size(); i++)
		    				{
		    					if (i==0) comboBoxTraining.addItem("Choose..");
		    					else comboBoxTraining.addItem(allPersonalTrainingArray.get(i-1));
		    					}
		    			 comboBoxTraining.setEnabled(true);
		    		}
		    		
					
				
				}
			});
			comboBoxAthlete.setBounds(151,38, 117, 20);
			comboBoxAthlete.setEnabled(false);
			add(comboBoxAthlete);
			comboBoxAthlete.setEnabled(false);
			
			
	 }
	public void init(){
		initTextField();
		initComboBox();
		initArrays();
		initJRadioButton();
		initBtn();
		initLabel();
		 for (int i=0; i<=allTeamArray.size(); i++)
			{
				if (i==0) comboBoxTeams.addItem("Choose..");
				else comboBoxTeams.addItem(allTeamArray.get(i-1));
				}
		  
		  for (int j=0; j<=allAthleteArray.size(); j++)
			{
				if (j==0) comboBoxAthlete.addItem("Choose..");
				else comboBoxAthlete.addItem(allAthleteArray.get(j-1));
				}
		  comboBoxActivityType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					activityType=(activitytype)comboBoxActivityType.getSelectedItem();

					alltrainingTypeArray = new ArrayList<trainingtype>();
					getClient().sendMsgToServer(new MessageGetAllTrainingType(activityType.getActivityId()));
					MessageGetAllTrainingTypeReplay rep4= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
					alltrainingTypeArray = rep4.getArray();
					comboBoxTrainingType.setEnabled(false);
					comboBoxTrainingType.removeAllItems();
				    for (int i=0; i<=alltrainingTypeArray.size(); i++)
							{
							if (i==0) comboBoxTrainingType.addItem("Choose..");
							else comboBoxTrainingType.addItem(alltrainingTypeArray.get(i-1));
							}
					
				    comboBoxTrainingType.setEnabled(true);
				}
			});
		  
		  comboBoxMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int month= Integer.parseInt((String) comboBoxMonth.getSelectedItem());
					 switch (month) {
					 		case 1:case 3:case 5:case 7:case 8: case 10: 
					 			comboBoxDay.removeAllItems();
			            		for(int i=0;i<32;i++){
			            			if (i==0) comboBoxDay.addItem("Choose..");
			            			else comboBoxDay.addItem(i);
			            		}
			            		 comboBoxDay.setEnabled(true);
			                     break;
			           	case 2:
			           		comboBoxDay.removeAllItems();
					 			for(int i=0;i<29;i++){
					 				if (i==0) comboBoxDay.addItem("Choose..");
					 				else comboBoxDay.addItem(i);
					 				}
					 			comboBoxDay.setEnabled(true);
			                    break;
			            case 4:case 6:case 9:case 11:
			            	comboBoxDay.removeAllItems();
			            		for(int i=0;i<31;i++){
			            			if (i==0) comboBoxDay.addItem("Choose..");
			            			else comboBoxDay.addItem(i);
	           	            		}
			            		comboBoxDay.setEnabled(true);
			            		break;
					 }
					 
				}	 
			      
			});
		  
		  
		
	}
	
	private void popUp(String msg){
		
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new EditTrainingPanel(getClient());
	}
}



