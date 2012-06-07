package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.trainingtype;
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
import Server.Message.MessageUpdateAthleteTraining;
import Server.Message.MessageUpdateAthleteTrainingReplay;
import Server.Message.MessageUpdateTeamTraining;
import Server.Message.MessageUpdateTeamTrainingReplay;

import Client.Logic.ClientIF;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class ViewPlannedTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private plannedteamtraining teamTraining;
	private plannedteamtraining updatedTraining;
	private plannedpersonaltraining updatedTraining1;
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
	
	private JButton btnW ;
	private JLabel lblActivityName;
	private JTextPane textPaneActivity;
	private JLabel lblTraining;
	private JTextPane textPaneTraining;
	private JLabel lblDate;
	private JTextPane textPaneDate ;
	private JLabel lblTime_1 ;
	private JTextPane textPaneTime;
	private JLabel lblDetails_1;
	private JTextPane textPaneDetails;
	private JLabel lblDuration_1;
	private JTextPane textPaneDuration;
	private JLabel lblDistance_1 ;
	private JTextPane textPaneDistance ;
	
	public ViewPlannedTrainingPanel(ClientIF client) {
		super(PanelType.COACH_VIEW_PLLANED_TRAINING_PANEL, client);
		setLayout(null);
			
		
		   init();
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
			

			lblChooseTraining = new JLabel("Choose Training By Dates:");
			lblChooseTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblChooseTraining.setBounds(6, 150, 185, 25);
			add(lblChooseTraining);
			
			lblActivityName = new JLabel("Activity Name:");
			lblActivityName.setFont(new Font("Arial", Font.PLAIN, 15));
			
			lblActivityName.setBackground(Color.WHITE);
			lblActivityName.setBounds(6, 222, 102, 25);
			add(lblActivityName);
			
			
			
			lblTraining = new JLabel("Training Name:");
			lblTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTraining.setBounds(6, 258, 102, 25);
			add(lblTraining);
			
			
			
			lblDate = new JLabel("Date:");
			lblDate.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDate.setBounds(6, 294, 78, 25);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("Time:");
			lblTime_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime_1.setBounds(6, 402, 71, 25);
			add(lblTime_1);
			
			
			
			lblDetails_1 = new JLabel("Details:");
			lblDetails_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails_1.setBounds(6, 438, 71, 25);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("Duration:");
			lblDuration_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration_1.setBounds(6, 366, 78, 25);
			add(lblDuration_1);
			
			
			lblDistance_1 = new JLabel("Distance:");
			lblDistance_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance_1.setBounds(6, 330, 71, 25);
			add(lblDistance_1);
			
			
		}
	public void initTextPane(){
		textPaneDuration = new JTextPane();
		textPaneDuration.setBounds(150, 366, 168, 25);
		textPaneDuration.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDuration.setBackground(UIManager.getColor("Button.light"));
		add(textPaneDuration);
		
		textPaneDistance = new JTextPane();
		textPaneDistance.setBounds(150, 330, 168, 30);
		textPaneDistance.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDistance.setBackground(UIManager.getColor("Button.light"));
		add(textPaneDistance);
		
		textPaneDate = new JTextPane();
		textPaneDate.setBounds(150, 294, 168, 25);
		textPaneDate.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDate.setBackground(UIManager.getColor("Button.light"));
		add(textPaneDate);
		
		textPaneDetails = new JTextPane();
		textPaneDetails.setBounds(150, 438, 168, 25);
		textPaneDetails.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneDetails.setBackground(UIManager.getColor("Button.light"));
		add(textPaneDetails);
		
		textPaneTime = new JTextPane();
		textPaneTime.setBounds(150, 402, 168, 25);
		textPaneTime.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneTime.setBackground(UIManager.getColor("Button.light"));
		add(textPaneTime);
		
		textPaneActivity = new JTextPane();
		textPaneActivity.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneActivity.setBounds(150, 222, 168, 25);
		textPaneActivity.setBackground(UIManager.getColor("Button.light"));
		add(textPaneActivity);
		
		textPaneTraining = new JTextPane();
		textPaneTraining.setBounds(150, 258, 168, 25);
		textPaneTraining.setFont(new Font("Arial", Font.BOLD, 15));
		textPaneTraining.setBackground(UIManager.getColor("Button.light"));
		add(textPaneTraining);
		
		
		
		
	}
		
	
		public void initBtn(){
			
			btnW = new JButton("View Details");
			btnW.setForeground(Color.BLUE);
			btnW.setFont(new Font("Arial", Font.PLAIN, 15));
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String msg;
						if(rdbtnPersonalTraining.isSelected()){
							if(!comboBoxTraining.getSelectedItem().toString().equals("Choose..")){
								
								AthletTraining=(plannedpersonaltraining)comboBoxTraining.getSelectedItem();
								String activityName=null,trainingName=null,time,duration,distance,details;
								String date;
								for (int i=0; i<allAactivityTypeArray.size(); i++)
								{
									if  (allAactivityTypeArray.get(i).getActivityId()==AthletTraining.getActivityid())
										activityName=allAactivityTypeArray.get(i).getActivityName();
								}
								alltrainingTypeArray = new ArrayList<trainingtype>();
								getClient().sendMsgToServer(new MessageGetAllTrainingType(AthletTraining.getActivityid()));
								MessageGetAllTrainingTypeReplay rep5= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
							
								alltrainingTypeArray = rep5.getArray();
								for (int j=0; j<alltrainingTypeArray.size(); j++)
									{
									if  (alltrainingTypeArray.get(j).getTrainingId()==AthletTraining.getTrainingTypeId())
										trainingName=alltrainingTypeArray.get(j).gettrainingName();
									
									}
								date=AthletTraining.getDate();
								time=AthletTraining.getTime();
								duration=AthletTraining.getDuration();
								distance=AthletTraining.getDistance();
								details=AthletTraining.getDetails();
								textPaneActivity.setText(activityName);
								textPaneTraining.setText(trainingName);
								textPaneDuration.setText(duration);
								textPaneDistance.setText(distance);
								textPaneDate.setText(date);
								textPaneDetails.setText(details);
								textPaneTime.setText(time);
							
								}
							else{
								msg="choose athlete";
								popUp(msg);
							}
							
						}	
						
						if(rdbtnTeamTraining.isSelected()){
							if(!(comboBoxTraining.getSelectedItem().toString().equals("Choose.."))){
								
								teamTraining=(plannedteamtraining)comboBoxTraining.getSelectedItem();
								String activityName=null,trainingName=null,time,duration,distance,details;
								String date;
								for (int i=0; i<allAactivityTypeArray.size(); i++)
								{
									if  (allAactivityTypeArray.get(i).getActivityId()==teamTraining.getActivityid())
										activityName=allAactivityTypeArray.get(i).getActivityName();
								}
								alltrainingTypeArray = new ArrayList<trainingtype>();
								getClient().sendMsgToServer(new MessageGetAllTrainingType(teamTraining.getActivityid()));
								MessageGetAllTrainingTypeReplay rep5= (MessageGetAllTrainingTypeReplay)getClient().getMessageFromServer();
							
								alltrainingTypeArray = rep5.getArray();
								for (int j=0; j<alltrainingTypeArray.size(); j++)
									{
									if  (alltrainingTypeArray.get(j).getTrainingId()==teamTraining.getTrainingTypeId())
										trainingName=alltrainingTypeArray.get(j).gettrainingName();
									
									}
								date=teamTraining.getDate();
								time=teamTraining.getTime();
								duration=teamTraining.getDuration();
								distance=teamTraining.getDistance();
								details=teamTraining.getDetails();
								textPaneActivity.setText(activityName);
								textPaneTraining.setText(trainingName);
								textPaneDuration.setText(duration);
								textPaneDistance.setText(distance);
								textPaneDate.setText(date);
								textPaneDetails.setText(details);
								textPaneTime.setText(time);
							
								}
							else{
								msg="choose team";
								popUp(msg);
							}
							}	
						if(!rdbtnTeamTraining.isSelected()&&!rdbtnPersonalTraining.isSelected()){
							msg="choose - team or athlete";
							popUp(msg);
						}
					}
				});
			
			
			btnW.setBounds(328, 93, 127, 83);
			add(btnW);
		}
		 public void initJRadioButton(){
				
			    rdbtnTeamTraining = new JRadioButton("Team Training");
			    rdbtnTeamTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			    rdbtnTeamTraining.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    			if(rdbtnTeamTraining.isSelected()){
			    				comboBoxTraining.removeAllItems();
								comboBoxTraining.validate();
								comboBoxTraining.addItem("Choose..");
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
				rdbtnTeamTraining.setBounds(6, 94, 189, 23);
				add(rdbtnTeamTraining);
				
				rdbtnPersonalTraining = new JRadioButton("Personal Training");
				rdbtnPersonalTraining.setFont(new Font("Arial", Font.PLAIN, 15));
				rdbtnPersonalTraining.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnPersonalTraining.isSelected()){
							comboBoxTraining.removeAllItems();
							comboBoxTraining.validate();
							comboBoxTraining.addItem("Choose..");
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

				rdbtnPersonalTraining.setBounds(6, 120, 189, 23);
				add(rdbtnPersonalTraining); 
				
				
		 }
		
		 public void initComboBox(){
		
				comboBoxTraining = new JComboBox();
				comboBoxTraining.setBackground(Color.WHITE);
				comboBoxTraining.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxTraining.setBounds(201,150, 117, 25);
				comboBoxTraining.setEnabled(false);
				add(comboBoxTraining);
				comboBoxTraining.setEnabled(false);
				
			    comboBoxTeams = new JComboBox();
			    comboBoxTeams.setBackground(Color.WHITE);
			    comboBoxTeams.setFont(new Font("Arial", Font.PLAIN, 15));
			   	comboBoxTeams.setBounds(201, 93, 117, 25);
				add(comboBoxTeams);
				comboBoxTeams.setEnabled(false);
				
				comboBoxAthlete = new JComboBox();
				comboBoxAthlete.setBackground(Color.WHITE);
				comboBoxAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxAthlete.setBounds(201,119, 117, 25);
				comboBoxAthlete.setEnabled(false);
				add(comboBoxAthlete);
				comboBoxAthlete.setEnabled(false);
				
				
		 }
		 
		 
		
		public void init(){
			
			initComboBox();
			initArrays();
			initJRadioButton();
			initBtn();
			initLabel();
		    initTextPane();
			comboBoxTraining.addItem("Choose..");
			
			JLabel lblViewPlannedTraining = new JLabel("View Planned Training:");
			lblViewPlannedTraining.setFont(new Font("Arial", Font.PLAIN, 20));
			lblViewPlannedTraining.setBounds(10, 51, 209, 30);
			add(lblViewPlannedTraining);
			
			JLabel lblPlannedTrainingDetail = new JLabel("Planned Training Detail:");
			lblPlannedTrainingDetail.setFont(new Font("Arial", Font.PLAIN, 20));
			lblPlannedTrainingDetail.setBounds(10, 186, 209, 30);
			add(lblPlannedTrainingDetail);
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
			    				 if(i==0) 
			    						comboBoxTraining.addItem("Choose..");
			    				 else{
			    					 comboBoxTraining.addItem(allPersonalTrainingArray.get(i-1));
			    				 }
			    					}
			    			 comboBoxTraining.setEnabled(true);
			    		}
			    		
						
					
					}
				});
			  comboBoxTeams.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		if(!comboBoxTeams.getSelectedItem().toString().equals("Choose..")){			
							allTeamTrainingArray = new ArrayList<plannedteamtraining>();
							team1 = (Team)comboBoxTeams.getSelectedItem();
						  	getClient().sendMsgToServer(new MessageGetAllTeamTrainingByTeamId(team1.getTeamId()));
						  	MessageGetAllTeamTrainingByTeamIdReplay rep5= (MessageGetAllTeamTrainingByTeamIdReplay)getClient().getMessageFromServer();
							allTeamTrainingArray = rep5.getArray();
							comboBoxTraining.removeAllItems();
							
						
							
						}
			    			 for (int i=0; i<=allTeamTrainingArray.size(); i++)
			    				{
			    					if(i==0) 
			    						comboBoxTraining.addItem("Choose..");
			    					else{			    					
			    				 comboBoxTraining.addItem(allTeamTrainingArray.get(i-1));
			    				}
			    			 comboBoxTraining.setEnabled(true);
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
		return new ViewPlannedTrainingPanel(getClient());
	}
}



