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
import Server.GUI.MyJTable;
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
import Server.Message.MessageGetAllTeamUnPreformedTrainingByTeamIdReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;
import Server.Message.MessageGetAllUnPreformedPersonalTrainingByAtleteId;
import Server.Message.MessageGetAllUnPreformedPersonalTrainingByAtleteIdReplay;
import Server.Message.MessageGetAllUnPreformedTeamTrainingByTeamId;
import Server.Message.MessageGetAthleteByUserId;
import Server.Message.MessageGetAthleteByUserIdReplay;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;


public class AthleteReportTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	private JRadioButton rdbtnReportUnPlannedTraining;
	private JRadioButton rdbtnReportPlannedTraining;
	private JButton btnReportTrainingDetail;
	private JButton btnResetTrainingDetail;

	private PreformedPersonalTraining PreformedPersonalTraining;
	private PreformedTeamTraining PreformedTeamTraining;
	private String msg;
	private athlete Athlete;
	private activitytype activityType;
	private trainingtype trainingType;
	private ArrayList<plannedteamtraining> ChoosenTeamTrainingArray =null;
	private ArrayList<plannedpersonaltraining> ChoosenPersonalTrainingArray =null;
	private plannedteamtraining teamTraining =null;
	private plannedpersonaltraining personalTraining =null;
	
	private plannedpersonaltraining AthletTraining;
	
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	
	private ArrayList<plannedpersonaltraining> allUnPreformedPersonalTrainingArray =null;
	private ArrayList<plannedteamtraining> allUnPreformedTeamTrainingArray =null;
	
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
	private JLabel lblHereYouCan;
	private JTextField textFieldDetails;
	private JTextField textFieldDuration;
	private JTextField textFieldDistance ;
	private String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] year={"2012","2013","2014","2015","2016"};
	
	private AthelteViewPlannedTeamTrainingTableModel stm;
	private AthelteViewPlannedPersonalTrainingTableModel stm2;
	private MyJTable table;
	private MyJTable table2;

	
   
    
	
	
	public AthleteReportTrainingPanel(ClientIF client) {
		super(PanelType.ATHLETE_REPORT_TRAINING_PANEL, client);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPlannedTrainging = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPlannedTrainging.setFont(new Font("Arial", Font.PLAIN, 15));
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
			 rdbtnReportUnPlannedTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			 rdbtnReportUnPlannedTraining.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
					if(rdbtnReportUnPlannedTraining.isSelected()){
						if(rdbtnReportPlannedTraining.isSelected())
							rdbtnReportPlannedTraining.doClick();
					
						comboBoxTeam.setVisible(false);
						comboBoxPersonal.setVisible(false);
						table.setVisible(false);
						table2.setVisible(false);
						lblChooseTraining.setVisible(false);
						lblTeamTraining.setVisible(false);
						lblPersonalTraining.setVisible(false);
						btnResetTrainingDetail.setVisible(false);
					}
					
			 	}
			 });
			 rdbtnReportUnPlannedTraining.setBounds(6, 23, 218, 23);
				add(rdbtnReportUnPlannedTraining);
				
				
				
				
				rdbtnReportPlannedTraining = new JRadioButton("Report Planned Training");
				rdbtnReportPlannedTraining.setFont(new Font("Arial", Font.PLAIN, 15));
				rdbtnReportPlannedTraining.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnReportPlannedTraining.isSelected()){
							if(rdbtnReportUnPlannedTraining.isSelected())
							rdbtnReportUnPlannedTraining.doClick();
							

							comboBoxTeam.setVisible(true);
							comboBoxTeam.setEnabled(true);
							comboBoxPersonal.setEnabled(true);
							comboBoxPersonal.setVisible(true);						
							table.setVisible(true);
							table2.setVisible(true);
							lblChooseTraining.setVisible(true);
							lblTeamTraining.setVisible(true);
							lblPersonalTraining.setVisible(true);
							btnResetTrainingDetail.setVisible(true);
						
							}
						else{
										
							comboBoxTeam.setVisible(false);
							comboBoxPersonal.setVisible(false);						
							table.setVisible(false);
							table2.setVisible(false);
							comboBoxTeam.setEnabled(false);
							comboBoxPersonal.setEnabled(false);
							lblChooseTraining.setVisible(false);
							lblTeamTraining.setVisible(false);
							lblPersonalTraining.setVisible(false);
							btnResetTrainingDetail.setVisible(false);
						
						}
					}
				});
				rdbtnReportPlannedTraining.setBounds(6, 49, 218, 23);
				add(rdbtnReportPlannedTraining);
		 }
		 
		 public void initArrays(){
				
		       
				allAactivityTypeArray = new ArrayList<activitytype>();
				getClient().sendMsgToServer(new MessageGetAllAactivityType());
				MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
				allAactivityTypeArray = rep3.getArray();
			
				
				
				allUnPreformedTeamTrainingArray = new ArrayList<plannedteamtraining>();
				getClient().sendMsgToServer(new MessageGetAllUnPreformedTeamTrainingByTeamId(Athlete.getTeamId()));
				MessageGetAllTeamUnPreformedTrainingByTeamIdReplay rep5= (MessageGetAllTeamUnPreformedTrainingByTeamIdReplay)getClient().getMessageFromServer();
				allUnPreformedTeamTrainingArray = rep5.getArray();
				
				allUnPreformedPersonalTrainingArray= new ArrayList<plannedpersonaltraining>();
				getClient().sendMsgToServer(new MessageGetAllUnPreformedPersonalTrainingByAtleteId(Athlete.getUserid()));
			  	MessageGetAllUnPreformedPersonalTrainingByAtleteIdReplay rep6= (MessageGetAllUnPreformedPersonalTrainingByAtleteIdReplay)getClient().getMessageFromServer();
			  	allUnPreformedPersonalTrainingArray = rep6.getPersonalTrainingArray();
			
			}
		
		 public void initComboBox(){
			  	comboBoxTeam = new JComboBox();
			  	comboBoxTeam.setBackground(Color.WHITE);
			  	comboBoxTeam.setFont(new Font("Arial", Font.PLAIN, 15));
			  	comboBoxTeam.setVisible(false);
			  	
			  	comboBoxTeam.addActionListener(new ActionListener() {
			  		public void actionPerformed(ActionEvent e) {
			  			
			  			
			  			if(!comboBoxTeam.getSelectedItem().toString().equals("Choose..")){
			  				comboBoxPersonal.setEnabled(false);
			  				table2.setVisible(false);
			  				
			  				
			  				ChoosenTeamTrainingArray=new ArrayList<plannedteamtraining>();
			  				teamTraining=(plannedteamtraining)comboBoxTeam.getSelectedItem();
			  				ChoosenTeamTrainingArray.add(teamTraining);
							stm.setArray(ChoosenTeamTrainingArray);
							
						
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
							
						
						
							}
			  			
			  			
			  		}
			  	});
			  	comboBoxTeam.setBounds(122, 113, 126, 25);
			   add(comboBoxTeam);
			   
				
				comboBoxPersonal = new JComboBox();				
				comboBoxPersonal.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxPersonal.setBackground(Color.WHITE);
				comboBoxPersonal.setVisible(false);
				comboBoxPersonal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						
						if(!comboBoxPersonal.getSelectedItem().toString().equals("Choose..")){
							comboBoxTeam.setEnabled(false);
							table.setVisible(false);
							
							ChoosenPersonalTrainingArray=new ArrayList<plannedpersonaltraining>();
			  				personalTraining=(plannedpersonaltraining)comboBoxPersonal.getSelectedItem();
			  				ChoosenPersonalTrainingArray.add(personalTraining);
							stm2.setArray(ChoosenPersonalTrainingArray);
							
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
						
							}
						
						
					}
				});
				comboBoxPersonal.setBounds(404, 113, 126, 25);
				add(comboBoxPersonal);
			
				comboBoxDay = new JComboBox();
				comboBoxDay.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxDay.setBackground(Color.WHITE);
				comboBoxDay.setBounds(254, 258, 97, 25);
				comboBoxDay.setEnabled(false);
				add(comboBoxDay);
				
				comboBoxMonth = new JComboBox();
				comboBoxMonth.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxMonth.setBackground(Color.WHITE);
				comboBoxMonth.setBounds(448, 258, 97, 25);			
				 for (int i=0; i<=month.length; i++)
					{
						if (i==0) comboBoxMonth.addItem("Choose..");
						else comboBoxMonth.addItem(month[i-1]);
						}
				add(comboBoxMonth);
				
				comboBoxYear = new JComboBox();
				comboBoxYear.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxYear.setBackground(Color.WHITE);
				comboBoxYear.setBounds(626, 258, 87, 25);
				 for (int j=0; j<=year.length; j++)
					{
						if (j==0) comboBoxYear.addItem("Choose..");
						else comboBoxYear.addItem(year[j-1]);
						}
				add(comboBoxYear);
				
				comboBoxHour = new JComboBox();
				comboBoxHour.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxHour.setBackground(Color.WHITE);
				comboBoxHour.setBounds(254, 294, 97, 25);
				for(int hour=0;hour<25;hour++){
					if(hour==0) comboBoxHour.addItem("Choose..");
					else comboBoxHour.addItem(Integer.toString(hour));
							
				}
				add(comboBoxHour);
							
				comboBoxMin = new JComboBox();
				comboBoxMin.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxMin.setBackground(Color.WHITE);
				comboBoxMin.setBounds(448, 294, 97, 25);
				for(int min=0;min<75;min=min+15){
					if(min==0) comboBoxMin.addItem("Choose..");
					else comboBoxMin.addItem(Integer.toString(min));
					
				}
				add(comboBoxMin);
				
				comboBoxActivityType = new JComboBox();		
				comboBoxActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxActivityType.setBackground(Color.WHITE);
				comboBoxActivityType.setBounds(150, 320, 98, 25);
				add(comboBoxActivityType);
				comboBoxActivityType.setEnabled(true);
				
							
				comboBoxTrainingType = new JComboBox();
				comboBoxTrainingType.setFont(new Font("Arial", Font.PLAIN, 15));
				comboBoxTrainingType.setBackground(Color.WHITE);
				comboBoxTrainingType.setBounds(150, 351, 98, 25);
				add(comboBoxTrainingType);
				comboBoxTrainingType.setEnabled(false);
		
			  
			
		};
		
		
		public void initLabel(){
			

			lblTeamTraining = new JLabel("Team Training :");
			lblTeamTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTeamTraining.setBounds(6, 116, 106, 25);
			add(lblTeamTraining);
			lblTeamTraining.setVisible(false);
			
			lblPersonalTraining = new JLabel("Personal Training :");
			lblPersonalTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblPersonalTraining.setBounds(266, 116, 128, 25);
			add(lblPersonalTraining);
			lblPersonalTraining.setVisible(false);
			

			lblChooseTraining = new JLabel("Choose Training:");
			lblChooseTraining.setFont(new Font("Arial", Font.PLAIN, 20));
			lblChooseTraining.setBounds(6, 79, 218, 23);
			add(lblChooseTraining);
			lblChooseTraining.setVisible(false);
			
			lblDetails = new JLabel("Details: ");
			lblDetails.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails.setBounds(6, 387, 68, 25);
			add(lblDetails);
					
			lblDuration = new JLabel("Duration: ");
			lblDuration.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration.setBounds(6, 412, 82, 25);
			add(lblDuration);
					
			lblDistance = new JLabel("Distance:");
			lblDistance.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance.setBounds(6, 437, 82, 25);
			add(lblDistance);
			
			lblTrainingDate = new JLabel("Training Date:");
			lblTrainingDate.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTrainingDate.setBackground(new Color(240, 240, 240));
			lblTrainingDate.setBounds(6, 261, 97, 25);
			add(lblTrainingDate);
			
			lblDay = new JLabel("Day:");
			lblDay.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDay.setBounds(188, 258, 46, 25);
			add(lblDay);
			
			lblMonth = new JLabel("Month:");
			lblMonth.setFont(new Font("Arial", Font.PLAIN, 15));
			lblMonth.setBounds(370, 258, 68, 25);
			add(lblMonth);
			
			lblYear = new JLabel("Year:");
			lblYear.setFont(new Font("Arial", Font.PLAIN, 15));
			lblYear.setBounds(571, 258, 46, 25);
			add(lblYear);
			
			lblHour = new JLabel("Hour:");
			lblHour.setFont(new Font("Arial", Font.PLAIN, 15));
			lblHour.setBounds(188, 294, 53, 25);
			add(lblHour);
			
			lblMi = new JLabel("Min:");
			lblMi.setFont(new Font("Arial", Font.PLAIN, 15));
			lblMi.setBounds(380, 294, 33, 25);
			add(lblMi);
			
			lblTime = new JLabel("Time:");
			lblTime.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime.setBounds(6, 292, 68, 25);
			add(lblTime);
			
			lblTrainingType = new JLabel("Training Type :");
			lblTrainingType.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTrainingType.setBounds(6, 354, 105, 25);
			add(lblTrainingType);
			
			lblActivityType = new JLabel("Activity Type:");
			lblActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
			lblActivityType.setBounds(6, 323, 105, 25);
			add(lblActivityType);
			
			lblHereYouCan = new JLabel(" Training Report Form :");
			lblHereYouCan.setBackground(Color.LIGHT_GRAY);
			lblHereYouCan.setFont(new Font("Arial", Font.PLAIN, 20));
			lblHereYouCan.setBounds(0, 218, 428, 32);
			add(lblHereYouCan);	
			
		}
		
		public void initTextField(){
			
			textFieldDistance = new JTextField();
			textFieldDistance.setBounds(150, 432, 311, 25);
			add(textFieldDistance);
			
			
			textFieldDuration = new JTextField();
			textFieldDuration.setBounds(150, 408, 311, 25);
			add(textFieldDuration);
			
			
			textFieldDetails = new JTextField();
			textFieldDetails.setBounds(150, 383, 311, 25);
			add(textFieldDetails);
			
		}

		
		private void initBtn() {
			
			 btnResetTrainingDetail = new JButton("Reset Training Detail");
			 btnResetTrainingDetail.setForeground(Color.BLUE);
			 btnResetTrainingDetail.setFont(new Font("Arial", Font.PLAIN, 15));
			btnResetTrainingDetail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getClient().swapFromBack(pushPanel());
				}
			});
			btnResetTrainingDetail.setBounds(554, 115, 175, 30);
			add(btnResetTrainingDetail);
			btnResetTrainingDetail.setVisible(false);
			
			
			
			
			btnReportTrainingDetail = new JButton("Report Training Detail");
			btnReportTrainingDetail.setFont(new Font("Arial", Font.PLAIN, 15));
			btnReportTrainingDetail.setForeground(Color.BLUE);
			btnReportTrainingDetail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!rdbtnReportUnPlannedTraining.isSelected()&&!rdbtnReportPlannedTraining.isSelected()){
						msg="Please Select Planned Or Unplanned Radio Button";
						popUp(msg);
						return ;
						
					}
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
									if(comboBoxPersonal.isEnabled()){
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
											return ;
											}
								
										
									}
									else {
										msg="fill all details";
										popUp(msg);
										
									}
									}
								}	
								
						

						if(rdbtnReportPlannedTraining.isSelected()){
							String msg ;
							PreformedTeamTraining=new PreformedTeamTraining();
							
							//check if activity type change
							 comboBoxTrainingType.addItem("Choose..");
								
							if((comboBoxActivityType.getSelectedItem().toString().equals("Choose.."))){
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
							if((comboBoxTrainingType.getSelectedItem().toString().equals("Choose.."))){
								trainingtype trainingt=(trainingtype)comboBoxTrainingType.getSelectedItem();
								if(teamTraining.getActivityid()==trainingt.getTrainingId())
									PreformedTeamTraining.setTrainingTypeId(teamTraining.getTrainingTypeId());
								else
									PreformedTeamTraining.setTrainingTypeId(trainingt.getTrainingId());
								}
							else {
								PreformedTeamTraining.setTrainingTypeId(teamTraining.getTrainingTypeId());
								}
							
							if(comboBoxDay.isEnabled()&&!comboBoxDay.getSelectedItem().toString().equals("Choose..")&&!comboBoxMonth.getSelectedItem().toString().equals("Choose..")&&!comboBoxYear.getSelectedItem().toString().equals("Choose..")){
								msg=""+comboBoxDay.getSelectedItem().toString()+"/"+""+comboBoxMonth.getSelectedItem().toString()+""+"/"+comboBoxYear.getSelectedItem().toString()+"";
								PreformedTeamTraining.setDate(msg);
							}
							else
								PreformedTeamTraining.setDate(teamTraining.getDate());
								
						
							
							if(!comboBoxHour.getSelectedItem().toString().equals("Choose..")&&!comboBoxMin.getSelectedItem().toString().equals("Choose..")){
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
								return ;
							}
							else {
								msg="Report Team Training Failed.. try again..";
								popUp(msg);
								
							}
							
						}
						if(!rdbtnReportUnPlannedTraining.isSelected()){
							msg="Fill All Field Include Combox Option Please";
							popUp(msg);
							
						}
						

					}
			
		
					});
					btnReportTrainingDetail.setBounds(237, 474, 191, 30);
					add(btnReportTrainingDetail);	
					
		 
		}
		private void initTable() {
		stm = new AthelteViewPlannedTeamTrainingTableModel();		
		table = new MyJTable(stm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(6, 153, 772, 65);
		add(table);
		table.setVisible(false);
		
		stm2 = new AthelteViewPlannedPersonalTrainingTableModel();		
		table2 = new MyJTable(stm2);
		table2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table2.setBounds(6, 153, 772, 65);
		add(table2);
		table2.setVisible(false);
		
		}
		public void init()
		{
			initTextField();
			initComboBox();
			initArrays();
			initJRadioButton();
			initBtn();
			initLabel();
		
			initTable();
			
		
			comboBoxTrainingType.addItem("Choose..");
			comboBoxDay.addItem("Choose..");
			
			
			 for (int i=0; i<=allUnPreformedPersonalTrainingArray.size(); i++)
				{
					if (i==0) comboBoxPersonal.addItem("Choose..");
					else comboBoxPersonal.addItem(allUnPreformedPersonalTrainingArray.get(i-1));
				}
			
			 for (int i=0; i<=allAactivityTypeArray.size(); i++)
				{
				if (i==0) comboBoxActivityType.addItem("Choose..");
				else comboBoxActivityType.addItem(allAactivityTypeArray.get(i-1));
				}
			 
			 
			 for (int i=0; i<=allUnPreformedTeamTrainingArray.size(); i++)
			    	if (i==0) comboBoxTeam.addItem("Choose..");
				else comboBoxTeam.addItem(allUnPreformedTeamTrainingArray.get(i-1));
			 
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



