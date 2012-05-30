package Client.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Client.Logic.ClientIF;
import Server.DataBase.PreformedPersonalTraining;
import Server.DataBase.PreformedTeamTraining;
import Server.DataBase.activitytype;
import Server.DataBase.athlete;
import Server.DataBase.athleteQuery;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.trainingtype;
import Server.Message.MessageCreateNewPreformedTeamPlannedTraining;
import Server.Message.MessageCreateNewPreformedTeamPlannedTrainingReplay;
import Server.Message.MessageCreateNewUnPlannedTraining;
import Server.Message.MessageCreateNewUnPlannedTrainingReplay;
import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageGetAllPersonalTrainingByAtleteId;
import Server.Message.MessageGetAllPersonalTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllTeamTrainingByTeamId;
import Server.Message.MessageGetAllTeamTrainingByTeamIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;
import Server.Message.MessageGetAthleteByUserId;
import Server.Message.MessageGetAthleteByUserIdReplay;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;


public class AthleteReportTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	private JRadioButton rdbtnReportUnPlannedTraining;
	private JRadioButton rdbtnReportPlannedTraining;
	private JButton btnReportTrainingDetail;

	private PreformedPersonalTraining PreformedPersonalTraining;
	private PreformedTeamTraining PreformedTeamTraining;
	private String msg;
	private athlete Athlete;
	private activitytype activityType;
	private trainingtype trainingType;
	private plannedteamtraining teamTraining;
	private plannedpersonaltraining AthletTraining;
	
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	private ArrayList<plannedpersonaltraining> allPersonalTrainingArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private JComboBox comboBoxTeam ;
	private JComboBox comboBoxPersonal;
	
	
	private JComboBox comboBoxMin;
	private JComboBox comboBoxActivityType ;
	private JComboBox comboBoxTrainingType;
	private JComboBox comboBoxHour;
	private JComboBox comboBoxDay;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	
	
	private JLabel lblTeamTraining;
	private JLabel lblPersonalTraining;
	private JLabel lblChooseTraining;
	
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
	private JLabel lblDate;
	private JLabel lblTime_1;
	private JLabel lblDetails_1;
	private JLabel lblDuration_1;
	private JLabel lblDistance_1;
	private JLabel lblActivityName;
	private JLabel lblTraining;
	private JLabel lblHereYouCan;
	private JTextPane textPaneDuration;
	private JTextPane textPaneDistance;
	private JTextPane textPaneDate;
	private JTextPane textPaneDetails;
	private JTextPane textPaneTime;
	private JTextPane textPaneActivity;
	private JTextPane textPaneTraining;
	private JTextField textFieldDetails;
	private JTextField textFieldDuration;
	private JTextField textFieldDistance ;
	private String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] year={"2012","2013","2014","2015","2016"};
	private JTable table;
	

	
   
    
	
	
	public AthleteReportTrainingPanel(ClientIF client) {
		super(PanelType.ATHLETE_REPORT_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPlannedTrainging = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPlannedTrainging.setBounds(315, 0, 340, 46);
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
		
	
		 public void 	initJRadioButton(){
			 
			 rdbtnReportUnPlannedTraining = new JRadioButton("Report Un Planned Training");
			 rdbtnReportUnPlannedTraining.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
					if(rdbtnReportUnPlannedTraining.isSelected()){
						
						comboBoxTeam.setEnabled(false);
						comboBoxPersonal.setEnabled(false);						
						rdbtnReportPlannedTraining.setEnabled(false);
						textPaneDuration.setEnabled(false);
						textPaneDistance.setEnabled(false);
						textPaneDate.setEnabled(false);												
						textPaneDetails.setEnabled(false);											
						textPaneTime.setEnabled(false);										
						textPaneActivity.setEnabled(false);						
						textPaneTraining.setEnabled(false);
						
				///	if(rdbtnReportPlannedTraining.isSelected())
					
				////		rdbtnReportPlannedTraining.doClick();
						
					}
					else{
			 	
						comboBoxTeam.setEnabled(true);
						comboBoxPersonal.setEnabled(true);
						rdbtnReportPlannedTraining.setEnabled(true);
						textPaneDuration.setEnabled(true);
						textPaneDistance.setEnabled(true);
						textPaneDate.setEnabled(true);												
						textPaneDetails.setEnabled(true);											
						textPaneTime.setEnabled(true);										
						textPaneActivity.setEnabled(true);						
						textPaneTraining.setEnabled(true);
						
						
						
						
					}
			 		
			 	}
			 });
			 rdbtnReportUnPlannedTraining.setBounds(6, 23, 173, 23);
				add(rdbtnReportUnPlannedTraining);
				
				
				
				
				rdbtnReportPlannedTraining = new JRadioButton("Report Planned Training");
				rdbtnReportPlannedTraining.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnReportPlannedTraining.isSelected()){
							
							rdbtnReportUnPlannedTraining.setEnabled(false);

							comboBoxTeam.setEnabled(true);
							comboBoxPersonal.setEnabled(true);						
							textPaneDuration.setEnabled(true);
							textPaneDistance.setEnabled(true);
							textPaneDate.setEnabled(true);												
							textPaneDetails.setEnabled(true);											
							textPaneTime.setEnabled(true);										
							textPaneActivity.setEnabled(true);						
							textPaneTraining.setEnabled(true);
						
							}
						else{
							rdbtnReportUnPlannedTraining.setEnabled(true);
							comboBoxTeam.setEnabled(false);
							comboBoxPersonal.setEnabled(false);						
							textPaneDuration.setEnabled(false);
							textPaneDistance.setEnabled(false);
							textPaneDate.setEnabled(false);												
							textPaneDetails.setEnabled(false);											
							textPaneTime.setEnabled(false);										
							textPaneActivity.setEnabled(false);						
							textPaneTraining.setEnabled(false);
							
						}
					}
				});
				rdbtnReportPlannedTraining.setBounds(6, 49, 173, 23);
				add(rdbtnReportPlannedTraining);
		 }
		 
		 public void initArrays(){
				
		       
				allAactivityTypeArray = new ArrayList<activitytype>();
				getClient().sendMsgToServer(new MessageGetAllAactivityType());
				MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
				allAactivityTypeArray = rep3.getArray();
			
				
				
				allTeamTrainingArray = new ArrayList<plannedteamtraining>();
				getClient().sendMsgToServer(new MessageGetAllTeamTrainingByTeamId(Athlete.getTeamId()));
				MessageGetAllTeamTrainingByTeamIdReplay rep5= (MessageGetAllTeamTrainingByTeamIdReplay)getClient().getMessageFromServer();
				allTeamTrainingArray = rep5.getArray();
				
				allPersonalTrainingArray= new ArrayList<plannedpersonaltraining>();
				getClient().sendMsgToServer(new MessageGetAllPersonalTrainingByAtleteId(Athlete.getUserid()));
			  	MessageGetAllPersonalTrainingByAtleteIdReplay rep6= (MessageGetAllPersonalTrainingByAtleteIdReplay)getClient().getMessageFromServer();
			  	allPersonalTrainingArray = rep6.getPersonalTrainingArray();
			
			}
		
		 public void initComboBox(){
			  	comboBoxTeam = new JComboBox();
			  	comboBoxTeam.addActionListener(new ActionListener() {
			  		public void actionPerformed(ActionEvent e) {
			  			comboBoxTeam.setEnabled(true);
			  			if(!comboBoxTeam.getSelectedItem().toString().equals("Choose..")){
			  				comboBoxPersonal.setEnabled(false);
			  			
							teamTraining=(plannedteamtraining)comboBoxTeam.getSelectedItem();
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
			  	});
			  	comboBoxTeam.setBounds(98, 113, 126, 20);
			   add(comboBoxTeam);
				
				comboBoxPersonal = new JComboBox();
				comboBoxPersonal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBoxPersonal.setEnabled(true);
						
						if(!comboBoxPersonal.getSelectedItem().toString().equals("Choose..")){
							comboBoxTeam.setEnabled(false);
							AthletTraining=(plannedpersonaltraining)comboBoxPersonal.getSelectedItem();
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
				});
				comboBoxPersonal.setBounds(357, 113, 126, 20);
				add(comboBoxPersonal);
			
				comboBoxDay = new JComboBox();
				comboBoxDay.setMaximumRowCount(32);
				comboBoxDay.setBounds(151, 258, 97, 20);
				comboBoxDay.setEnabled(false);
				add(comboBoxDay);
				
				comboBoxMonth = new JComboBox();
				comboBoxMonth.setMaximumRowCount(13);
				comboBoxMonth.setBounds(301, 258, 82, 20);			
				 for (int i=0; i<=month.length; i++)
					{
						if (i==0) comboBoxMonth.addItem("Choose..");
						else comboBoxMonth.addItem(month[i-1]);
						}
				add(comboBoxMonth);
				
				comboBoxYear = new JComboBox();
				comboBoxYear.setBounds(435, 258, 87, 20);
				 for (int j=0; j<=year.length; j++)
					{
						if (j==0) comboBoxYear.addItem("Choose..");
						else comboBoxYear.addItem(year[j-1]);
						}
				add(comboBoxYear);
				
				comboBoxHour = new JComboBox();
				comboBoxHour.setMaximumRowCount(25);
				comboBoxHour.setBounds(151, 289, 97, 20);
				for(int hour=0;hour<25;hour++){
					if(hour==0) comboBoxHour.addItem("choose..");
					else comboBoxHour.addItem(Integer.toString(hour));
							
				}
				add(comboBoxHour);
							
				comboBoxMin = new JComboBox();
				comboBoxMin.setBounds(301, 289, 82, 20);
				for(int min=0;min<75;min=min+15){
					if(min==0) comboBoxMin.addItem("choose..");
					else comboBoxMin.addItem(Integer.toString(min));
					
				}
				add(comboBoxMin);
				
				comboBoxActivityType = new JComboBox();		
				comboBoxActivityType.setBounds(150, 320, 98, 20);
				add(comboBoxActivityType);
				comboBoxActivityType.setEnabled(true);
				
							
				comboBoxTrainingType = new JComboBox();
				comboBoxTrainingType.setBounds(150, 351, 98, 20);
				add(comboBoxTrainingType);
				comboBoxTrainingType.setEnabled(false);
		
			  
			
		};	
		
		public void initLabel(){
			

			 lblTeamTraining = new JLabel("Team Training :");
			lblTeamTraining.setBounds(6, 116, 82, 14);
			add(lblTeamTraining);
			
			 lblPersonalTraining = new JLabel("Personal Training :");
			lblPersonalTraining.setBounds(266, 116, 114, 14);
			add(lblPersonalTraining);
			

			lblChooseTraining = new JLabel("Choose Training:");
			lblChooseTraining.setFont(new Font("Dialog", Font.BOLD, 24));
			lblChooseTraining.setBounds(6, 79, 218, 23);
			add(lblChooseTraining);
			
			lblDetails = new JLabel("Details: ");
			lblDetails.setBounds(6, 387, 68, 14);
			add(lblDetails);
					
			lblDuration = new JLabel("Duration: ");
			lblDuration.setBounds(6, 412, 82, 14);
			add(lblDuration);
					
			lblDistance = new JLabel("Distance:");
			lblDistance.setBounds(6, 437, 82, 14);
			add(lblDistance);
			
			lblTrainingDate = new JLabel("Training Date:");
			lblTrainingDate.setBounds(6, 261, 87, 14);
			add(lblTrainingDate);
			
			lblDay = new JLabel("day:");
			lblDay.setBounds(101, 261, 46, 14);
			add(lblDay);
			
			lblMonth = new JLabel("month:");
			lblMonth.setBounds(266, 260, 35, 17);
			add(lblMonth);
			
			lblYear = new JLabel("year:");
			lblYear.setBounds(393, 261, 46, 14);
			add(lblYear);
			
			lblHour = new JLabel("hour:");
			lblHour.setBounds(101, 292, 53, 14);
			add(lblHour);
			
			lblMi = new JLabel("min:");
			lblMi.setBounds(268, 292, 33, 14);
			add(lblMi);
			
			lblTime = new JLabel("Time:");
			lblTime.setBounds(6, 292, 68, 14);
			add(lblTime);
			
			lblTrainingType = new JLabel("Training Type :");
			lblTrainingType.setBounds(6, 354, 105, 14);
			add(lblTrainingType);
			
			lblActivityType = new JLabel("Activity Type:");
			lblActivityType.setBounds(6, 323, 105, 14);
			add(lblActivityType);
			

			lblDate = new JLabel("date:");
			lblDate.setBounds(372, 160, 78, 24);
			add(lblDate);
			
			
			
			lblTime_1 = new JLabel("time:");
			lblTime_1.setBounds(10, 185, 37, 25);
			add(lblTime_1);
			
			
			
			lblDetails_1 = new JLabel("details:");
			lblDetails_1.setBounds(190, 190, 80, 14);
			add(lblDetails_1);
			
			lblDuration_1 = new JLabel("duration:");
			lblDuration_1.setBounds(372, 186, 53, 23);
			add(lblDuration_1);
			
			
			lblDistance_1 = new JLabel("distance:");
			lblDistance_1.setBounds(532, 162, 71, 20);
			add(lblDistance_1);
			
			
			lblActivityName = new JLabel("activity name:");
			lblActivityName.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblActivityName.setBackground(Color.WHITE);
			lblActivityName.setBounds(6, 160, 82, 24);
			add(lblActivityName);
			

			lblTraining = new JLabel("training name:");
			lblTraining.setBounds(190, 159, 90, 20);
			add(lblTraining);
			
			lblHereYouCan = new JLabel(" Training Report Form :");
			lblHereYouCan.setBackground(Color.LIGHT_GRAY);
			lblHereYouCan.setFont(new Font("Dialog", Font.BOLD, 24));
			lblHereYouCan.setBounds(0, 218, 428, 32);
			add(lblHereYouCan);	
			
		}
		public void initTextPane(){
			
			
			textPaneDuration = new JTextPane();
			textPaneDuration.setBounds(436, 190, 86, 20);
			textPaneDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneDuration.setBackground(Color.lightGray);
			add(textPaneDuration);
			
			textPaneDistance = new JTextPane();
			textPaneDistance.setBounds(584, 162, 71, 20);
			textPaneDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneDistance.setBackground(Color.lightGray);
			add(textPaneDistance);
			
			textPaneDate = new JTextPane();
			textPaneDate.setBounds(435, 164, 87, 20);
			textPaneDate.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneDate.setBackground(Color.lightGray);
			add(textPaneDate);
			
			textPaneDetails = new JTextPane();
			textPaneDetails.setBounds(266, 190, 79, 20);
			textPaneDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneDetails.setBackground(Color.lightGray);
			add(textPaneDetails);
			
			textPaneTime = new JTextPane();
			textPaneTime.setBounds(83, 190, 85, 20);
			textPaneTime.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneTime.setBackground(Color.lightGray);
			add(textPaneTime);
			
			textPaneActivity = new JTextPane();
			textPaneActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneActivity.setBounds(83, 159, 88, 20);
			textPaneActivity.setBackground(Color.lightGray);
			add(textPaneActivity);
			
			textPaneTraining = new JTextPane();
			textPaneTraining.setBounds(268, 161, 78, 20);
			textPaneTraining.setFont(new Font("Tahoma", Font.BOLD, 14));
			textPaneTraining.setBackground(Color.lightGray);
			add(textPaneTraining);
			
			JButton btnResetTrainingDetail = new JButton("Reset Training Detail");
			btnResetTrainingDetail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getClient().swapFromBack(pushPanel());
				}
			});
			btnResetTrainingDetail.setBounds(507, 112, 165, 23);
			add(btnResetTrainingDetail);
			
			
			
			
		}
		public void initTextField(){
			
			textFieldDistance = new JTextField();
			textFieldDistance.setBounds(150, 432, 311, 24);
			add(textFieldDistance);
			
			
			textFieldDuration = new JTextField();
			textFieldDuration.setBounds(150, 408, 311, 23);
			add(textFieldDuration);
			
			
			textFieldDetails = new JTextField();
			textFieldDetails.setBounds(150, 383, 311, 23);
			add(textFieldDetails);
			
		}

		
		private void initBtn() {
			btnReportTrainingDetail = new JButton("Report Training Detail");
			btnReportTrainingDetail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
								if(rdbtnReportUnPlannedTraining.isSelected()){
									if((!comboBoxDay.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMonth.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxYear.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxHour.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMin.getSelectedItem().toString().equals("Choose.."))){
										
										PreformedPersonalTraining = new PreformedPersonalTraining();
										PreformedPersonalTraining.setAthleteId(Athlete.getUserid());
										PreformedPersonalTraining.setIsplanned("false");
										PreformedPersonalTraining.setTrainingId(0);
										msg="'"+comboBoxDay.getSelectedItem().toString()+"'"+"'"+comboBoxMonth.getSelectedItem().toString()+"'"+"'"+comboBoxYear.getSelectedItem().toString()+"'";
										PreformedPersonalTraining.setDate(msg);
										msg="'"+comboBoxHour.getSelectedItem().toString()+"'"+"'"+comboBoxMin.getSelectedItem().toString()+"'";
										PreformedPersonalTraining.setTime(msg);
										activityType=(activitytype)comboBoxActivityType.getSelectedItem();
										PreformedPersonalTraining.setActivityid(activityType.getActivityId());
										trainingType=(trainingtype)comboBoxTrainingType.getSelectedItem();
										PreformedPersonalTraining.setTrainingTypeId(trainingType.getTrainingId());
										PreformedPersonalTraining.setDistance(textFieldDistance.getText());
										PreformedPersonalTraining.setDetails(textFieldDetails.getText());
										PreformedPersonalTraining.setDuration(textFieldDuration.getText());
										
										getClient().sendMsgToServer(new MessageCreateNewUnPlannedTraining(PreformedPersonalTraining));
										MessageCreateNewUnPlannedTrainingReplay rep= (MessageCreateNewUnPlannedTrainingReplay)getClient().getMessageFromServer();
										if(rep.getint()==1){
											msg="Training Report Success";
											popUp(msg);	
											getClient().swapFromBack(pushPanel());
											}
										
									
										
								
										
									}
									else {
										msg="fill all details";
										popUp(msg);
									}
									
								}
								
								if(rdbtnReportPlannedTraining.isSelected()){
									if((!comboBoxPersonal.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxDay.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMonth.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxYear.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxHour.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMin.getSelectedItem().toString().equals("Choose.."))){
										
										PreformedPersonalTraining = new PreformedPersonalTraining();
										PreformedPersonalTraining.setAthleteId(Athlete.getUserid());
										PreformedPersonalTraining.setIsplanned("true");
										PreformedPersonalTraining.setTrainingId(AthletTraining.getTrainingId());
										msg="'"+comboBoxDay.getSelectedItem().toString()+"'"+"'"+comboBoxMonth.getSelectedItem().toString()+"'"+"'"+comboBoxYear.getSelectedItem().toString()+"'";
										PreformedPersonalTraining.setDate(msg);
										msg="'"+comboBoxHour.getSelectedItem().toString()+"'"+"'"+comboBoxMin.getSelectedItem().toString()+"'";
										PreformedPersonalTraining.setTime(msg);
										activityType=(activitytype)comboBoxActivityType.getSelectedItem();
										PreformedPersonalTraining.setActivityid(activityType.getActivityId());
										trainingType=(trainingtype)comboBoxTrainingType.getSelectedItem();
										PreformedPersonalTraining.setTrainingTypeId(trainingType.getTrainingId());
										PreformedPersonalTraining.setDistance(textFieldDistance.getText());
										PreformedPersonalTraining.setDetails(textFieldDetails.getText());
										PreformedPersonalTraining.setDuration(textFieldDuration.getText());
										
										getClient().sendMsgToServer(new MessageCreateNewUnPlannedTraining(PreformedPersonalTraining));
										MessageCreateNewUnPlannedTrainingReplay rep= (MessageCreateNewUnPlannedTrainingReplay)getClient().getMessageFromServer();
										if(rep.getint()==1){
											msg="Training Report Success";
											popUp(msg);	
											getClient().swapFromBack(pushPanel());
											}
								
										
									}
									else {
										msg="fill all details";
										popUp(msg);
									}
									
								}	
								else{
									msg="Choose Team";
									popUp(msg);
								}
						

						if(rdbtnReportPlannedTraining.isSelected()){
							String msg ;
							PreformedTeamTraining=new PreformedTeamTraining();
							
							//check if activity type change
							 comboBoxTrainingType.addItem("Choose..");
								
							if((comboBoxActivityType.getSelectedItem().toString().equals("choose.."))){
								activitytype activy=(activitytype)comboBoxActivityType.getSelectedItem();
								if(teamTraining.getActivityid()==activy.getActivityId())
									PreformedTeamTraining.setActivityid(teamTraining.getActivityid());
								else
									PreformedTeamTraining.setActivityid(activy.getActivityId());
								}
							else {
								PreformedTeamTraining.setActivityid(teamTraining.getActivityid());
								}
							
							//check if training type change
							if((comboBoxTrainingType.getSelectedItem().toString().equals("choose.."))){
								trainingtype trainingt=(trainingtype)comboBoxTrainingType.getSelectedItem();
								if(teamTraining.getActivityid()==trainingt.getTrainingId())
									PreformedTeamTraining.setTrainingTypeId(teamTraining.getTrainingTypeId());
								else
									PreformedTeamTraining.setTrainingTypeId(trainingt.getTrainingId());
								}
							else {
								PreformedTeamTraining.setTrainingTypeId(teamTraining.getTrainingTypeId());
								}
							
							if(comboBoxDay.isEnabled()&&!comboBoxDay.getSelectedItem().toString().equals("choose..")&&!comboBoxMonth.getSelectedItem().toString().equals("choose..")&&!comboBoxYear.getSelectedItem().toString().equals("choose..")){
								msg=""+comboBoxDay.getSelectedItem().toString()+"/"+""+comboBoxMonth.getSelectedItem().toString()+""+"/"+comboBoxYear.getSelectedItem().toString()+"";
								PreformedTeamTraining.setDate(msg);
							}
							else
								PreformedTeamTraining.setDate(teamTraining.getDate());
								
						
							
							if(!comboBoxHour.getSelectedItem().toString().equals("choose..")&&!comboBoxMin.getSelectedItem().toString().equals("choose..")){
								msg=""+comboBoxHour.getSelectedItem().toString()+""+":"+comboBoxMin.getSelectedItem().toString()+"";
								PreformedTeamTraining.setTime(msg);
							}
							else
								PreformedTeamTraining.setTime(teamTraining.getTime());
							
							
							if(textFieldDetails.getText().equals(""))
								PreformedTeamTraining.setDetails(teamTraining.getDetails());
							else
								PreformedTeamTraining.setDetails(textFieldDetails.getText());
							
							if(textFieldDuration.getText().equals(""))
								PreformedTeamTraining.setDuration(teamTraining.getDuration());
							else
								PreformedTeamTraining.setDuration(textFieldDuration.getText());
							
							if(textFieldDistance.getText().equals(""))
								PreformedTeamTraining.setDistance(teamTraining.getDistance());
							else
								PreformedTeamTraining.setDistance(textFieldDistance.getText());
							PreformedTeamTraining.setAthleteId(Athlete.getUserid());
							PreformedTeamTraining.setTrainingId(teamTraining.getTrainingId());
							
							getClient().sendMsgToServer(new MessageCreateNewPreformedTeamPlannedTraining(PreformedTeamTraining));
							MessageCreateNewPreformedTeamPlannedTrainingReplay rep7= (MessageCreateNewPreformedTeamPlannedTrainingReplay) getClient().getMessageFromServer();
							if(rep7.getint()==1){
								msg="Report Team Training Success.";
								popUp(msg);	
								getClient().swapFromBack(pushPanel());
							}
							else {
								msg="Report Team Training Failed.. try again..";
								popUp(msg);
								
							}
							
						}
						else {
							msg="Fill All Field Include Combox Option Please";
							popUp(msg);
							
						}
						
/************						
						if(rdbtnPersonalTraining.isSelected()){
					
							updatedTraining1=new plannedpersonaltraining();
									
							//check if activity type change
							 comboBoxTrainingType.addItem("Choose..");
								
							if((comboBoxActivityType.getSelectedItem().toString().equals("choose.."))){
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
							if((comboBoxTrainingType.getSelectedItem().toString().equals("choose.."))){
								trainingtype trainingt=(trainingtype)comboBoxTrainingType.getSelectedItem();
								if(AthletTraining.getActivityid()==trainingt.getTrainingId())
									updatedTraining1.setTrainingTypeId(AthletTraining.getTrainingTypeId());
								else
									updatedTraining1.setTrainingTypeId(trainingt.getTrainingId());
								}
							else {
								updatedTraining1.setTrainingTypeId(AthletTraining.getTrainingTypeId());
								}
							
							if(comboBoxDay.isEnabled()&&!comboBoxDay.getSelectedItem().toString().equals("choose..")&&!comboBoxMonth.getSelectedItem().toString().equals("choose..")&&!comboBoxYear.getSelectedItem().toString().equals("choose..")){
								msg=""+comboBoxDay.getSelectedItem().toString()+""+"/"+comboBoxMonth.getSelectedItem().toString()+""+"/"+comboBoxYear.getSelectedItem().toString()+"";
								updatedTraining1.setDate(msg);
							}
							else
								updatedTraining1.setDate(AthletTraining.getDate());
								
						
							
							if(!comboBoxHour.getSelectedItem().toString().equals("choose..")&&!comboBoxMin.getSelectedItem().toString().equals("choose..")){
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
************/						
					}
			
		
					});
					btnReportTrainingDetail.setBounds(237, 474, 157, 23);
					add(btnReportTrainingDetail);	 
		 
		}
		public void init()
		{
			initTextField();
			initComboBox();
			initArrays();
			initJRadioButton();
			initBtn();
			initLabel();
			initTextPane();
			
			 for (int i=0; i<=allPersonalTrainingArray.size(); i++)
				{
					if (i==0) comboBoxPersonal.addItem("Choose..");
					else comboBoxPersonal.addItem(allPersonalTrainingArray.get(i-1));
				}
			
			 for (int i=0; i<=allAactivityTypeArray.size(); i++)
				{
				if (i==0) comboBoxActivityType.addItem("Choose..");
				else comboBoxActivityType.addItem(allAactivityTypeArray.get(i-1));
				}
			 
			 
			 for (int i=0; i<=allTeamTrainingArray.size(); i++)
			    	if (i==0) comboBoxTeam.addItem("Choose..");
				else comboBoxTeam.addItem(allTeamTrainingArray.get(i-1));
			 
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
		Object[] options = {"Ok"};
		JOptionPane.showMessageDialog((Component) getClient(),msg);
			
		return ;
	}
	

	@Override
	public MyJPanel pushPanel() {
		return new AthleteReportTrainingPanel(getClient());
	}
}



