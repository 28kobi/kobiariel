
package Client.Gui;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Client.Logic.ClientIF;
import Server.DataBase.Team;
import Server.DataBase.User;
import Server.DataBase.activitytype;
import Server.DataBase.plannedpersonaltraining;
import Server.DataBase.plannedteamtraining;
import Server.DataBase.trainingtype;
import Server.Message.MessageCreateNewCoach;
import Server.Message.MessageCreateNewCoachReplay;
import Server.Message.MessageCreateNewPersonalTraining;
import Server.Message.MessageCreateNewPersonalTrainingReplay;
import Server.Message.MessageCreateNewTeamTraining;
import Server.Message.MessageCreateNewTeamTrainingReplay;
import Server.Message.MessageGetAllAactivityType;
import Server.Message.MessageGetAllAactivityTypeReplay;
import Server.Message.MessageGetAllAthleteByCoachId;
import Server.Message.MessageGetAllAthleteByCoachIdReplay;
import Server.Message.MessageGetAllTeamByCoachId;
import Server.Message.MessageGetAllTeamByCoachReplay;
import Server.Message.MessageGetAllTrainingType;
import Server.Message.MessageGetAllTrainingTypeReplay;
import Server.Message.MessageGetAllUnTeamedAthlete;
import Server.Message.MessageGetAllUnTeamedAthleteReplay;
import java.lang.Object;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class CreateNewTrainingPanel extends MyJPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxTeams;
	private JComboBox comboBoxAthlete;
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
	private JRadioButton rdbtnTeamTraining;
	private JRadioButton rdbtnPersonalTraining;
	private ArrayList<Team> allTeamArray =null;
	private ArrayList<User> allAthleteArray =null;
	private ArrayList<activitytype> allAactivityTypeArray =null;
	private ArrayList<trainingtype> alltrainingTypeArray =null;
	private activitytype activityType;
	private trainingtype trainingType;
	private plannedteamtraining plannedTeamTraining;
	private plannedpersonaltraining  plannedPersonalTraining;
	private Team  team;
	private User athlete;
	private Button buttonCreatTraining;
	private String msg;
	private String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] year={"2012","2013","2014","2015","2016"};
	private JLabel lblNewLabel;

	
	
	
	
	public CreateNewTrainingPanel(ClientIF client) {
		super(PanelType.CREAT_NEW_TRAINING_PANEL, client);
		setBackground(Color.WHITE);
		setLayout(null);
		BufferedImage myPic;
		try {
			myPic = ImageIO.read(new File("image"+ File.separator+"home.jpg"));
		
			JLabel lblPerformedTraining = new JLabel(new ImageIcon(myPic), JLabel.CENTER);
			lblPerformedTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			lblPerformedTraining.setBounds(321, 7, 98, 23);
			add(lblPerformedTraining);
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 init();
	   
	}
	
	public void initArrays(){
		
		
	       
		allTeamArray = new ArrayList<Team>();
		getClient().sendMsgToServer(new MessageGetAllTeamByCoachId(getClient().getUser().getIdUser()));
		MessageGetAllTeamByCoachReplay rep1= (MessageGetAllTeamByCoachReplay)getClient().getMessageFromServer();
		allTeamArray = rep1.getArray();
		
		allAthleteArray = new ArrayList<User>();
		getClient().sendMsgToServer(new MessageGetAllAthleteByCoachId(getClient().getUser().getIdUser()));
		MessageGetAllAthleteByCoachIdReplay rep2= (MessageGetAllAthleteByCoachIdReplay)getClient().getMessageFromServer();
		allAthleteArray = rep2.getArray();
	
		allAactivityTypeArray = new ArrayList<activitytype>();
		getClient().sendMsgToServer(new MessageGetAllAactivityType());
		MessageGetAllAactivityTypeReplay rep3= (MessageGetAllAactivityTypeReplay)getClient().getMessageFromServer();
		allAactivityTypeArray = rep3.getArray();
		
	}
	


	
	public void initTextField(){
		
		textFieldDistance = new JTextField();
		textFieldDistance.setBounds(148, 286, 199, 25);
		add(textFieldDistance);
		
		
		textFieldDuration = new JTextField();
		textFieldDuration.setBounds(148, 250, 199, 25);
		add(textFieldDuration);
		
		
		textFieldDetails = new JTextField();
		textFieldDetails.setBounds(148, 322, 199, 77);
		add(textFieldDetails);
		
	}
	
	
	 public void initComboBox(){
		 
		    comboBoxTeams = new JComboBox();
		    comboBoxTeams.setBackground(Color.WHITE);
		    comboBoxTeams.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxTeams.setBounds(194, 41, 117, 25);
			add(comboBoxTeams);
			comboBoxTeams.setEnabled(false);
			
		    comboBoxAthlete = new JComboBox();
		    comboBoxAthlete.setBackground(Color.WHITE);
		    comboBoxAthlete.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxAthlete.setBounds(194, 72, 117, 25);
			comboBoxAthlete.setEnabled(false);
			add(comboBoxAthlete);
			
			comboBoxDay = new JComboBox();
			comboBoxDay.setBackground(Color.WHITE);
			comboBoxDay.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxDay.setBounds(160, 104, 60, 25);
			comboBoxDay.setEnabled(false);
			add(comboBoxDay);
			
			comboBoxMonth = new JComboBox();
			comboBoxMonth.setBackground(Color.WHITE);
			comboBoxMonth.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxMonth.setBounds(302, 104, 61, 25);			
			 for (int i=0; i<=month.length; i++)
				{
					if (i==0) comboBoxMonth.addItem("Choose..");
					else comboBoxMonth.addItem(month[i-1]);
					}
			add(comboBoxMonth);
			
			comboBoxYear = new JComboBox();
			comboBoxYear.setBackground(Color.WHITE);
			comboBoxYear.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxYear.setBounds(423, 104, 71, 25);
			 for (int j=0; j<=year.length; j++)
				{
					if (j==0) comboBoxYear.addItem("Choose..");
					else comboBoxYear.addItem(year[j-1]);
					}
			add(comboBoxYear);
			
			comboBoxHour = new JComboBox();
			comboBoxHour.setBackground(Color.WHITE);
			comboBoxHour.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxHour.setBounds(160, 139, 60, 25);
			for(int hour=0;hour<25;hour++){
				if(hour==0) comboBoxHour.addItem("choose..");
				else comboBoxHour.addItem(Integer.toString(hour));
				
			}
			add(comboBoxHour);
						
			comboBoxMin = new JComboBox();
			comboBoxMin.setBackground(Color.WHITE);
			comboBoxMin.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxMin.setBounds(302, 140, 61, 25);
			for(int min=0;min<75;min=min+15){
				if(min==0) comboBoxMin.addItem("choose..");
				else comboBoxMin.addItem(Integer.toString(min));
				
			}
			add(comboBoxMin);
			
			comboBoxActivityType = new JComboBox();		
			comboBoxActivityType.setBackground(Color.WHITE);
			comboBoxActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
			
			comboBoxActivityType.setBounds(151, 172, 109, 25);
			add(comboBoxActivityType);
						
			comboBoxTrainingType = new JComboBox();
			comboBoxTrainingType.setBackground(Color.WHITE);
			comboBoxTrainingType.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxTrainingType.setBounds(151, 210, 109, 25);
			add(comboBoxTrainingType);
			comboBoxTrainingType.setEnabled(false);
	 }

	 public void initLabels(){
		 
		 	lblDetails = new JLabel("Details: ");
		 	lblDetails.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDetails.setBounds(6, 321, 109, 25);
			add(lblDetails);
					
			lblDuration = new JLabel("Duration: ");
			lblDuration.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDuration.setBounds(6, 249, 82, 25);
			add(lblDuration);
					
			lblDistance = new JLabel("Distance:");
			lblDistance.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDistance.setBounds(6, 285, 82, 25);
			add(lblDistance);
			
			lblTrainingDate = new JLabel(" Date:");
			lblTrainingDate.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTrainingDate.setBounds(6, 104, 91, 25);
			add(lblTrainingDate);
			
			lblDay = new JLabel("Day:");
			lblDay.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDay.setBounds(107, 104, 46, 25);
			add(lblDay);
			
			lblMonth = new JLabel("Month:");
			lblMonth.setFont(new Font("Arial", Font.PLAIN, 15));
			lblMonth.setBounds(246, 104, 46, 25);
			add(lblMonth);
			
			lblYear = new JLabel("Year:");
			lblYear.setFont(new Font("Arial", Font.PLAIN, 15));
			lblYear.setBounds(373, 104, 46, 25);
			add(lblYear);
			
			lblHour = new JLabel("Hour:");
			lblHour.setFont(new Font("Arial", Font.PLAIN, 15));
			lblHour.setBounds(104, 139, 53, 25);
			add(lblHour);
			
			lblMi = new JLabel("Min:");
			lblMi.setFont(new Font("Arial", Font.PLAIN, 15));
			lblMi.setBounds(246, 139, 46, 25);
			add(lblMi);
			
			lblTime = new JLabel("Time:");
			lblTime.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTime.setBounds(6, 139, 68, 25);
			add(lblTime);
			
			lblTrainingType = new JLabel("Training Type :");
			lblTrainingType.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTrainingType.setBounds(6, 213, 105, 25);
			add(lblTrainingType);
			
			lblActivityType = new JLabel("Activity Type:");
			lblActivityType.setFont(new Font("Arial", Font.PLAIN, 15));
			lblActivityType.setBounds(6, 175, 105, 25);
			add(lblActivityType);
		 
	 }
	 
	 public void initJRadioButton(){
		   
		    rdbtnTeamTraining = new JRadioButton("Team Training");
		    rdbtnTeamTraining.setFont(new Font("Arial", Font.PLAIN, 15));
		    rdbtnTeamTraining.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    			if(rdbtnTeamTraining.isSelected()){
		    				comboBoxTeams.setEnabled(true);
		    				comboBoxAthlete.setEnabled(false);
		    				if(rdbtnPersonalTraining.isSelected())
		    					rdbtnPersonalTraining.doClick();
		    				comboBoxTeams.setEnabled(true);
		    			}
		    			else 
		    				comboBoxTeams.setEnabled(false);	
		    			
		    			
		    	}
		    });
			rdbtnTeamTraining.setBounds(6, 41, 147, 25);
			add(rdbtnTeamTraining);
			
			rdbtnPersonalTraining = new JRadioButton("Personal Training");
			rdbtnPersonalTraining.setFont(new Font("Arial", Font.PLAIN, 15));
			rdbtnPersonalTraining.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnPersonalTraining.isSelected()){
						comboBoxAthlete.setEnabled(true);
						comboBoxTeams.setEnabled(false);
	    				if(rdbtnTeamTraining.isSelected())
	    					rdbtnTeamTraining.doClick();
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

			rdbtnPersonalTraining.setBounds(6, 72, 147, 25);
			add(rdbtnPersonalTraining); 
			
			
	 }
	
	 public void initbutton(){
		
		 buttonCreatTraining = new Button("Create Training");
		 buttonCreatTraining.setBackground(new Color(230, 230, 250));
		 buttonCreatTraining.setFont(new Font("Arial", Font.PLAIN, 15));
		 buttonCreatTraining.setForeground(Color.BLUE);
		 buttonCreatTraining.setActionCommand("CreateTraining");
		 buttonCreatTraining.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnTeamTraining.isSelected()){
						if(!comboBoxTeams.getSelectedItem().toString().equals("Choose..")){
							if((!comboBoxDay.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMonth.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxYear.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxHour.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMin.getSelectedItem().toString().equals("Choose.."))){
								team=(Team)comboBoxTeams.getSelectedItem();
								plannedTeamTraining = new plannedteamtraining();
								plannedTeamTraining.setTeamId(team.getTeamId());	
								msg=""+comboBoxDay.getSelectedItem().toString()+"/"+""+comboBoxMonth.getSelectedItem().toString()+"/"+""+comboBoxYear.getSelectedItem().toString()+"";
								plannedTeamTraining.setDate(msg);
								msg=""+comboBoxHour.getSelectedItem().toString()+""+":"+comboBoxMin.getSelectedItem().toString()+"";
								plannedTeamTraining.setTime(msg);
								activityType=(activitytype)comboBoxActivityType.getSelectedItem();
								plannedTeamTraining.setActivityid(activityType.getActivityId());
								trainingType=(trainingtype)comboBoxTrainingType.getSelectedItem();
								plannedTeamTraining.setTrainingTypeId(trainingType.getTrainingId());
								plannedTeamTraining.setDistance(textFieldDistance.getText());
								plannedTeamTraining.setDetails(textFieldDetails.getText());
								plannedTeamTraining.setDuration(textFieldDuration.getText());
								
								getClient().sendMsgToServer(new MessageCreateNewTeamTraining(plannedTeamTraining));
								MessageCreateNewTeamTrainingReplay rep= (MessageCreateNewTeamTrainingReplay)getClient().getMessageFromServer();
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
					if(rdbtnPersonalTraining.isSelected()){
						if(!comboBoxAthlete.getSelectedItem().toString().equals("Choose..")){
							if((!comboBoxDay.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMonth.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxYear.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxHour.getSelectedItem().toString().equals("Choose.."))&&(!comboBoxMin.getSelectedItem().toString().equals("Choose.."))){
								athlete=(User)comboBoxAthlete.getSelectedItem();
								plannedPersonalTraining = new plannedpersonaltraining();
								plannedPersonalTraining.setathleteId(athlete.getIdUser());
								msg="'"+comboBoxDay.getSelectedItem().toString()+"/"+""+comboBoxMonth.getSelectedItem().toString()+""+"/"+comboBoxYear.getSelectedItem().toString()+"";
								plannedPersonalTraining.setDate(msg);
								msg=""+comboBoxHour.getSelectedItem().toString()+""+":"+comboBoxMin.getSelectedItem().toString()+"";
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
			});
		 buttonCreatTraining.setBounds(219, 425, 125, 30);
			add(buttonCreatTraining);
		 
		 
		 
	 }
	 public void init(){
		 
		 initTextField();
		 initComboBox();
		 initLabels();
		 initJRadioButton();
		 initArrays();
		 initbutton();
		 
		 comboBoxDay.addItem("Choose..");
		 comboBoxTrainingType.addItem("Choose..");
		 
		 lblNewLabel = new JLabel("Create New Training:");
		 lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		 lblNewLabel.setBounds(10, 11, 250, 23);
		 add(lblNewLabel);
		 
		 for (int i=0; i<=allTeamArray.size(); i++)
			{
				if (i==0) comboBoxTeams.addItem("Choose..");
				else comboBoxTeams.addItem(allTeamArray.get(i-1));
				}
		  
		  for (int i=0; i<=allAthleteArray.size(); i++)
			{
				if (i==0) comboBoxAthlete.addItem("Choose..");
				else comboBoxAthlete.addItem(allAthleteArray.get(i-1));
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
					comboBoxDay.removeAll();
					comboBoxDay.validate();
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
		return new CreateNewTrainingPanel(getClient());
	}
}



