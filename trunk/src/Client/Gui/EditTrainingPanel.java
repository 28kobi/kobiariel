package Client.Gui;
import java.awt.Component;
import java.awt.Rectangle;
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
import Server.Message.MessageUpdateAthleteTraining;
import Server.Message.MessageUpdateAthleteTrainingReplay;
import Server.Message.MessageUpdateTeamTraining;
import Server.Message.MessageUpdateTeamTrainingReplay;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;


public class EditTrainingPanel extends MyJPanel {
	
	
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
	private JLabel lblChooseTraining_1;
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
	private JLabel lblHereYouCan;
	private JButton btnUpdateTraining;
	
	
	public EditTrainingPanel(ClientIF client) {
		super(PanelType.EDIT_TRAINING_PANEL, client);
		setLayout(null);
	
	
			JLabel lblPerformedTraining = new JLabel();
			lblPerformedTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblPerformedTraining.setBounds(477, 11, 12, 43);
			add(lblPerformedTraining);
			
	
	
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
		

		lblChooseTraining = new JLabel("Choose Training:");
		lblChooseTraining.setFont(new Font("Arial", Font.PLAIN, 15));
		lblChooseTraining.setBounds(10, 85, 105, 25);

		lblChooseTraining_1 = new JLabel("Choose Taining:");
		lblChooseTraining_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblChooseTraining_1.setBounds(10, 85, 105, 25);

		add(lblChooseTraining_1);
		
		lblDetails = new JLabel("Details: ");
		lblDetails.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDetails.setBounds(6, 390, 109, 25);
		add(lblDetails);
				
		lblDuration = new JLabel("Duration: ");
		lblDuration.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDuration.setBounds(6, 420, 82, 25);
		add(lblDuration);
				
		lblDistance = new JLabel("Distance:");
		lblDistance.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDistance.setBounds(6, 450, 82, 25);
		add(lblDistance);
		
		lblTrainingDate = new JLabel("Training Date:");
		lblTrainingDate.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTrainingDate.setBounds(6, 270, 105, 25);
		add(lblTrainingDate);
		
		lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDay.setBounds(110, 270, 46, 25);
		add(lblDay);
		
		lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Arial", Font.PLAIN, 15));

		lblMonth.setBounds(256, 183, 46, 25);

		lblMonth.setBounds(222, 270, 46, 14);

		add(lblMonth);
		
		lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Arial", Font.PLAIN, 15));
		lblYear.setBounds(392, 183, 46, 25);
		lblYear.setBounds(350, 270, 46, 14);

		add(lblYear);
		
		lblHour = new JLabel("Hour:");
		lblHour.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHour.setBounds(93, 300, 53, 25);
		add(lblHour);
		
		lblMi = new JLabel("Min:");
		lblMi.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMi.setBounds(258, 213, 46, 25);
		lblMi.setBounds(258, 300, 46, 14);
		add(lblMi);
		
		lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTime.setBounds(6, 300, 68, 25);
		add(lblTime);
		
		lblTrainingType = new JLabel("Training Type :");
		lblTrainingType.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTrainingType.setBounds(6, 360, 105, 25);
		add(lblTrainingType);
		
		lblActivityType = new JLabel("Activity Type:");
		lblActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
		lblActivityType.setBounds(6, 328, 105, 25);
		add(lblActivityType);
		
		lblActivityName = new JLabel("Activity Name:");
		lblActivityName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblActivityName.setBackground(Color.WHITE);
		lblActivityName.setBounds(6, 125, 109, 25);
		add(lblActivityName);
		
		
		
		lblTraining = new JLabel("Training Name:");
		lblTraining.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTraining.setBounds(208, 120, 126, 25);
		add(lblTraining);
		
		
		
		lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDate.setBounds(413, 122, 78, 25);
		add(lblDate);
		
		
		
		lblTime_1 = new JLabel("Time:");
		lblTime_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTime_1.setBounds(15, 165, 37, 25);
		add(lblTime_1);
		
		
		
		lblDetails_1 = new JLabel("Details:");
		lblDetails_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDetails_1.setBounds(165, 165, 70, 25);
		add(lblDetails_1);
		
		lblDuration_1 = new JLabel("Duration:");
		lblDuration_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDuration_1.setBounds(331, 165, 99, 25);
		add(lblDuration_1);
		
		
		lblDistance_1 = new JLabel("Distance:");
		lblDistance_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDistance_1.setBounds(559, 165, 71, 20);
		add(lblDistance_1);
		
		lblHereYouCan = new JLabel(" New Training Details:");
		lblHereYouCan.setBackground(Color.LIGHT_GRAY);
		lblHereYouCan.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHereYouCan.setBounds(6, 229, 249, 30);
		add(lblHereYouCan);
		
		
	}
public void initTextPane(){
	textPaneDuration = new JTextPane();
	textPaneDuration.setBounds(423, 165, 87, 25);
	textPaneDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneDuration.setBackground(Color.lightGray);
	add(textPaneDuration);
	
	textPaneDistance = new JTextPane();
	textPaneDistance.setBounds(640, 165, 71, 25);
	textPaneDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneDistance.setBackground(Color.lightGray);
	add(textPaneDistance);
	
	textPaneDate = new JTextPane();
	textPaneDate.setBounds(449, 122, 97, 25);
	textPaneDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneDate.setBackground(Color.lightGray);
	add(textPaneDate);
	
	textPaneDetails = new JTextPane();
	textPaneDetails.setBounds(245, 161, 63, 25);
	textPaneDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneDetails.setBackground(Color.lightGray);
	add(textPaneDetails);
	
	textPaneTime = new JTextPane();
	textPaneTime.setBounds(62, 162, 71, 25);
	textPaneTime.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneTime.setBackground(Color.lightGray);
	add(textPaneTime);
	
	textPaneActivity = new JTextPane();
	textPaneActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneActivity.setBounds(123, 120, 88, 25);
	textPaneActivity.setBackground(Color.lightGray);
	add(textPaneActivity);
	
	textPaneTraining = new JTextPane();
	textPaneTraining.setBounds(321, 122, 89, 25);
	textPaneTraining.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPaneTraining.setBackground(Color.lightGray);
	add(textPaneTraining);
	
	
	
	
}
	
public void initTextField(){
		
		textFieldDistance = new JTextField();
		textFieldDistance.setBounds(150, 450, 184, 24);
		textFieldDistance.setBounds(150, 450, 153, 24);
		add(textFieldDistance);
		
		
		textFieldDuration = new JTextField();
		textFieldDuration.setBounds(150, 420, 163, 23);
		textFieldDuration.setBounds(150, 420, 184, 23);
		add(textFieldDuration);
		
		
		textFieldDetails = new JTextField();
		textFieldDetails.setBounds(150, 390, 184, 25);
		add(textFieldDetails);
		
	}
	public void initBtn(){
		
		btnW = new JButton("View Training Details");
		btnW.setForeground(Color.BLUE);
		btnW.setFont(new Font("Arial", Font.PLAIN, 15));
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
		
		
		btnW.setBounds(311, 81, 178, 30);
		add(btnW);
		
		
		btnUpdateTraining = new JButton("Update training");
		btnUpdateTraining.setForeground(Color.BLUE);
		btnUpdateTraining.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUpdateTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg;
				if(rdbtnTeamTraining.isSelected()){
					updatedTraining=new plannedteamtraining();
					
					//check if activity type change
					 comboBoxTrainingType.removeAll();
					 comboBoxTrainingType.validate();
					 comboBoxTrainingType.addItem("Choose..");
						
					if(!(comboBoxActivityType.getSelectedItem().toString().equals("Choose.."))){
						activitytype activy=(activitytype)comboBoxActivityType.getSelectedItem();
						if(teamTraining.getActivityid()==activy.getActivityId())
							updatedTraining.setActivityid(teamTraining.getActivityid());
						else
							updatedTraining.setActivityid(activy.getActivityId());
						}
					else {
						updatedTraining.setActivityid(teamTraining.getActivityid());
						}
					
					//check if training type change
					if(!(comboBoxTrainingType.getSelectedItem().toString().equals("Choose.."))){
						trainingtype trainingt=(trainingtype)comboBoxTrainingType.getSelectedItem();
						if(teamTraining.getActivityid()==trainingt.getTrainingId())
							updatedTraining.setTrainingTypeId(teamTraining.getTrainingTypeId());
						else
							updatedTraining.setTrainingTypeId(trainingt.getTrainingId());
						}
					else {
						updatedTraining.setTrainingTypeId(teamTraining.getTrainingTypeId());
						}
					
					if(comboBoxDay.isEnabled()&&!comboBoxDay.getSelectedItem().toString().equals("Choose..")&&!comboBoxMonth.getSelectedItem().toString().equals("Choose..")&&!comboBoxYear.getSelectedItem().toString().equals("Choose..")){
						msg=""+comboBoxDay.getSelectedItem().toString()+"/"+""+comboBoxMonth.getSelectedItem().toString()+""+"/"+comboBoxYear.getSelectedItem().toString()+"";
						updatedTraining.setDate(msg);
					}
					else
						updatedTraining.setDate(teamTraining.getDate());
						
				
					
					if(!comboBoxHour.getSelectedItem().toString().equals("Choose..")&&!comboBoxMin.getSelectedItem().toString().equals("Choose..")){
						msg=""+comboBoxHour.getSelectedItem().toString()+""+":"+comboBoxMin.getSelectedItem().toString()+"";
						updatedTraining.setTime(msg);
					}
					else
							updatedTraining.setTime(teamTraining.getTime());
					
					
					if(textFieldDetails.getText().equals(""))
						updatedTraining.setDetails(teamTraining.getDetails());
					else
						updatedTraining.setDetails(textFieldDetails.getText());
					
					if(textFieldDuration.getText().equals(""))
						updatedTraining.setDuration(teamTraining.getDuration());
					else
						updatedTraining.setDuration(textFieldDuration.getText());
					
					if(textFieldDistance.getText().equals(""))
						updatedTraining.setDistance(teamTraining.getDistance());
					else
						updatedTraining.setDistance(textFieldDistance.getText());
					updatedTraining.setTeamId(teamTraining.getTeamId());
					updatedTraining.setTrainingId(teamTraining.getTrainingId());
					
					getClient().sendMsgToServer(new MessageUpdateTeamTraining(updatedTraining));
					MessageUpdateTeamTrainingReplay rep7= (MessageUpdateTeamTrainingReplay) getClient().getMessageFromServer();
					if(rep7.getint()==1){
						msg="training has been upDated..";
						popUp(msg);	
						getClient().swapFromBack(pushPanel());
					}
					else {
						msg="problem while up dating.. try again..";
						popUp(msg);
						
					}
					
				}
				if(rdbtnPersonalTraining.isSelected()){
			
					updatedTraining1=new plannedpersonaltraining();
							
					//check if activity type change
					 comboBoxTrainingType.addItem("Choose..");
						
					if(!(comboBoxActivityType.getSelectedItem().toString().equals("Choose.."))){
						activitytype activy=(activitytype)comboBoxActivityType.getSelectedItem();
						if(AthletTraining.getActivityid()==activy.getActivityId())
							updatedTraining1.setActivityid(AthletTraining.getActivityid());
						else
							updatedTraining1.setActivityid(activy.getActivityId());
						}
					else {
						updatedTraining1.setActivityid(AthletTraining.getActivityid());
						}
					
					//check if training type change
					if(!(comboBoxTrainingType.getSelectedItem().toString().equals("Choose.."))){
						trainingtype trainingt=(trainingtype)comboBoxTrainingType.getSelectedItem();
						if(AthletTraining.getActivityid()==trainingt.getTrainingId())
							updatedTraining1.setTrainingTypeId(AthletTraining.getTrainingTypeId());
						else
							updatedTraining1.setTrainingTypeId(trainingt.getTrainingId());
						}
					else {
						updatedTraining1.setTrainingTypeId(AthletTraining.getTrainingTypeId());
						}
					
					if(comboBoxDay.isEnabled()&&!comboBoxDay.getSelectedItem().toString().equals("Choose..")&&!comboBoxMonth.getSelectedItem().toString().equals("Choose..")&&!comboBoxYear.getSelectedItem().toString().equals("Choose..")){
						msg=""+comboBoxDay.getSelectedItem().toString()+""+"/"+comboBoxMonth.getSelectedItem().toString()+""+"/"+comboBoxYear.getSelectedItem().toString()+"";
						updatedTraining1.setDate(msg);
					}
					else
						updatedTraining1.setDate(AthletTraining.getDate());
						
				
					
					if(!comboBoxHour.getSelectedItem().toString().equals("Choose..")&&!comboBoxMin.getSelectedItem().toString().equals("Choose..")){
						msg=""+comboBoxHour.getSelectedItem().toString()+""+":"+comboBoxMin.getSelectedItem().toString()+"";
						updatedTraining1.setTime(msg);
					}
					else
							updatedTraining1.setTime(AthletTraining.getTime());
					
					
					if(textFieldDetails.getText().equals(""))
						updatedTraining1.setDetails(AthletTraining.getDetails());
					else
						updatedTraining1.setDetails(textFieldDetails.getText());
					
					if(textFieldDuration.getText().equals(""))
						updatedTraining1.setDuration(AthletTraining.getDuration());
					else
						updatedTraining1.setDuration(textFieldDuration.getText());
					
					if(textFieldDistance.getText().equals(""))
						updatedTraining1.setDistance(AthletTraining.getDistance());
					else
						updatedTraining1.setDistance(textFieldDistance.getText());
					updatedTraining1.setathleteId(AthletTraining.getathleteId());
					updatedTraining1.setTrainingId(AthletTraining.getTrainingId());
					
					getClient().sendMsgToServer(new MessageUpdateAthleteTraining(updatedTraining1));
					MessageUpdateAthleteTrainingReplay replay= (MessageUpdateAthleteTrainingReplay) getClient().getMessageFromServer();
					if(replay.getint()==1){
						msg="training has been upDated..";
						popUp(msg);	
						getClient().swapFromBack(pushPanel());
					}
					else {
						msg="problem while up dating.. try again..";
						popUp(msg);
						
					}
					
				}
			}
		});
		btnUpdateTraining.setBounds(199, 485, 197, 30);
		add(btnUpdateTraining);
	}
	 public void initJRadioButton(){
			
		    rdbtnTeamTraining = new JRadioButton("TeamTraining");
		    rdbtnTeamTraining.setFont(new Font("Arial", Font.PLAIN, 15));
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
			rdbtnTeamTraining.setBounds(6, 29, 138, 25);
			add(rdbtnTeamTraining);
			
			rdbtnPersonalTraining = new JRadioButton("Personal Training");
			rdbtnPersonalTraining.setFont(new Font("Arial", Font.PLAIN, 15));
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

			rdbtnPersonalTraining.setBounds(6, 53, 138, 25);
			add(rdbtnPersonalTraining); 
			
			
	 }
	
	 public void initComboBox(){
		 
		 	comboBoxDay = new JComboBox();
		 	comboBoxDay.setFont(new Font("Arial", Font.PLAIN, 15));
		 	comboBoxDay.setBackground(Color.WHITE);

			comboBoxDay.setBounds(151, 270, 104, 20);

			comboBoxDay.setBounds(151, 270, 60, 20);

			comboBoxDay.setEnabled(false);
			add(comboBoxDay);
			
			comboBoxMonth = new JComboBox();
			comboBoxMonth.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxMonth.setBackground(Color.WHITE);

			comboBoxMonth.setBounds(310, 236, 61, 25);			

			comboBoxMonth.setBounds(274, 270, 61, 20);			

			 for (int i=0; i<=month.length; i++)
				{
					if (i==0) comboBoxMonth.addItem("Choose..");
					else comboBoxMonth.addItem(month[i-1]);
					}
			add(comboBoxMonth);
			
			comboBoxYear = new JComboBox();
			comboBoxYear.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxYear.setBackground(Color.WHITE);

			comboBoxYear.setBounds(407, 490, 98, 20);

			comboBoxYear.setBounds(391, 270, 71, 20);

			 for (int j=0; j<=year.length; j++)
				{
					if (j==0) comboBoxYear.addItem("Choose..");
					else comboBoxYear.addItem(year[j-1]);
					}
			add(comboBoxYear);
			
			comboBoxHour = new JComboBox();
			comboBoxHour.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxHour.setBackground(Color.WHITE);

			comboBoxHour.setBounds(151, 300, 104, 20);

			comboBoxHour.setBounds(151, 300, 71, 20);

			for(int hour=0;hour<25;hour++){
				if(hour==0) comboBoxHour.addItem("Choose..");
				else comboBoxHour.addItem(Integer.toString(hour));
				
			}
			add(comboBoxHour);
						
			comboBoxMin = new JComboBox();
			comboBoxMin.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxMin.setBackground(Color.WHITE);

			comboBoxMin.setBounds(296, 330, 71, 25);

			comboBoxMin.setBounds(300, 300, 71, 20);

			for(int min=0;min<75;min=min+15){
				if(min==0) comboBoxMin.addItem("Choose..");
				else comboBoxMin.addItem(Integer.toString(min));
				
			}
			add(comboBoxMin);
			
			comboBoxActivityType = new JComboBox();		
			comboBoxActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxActivityType.setBackground(Color.WHITE);

			comboBoxActivityType.setBounds(150, 330, 71, 20);

			
			comboBoxActivityType.setBounds(150, 330, 105, 20);

			add(comboBoxActivityType);
						
			comboBoxTrainingType = new JComboBox();
			comboBoxTrainingType.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxTrainingType.setBackground(Color.WHITE);
			comboBoxTrainingType.setBounds(146, 360, 109, 25);
			add(comboBoxTrainingType);
			comboBoxTrainingType.setEnabled(false);

			comboBoxTraining = new JComboBox();
			comboBoxTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxTraining.setBackground(Color.WHITE);
			comboBoxTraining.setBounds(175,84, 117, 25);
			comboBoxTraining.setEnabled(false);
			add(comboBoxTraining);
			comboBoxTraining.setEnabled(false);
			
		    comboBoxTeams = new JComboBox();
		    comboBoxTeams.setFont(new Font("Arial", Font.PLAIN, 15));
		    comboBoxTeams.setBackground(Color.WHITE);
		    
			comboBoxTeams.setBounds(175, 29, 117, 25);
			add(comboBoxTeams);
			comboBoxTeams.setEnabled(false);
			
			comboBoxAthlete = new JComboBox();
			comboBoxAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxAthlete.setBackground(Color.WHITE);
			comboBoxAthlete.setBounds(175,48, 117, 25);
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
	    initTextPane();
	    comboBoxTrainingType.addItem("Choose..");
	    comboBoxDay.addItem("Choose..");
	    comboBoxTraining.addItem("Choose..");
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
		  
		  for (int i=0; i<=allAactivityTypeArray.size(); i++)
			{
				if (i==0) comboBoxActivityType.addItem("Choose..");
				else comboBoxActivityType.addItem(allAactivityTypeArray.get(i-1));
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
					comboBoxTrainingType.validate();
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
					comboBoxDay.removeAllItems();
					comboBoxDay.validate();
					 switch (month) {
					 		case 1:case 3:case 5:case 7:case 8: case 10: 
					 				
					 				for(int i=0;i<32;i++){
			            			if (i==0) comboBoxDay.addItem("Choose..");
			            			else comboBoxDay.addItem(i);
					 				}
					 				comboBoxDay.setEnabled(true);
					 				break;
					 		case 2:
					 				
					 				for(int i=0;i<29;i++){
					 				if (i==0) comboBoxDay.addItem("Choose..");
					 				else comboBoxDay.addItem(i);
					 				}
					 				comboBoxDay.setEnabled(true);
			                  	  break;
					 		case 4:case 6:case 9:case 11:
					 				
					 				for(int i=0;i<31;i++){
			            			if (i==0) comboBoxDay.addItem("Choose..");
			            			else comboBoxDay.addItem(i);
	           	            		}
					 				comboBoxDay.setEnabled(true);
					 				break;
					 }
					 
				}	 
			      
			});
		  comboBoxAthlete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){			
						allPersonalTrainingArray = new ArrayList<plannedpersonaltraining>();
			
						Athlete = (User) comboBoxAthlete.getSelectedItem();
						
					  	getClient().sendMsgToServer(new MessageGetAllPersonalTrainingByAtleteId(Athlete.getIdUser()));
					  	MessageGetAllPersonalTrainingByAtleteIdReplay rep6= (MessageGetAllPersonalTrainingByAtleteIdReplay)getClient().getMessageFromServer();
					  	allPersonalTrainingArray = rep6.getPersonalTrainingArray();
					  	comboBoxTraining.removeAllItems();
					  	comboBoxTraining.validate();
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
		return new EditTrainingPanel(getClient());
	}
}



