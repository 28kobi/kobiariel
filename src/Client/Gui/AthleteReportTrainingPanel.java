package Client.Gui;
import java.awt.Component;
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

import Client.Logic.ClientIF;
import Server.DataBase.PreformedPersonalTraining;
import Server.DataBase.activitytype;
import Server.DataBase.athlete;
import Server.DataBase.athleteQuery;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.trainingtype;
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
	private String msg;
	private athlete Athlete;
	private activitytype activityType;
	private trainingtype trainingType;
	
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	private ArrayList<plannedpersonaltraining> allPersonalTrainingArray =null;
	private ArrayList<plannedteamtraining> allTeamTrainingArray =null;
	private JComboBox comboBoxTeam ;
	private JComboBox comboBoxPersonal;
	
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
						if(rdbtnReportPlannedTraining.isSelected())
						rdbtnReportPlannedTraining.doClick();
						
					}
					else{
			 	
						comboBoxTeam.setEnabled(true);
						comboBoxPersonal.setEnabled(true);
						rdbtnReportPlannedTraining.setEnabled(true);
						
						
						
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
						}
						else
							rdbtnReportUnPlannedTraining.setEnabled(true);
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
			  	comboBoxTeam.setBounds(175, 96, 126, 20);
			   add(comboBoxTeam);
				
				comboBoxPersonal = new JComboBox();
				comboBoxPersonal.setBounds(435, 96, 105, 20);
				add(comboBoxPersonal);
			
				comboBoxDay = new JComboBox();
				comboBoxDay.setMaximumRowCount(32);
				comboBoxDay.setBounds(151, 180, 97, 20);
				comboBoxDay.setEnabled(false);
				add(comboBoxDay);
				
				comboBoxMonth = new JComboBox();
				comboBoxMonth.setMaximumRowCount(13);
				comboBoxMonth.setBounds(301, 180, 82, 20);			
				 for (int i=0; i<=month.length; i++)
					{
						if (i==0) comboBoxMonth.addItem("Choose..");
						else comboBoxMonth.addItem(month[i-1]);
						}
				add(comboBoxMonth);
				
				comboBoxYear = new JComboBox();
				comboBoxYear.setBounds(435, 180, 87, 20);
				 for (int j=0; j<=year.length; j++)
					{
						if (j==0) comboBoxYear.addItem("Choose..");
						else comboBoxYear.addItem(year[j-1]);
						}
				add(comboBoxYear);
				
				comboBoxHour = new JComboBox();
				comboBoxHour.setMaximumRowCount(25);
				comboBoxHour.setBounds(151, 210, 97, 20);
				for(int hour=0;hour<25;hour++){
					if(hour==0) comboBoxHour.addItem("choose..");
					else comboBoxHour.addItem(Integer.toString(hour));
							
				}
				add(comboBoxHour);
							
				comboBoxMin = new JComboBox();
				comboBoxMin.setBounds(301, 210, 82, 20);
				for(int min=0;min<75;min=min+15){
					if(min==0) comboBoxMin.addItem("choose..");
					else comboBoxMin.addItem(Integer.toString(min));
					
				}
				add(comboBoxMin);
				
				comboBoxActivityType = new JComboBox();		
				comboBoxActivityType.setBounds(150, 240, 98, 20);
				add(comboBoxActivityType);
				comboBoxActivityType.setEnabled(true);
				
							
				comboBoxTrainingType = new JComboBox();
				comboBoxTrainingType.setBounds(150, 270, 98, 20);
				add(comboBoxTrainingType);
				comboBoxTrainingType.setEnabled(false);
		
			  
			
		};	
		
		public void initLabel(){
			

			 lblTeamTraining = new JLabel("Team Training :");
			lblTeamTraining.setBounds(83, 99, 82, 14);
			add(lblTeamTraining);
			
			 lblPersonalTraining = new JLabel("Personal Training :");
			lblPersonalTraining.setBounds(311, 99, 114, 14);
			add(lblPersonalTraining);
			

			lblChooseTraining = new JLabel("choose training:");
			lblChooseTraining.setBounds(6, 79, 105, 14);
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
			lblMonth.setBounds(256, 183, 35, 14);
			add(lblMonth);
			
			lblYear = new JLabel("year:");
			lblYear.setBounds(392, 183, 46, 14);
			add(lblYear);
			
			lblHour = new JLabel("hour:");
			lblHour.setBounds(93, 210, 53, 14);
			add(lblHour);
			
			lblMi = new JLabel("min:");
			lblMi.setBounds(258, 213, 33, 14);
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
			textFieldDistance.setBounds(150, 360, 311, 24);
			add(textFieldDistance);
			
			
			textFieldDuration = new JTextField();
			textFieldDuration.setBounds(150, 330, 311, 23);
			add(textFieldDuration);
			
			
			textFieldDetails = new JTextField();
			textFieldDetails.setBounds(150, 300, 311, 23);
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
											msg="training added";
											popUp(msg);	
											}
								
										
									}
									else {
										msg="fill all details";
										popUp(msg);
									}
									
								}	
								else{
									msg="choose team";
									popUp(msg);
								}
									
							}
				/*
							if(rdbtnReportPlannedTraining.isSelected()){
								if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){
									if((!comboBoxDay.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMonth.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxYear.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxHour.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMin.getSelectedItem().toString().equals("Choose.."))){
										athlete=(User)comboBoxAthlete.getSelectedItem();
										plannedPersonalTraining = new plannedpersonaltraining();
										plannedPersonalTraining.setathleteId(athlete.getIdUser());
										msg="'"+comboBoxDay.getSelectedItem().toString()+"'"+"'"+comboBoxMonth.getSelectedItem().toString()+"'"+"'"+comboBoxYear.getSelectedItem().toString()+"'";
										plannedPersonalTraining.setDate(msg);
										msg="'"+comboBoxHour.getSelectedItem().toString()+"'"+"'"+comboBoxMin.getSelectedItem().toString()+"'";
										plannedPersonalTraining.setTime(msg);
										activityType=(activitytype)comboBoxActivityType.getSelectedItem();
										plannedPersonalTraining.setActivityid(activityType.getActivityId());
										trainingType=(trainingtype)comboBoxTrainingType.getSelectedItem();
										plannedPersonalTraining.setTrainingTypeId(trainingType.getTrainingId());
										plannedPersonalTraining.setDistance(textFieldDistance.getText());
										plannedPersonalTraining.setDetails(textFieldDetails.getText());
										plannedPersonalTraining.setDuration(textFieldDuration.getText());
										
										getClient().sendMsgToServer(new MessageCreateNewPersonalTraining(plannedPersonalTraining));
										MessageCreateNewPersonalTrainingReplay rep= (MessageCreateNewPersonalTrainingReplay)getClient().getMessageFromServer();
										if(rep.getint()==1){
											msg="training added";
											popUp(msg);	
											}
										
									}
									else {
										msg="fill all details";
										popUp(msg);
									}
									
								}	
								else{
									msg="choose athlete";
									popUp(msg);
								}
							}	
							if((!rdbtnPersonalTraining.isSelected())&&((!rdbtnTeamTraining.isSelected()))) {
								
								msg="choose if you like to create team training or athlete training";
								popUp(msg);
								
						    	}
							
						}
						*/
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



