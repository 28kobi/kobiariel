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
		
		
			
		
			JLabel lblPlannedTraining = new JLabel();
			lblPlannedTraining.setBounds(149, 11, 340, 46);
			add(lblPlannedTraining);
			
		
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
			

			lblChooseTraining = new JLabel("choose training by dates:");
			lblChooseTraining.setBounds(6, 85, 153, 14);
			add(lblChooseTraining);
			
			lblActivityName = new JLabel("activity name:");
			lblActivityName.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblActivityName.setBackground(Color.WHITE);
			lblActivityName.setBounds(6, 222, 109, 24);
			add(lblActivityName);
			
			
			
			lblTraining = new JLabel("training name:");
			lblTraining.setBounds(190, 222, 90, 20);
			add(lblTraining);
			
			
			
			lblDate = new JLabel("date:");
			lblDate.setBounds(383, 222, 78, 24);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("time:");
			lblTime_1.setBounds(6, 263, 37, 25);
			add(lblTime_1);
			
			
			
			lblDetails_1 = new JLabel("details:");
			lblDetails_1.setBounds(150, 263, 46, 14);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("duration:");
			lblDuration_1.setBounds(314, 263, 53, 23);
			add(lblDuration_1);
			
			
			lblDistance_1 = new JLabel("distance:");
			lblDistance_1.setBounds(522, 222, 71, 20);
			add(lblDistance_1);
			
			
		}
	public void initTextPane(){
		textPaneDuration = new JTextPane();
		textPaneDuration.setBounds(391, 261, 87, 20);
		textPaneDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDuration.setBackground(Color.lightGray);
		add(textPaneDuration);
		
		textPaneDistance = new JTextPane();
		textPaneDistance.setBounds(590, 219, 71, 20);
		textPaneDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDistance.setBackground(Color.lightGray);
		add(textPaneDistance);
		
		textPaneDate = new JTextPane();
		textPaneDate.setBounds(420, 219, 97, 20);
		textPaneDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDate.setBackground(Color.lightGray);
		add(textPaneDate);
		
		textPaneDetails = new JTextPane();
		textPaneDetails.setBounds(196, 261, 63, 20);
		textPaneDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneDetails.setBackground(Color.lightGray);
		add(textPaneDetails);
		
		textPaneTime = new JTextPane();
		textPaneTime.setBounds(53, 261, 53, 24);
		textPaneTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTime.setBackground(Color.lightGray);
		add(textPaneTime);
		
		textPaneActivity = new JTextPane();
		textPaneActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneActivity.setBounds(93, 219, 88, 26);
		textPaneActivity.setBackground(Color.lightGray);
		add(textPaneActivity);
		
		textPaneTraining = new JTextPane();
		textPaneTraining.setBounds(274, 219, 89, 20);
		textPaneTraining.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTraining.setBackground(Color.lightGray);
		add(textPaneTraining);
		
		
		
		
	}
		
	
		public void initBtn(){
			
			btnW = new JButton("observe details");
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
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
						}	
						if(rdbtnTeamTraining.isSelected()){
							if(!comboBoxTraining.getSelectedItem().toString().equals("Choose..")){
								
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
							}	
						
					}
				});
			
			
			btnW.setBounds(383, 81, 153, 23);
			add(btnW);
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
				rdbtnTeamTraining.setBounds(6, 7, 138, 23);
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

				rdbtnPersonalTraining.setBounds(6, 34, 138, 23);
				add(rdbtnPersonalTraining); 
				
				
		 }
		
		 public void initComboBox(){
		
				comboBoxTraining = new JComboBox();
				comboBoxTraining.setBounds(246,82, 117, 20);
				comboBoxTraining.setEnabled(false);
				add(comboBoxTraining);
				comboBoxTraining.setEnabled(false);
				
			    comboBoxTeams = new JComboBox();
			   	comboBoxTeams.setBounds(175, 7, 117, 20);
				add(comboBoxTeams);
				comboBoxTeams.setEnabled(false);
				
				comboBoxAthlete = new JComboBox();
				comboBoxAthlete.setBounds(175,38, 117, 20);
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
			    					if (i==0) comboBoxTraining.addItem("Choose..");
			    					else comboBoxTraining.addItem(allPersonalTrainingArray.get(i-1));
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
			    			
			    			 for (int i=0; i<=allTeamTrainingArray.size(); i++)
			    				{
			    					if (i==0) comboBoxTraining.addItem("Choose..");
			    					else comboBoxTraining.addItem(allTeamTrainingArray.get(i-1));
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



